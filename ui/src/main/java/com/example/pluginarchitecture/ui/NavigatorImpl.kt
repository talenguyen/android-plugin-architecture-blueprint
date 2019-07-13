package com.example.pluginarchitecture.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.pluginarchitecture.core.Feature
import com.example.pluginarchitecture.navigation.Navigator


/**
 * Created by kietnlt on 12 Jul 2019.
 */
class NavigatorImpl(
    private val fragmentActivity: AppCompatActivity
) : Navigator {
    fun onCreate(savedInstanceState: Bundle?) {
        if (savedInstanceState == null) {
            navHost = NavHostFragment()
            fragmentActivity.supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, navHost)
                .commit()
        }
    }

    // Find the resourceId of the graph we want to attach
    private lateinit var navController: NavController
    private lateinit var navHost: NavHostFragment

    fun onStart() {
        navController = navHost.navController

        if (isOpenFromLink()) {
            openLink()
        } else {
            startWith(Feature.Listing)
        }
    }

    private fun isOpenFromLink(): Boolean {
        return fragmentActivity.intent.data?.toString()?.let {
            it.startsWith("example://") || it.startsWith("https://example.com")
        } == true
    }

    private fun openLink() {
        val uri = requireNotNull(fragmentActivity.intent.data)
        try {
            val detailId = uri.pathSegments.last().toString()
            startWithDetail(detailId)
        } catch (ignore: Throwable) {
            startWith(Feature.Listing)
        }
    }

    fun navigateUp(): Boolean {
        return navController.navigateUp()
    }

    private val listingId: Int by lazy { obtainAndSetupDestinationIdOf(Feature.Listing) }

    private val detailId: Int by lazy { obtainAndSetupDestinationIdOf(Feature.Detail) }

    private fun obtainAndSetupDestinationIdOf(feature: Feature): Int {
        val graph = navController.navInflater.inflate(feature.navGraphResId)
        navController.graph.addAll(graph)
        return feature.destinationId
    }

    // for no arg fragment
    private fun startWith(feature: Feature) {
        navController.graph = navController.navInflater.inflate(feature.navGraphResId).apply {
            startDestination = feature.destinationId
        }
    }

    private fun startWithDetail(id: String) {
        val graph = navController.navInflater.inflate(Feature.Detail.navGraphResId).apply {
            startDestination = Feature.Detail.destinationId
        }
        navController.setGraph(graph, Bundle().apply { putString("taskId", id) })
    }

    override fun toListing() {
        listingId.let { navController.navigate(it) }
    }

    override fun toDetail(id: String) {
        detailId.let { navController.navigate(it, Bundle().apply { putString("taskId", id) }) }
    }
}