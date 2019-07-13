package com.example.pluginarchitecture.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.example.pluginarchitecture.navigation.Navigator
import android.content.pm.PackageManager
import kotlin.random.Random


/**
 * Created by kietnlt on 12 Jul 2019.
 */
class NavigatorImpl(fragmentActivity: AppCompatActivity) : Navigator {
    // Find the resourceId of the graph we want to attach
    val navController: NavController by lazy {
        (fragmentActivity.supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment).navController

    }

    val listingId: Int by lazy {
        (Class.forName("com.example.pluginarchitecture.listing.C").getField("nav_graph").getInt(null) as Int)
            .let {
                val des = navController.navInflater.inflate(it)

                navController.graph.addAll(des)
            }
        (Class.forName("com.example.pluginarchitecture.listing.C").getField("des_id").getInt(null) as Int)

    }

    val detailId: Int by lazy {
        (Class.forName("com.example.pluginarchitecture.detail.C").getField("nav_graph").getInt(null) as Int)
            .let {
                val des = navController.navInflater.inflate(it)

                navController.graph.addAll(des)
            }
        (Class.forName("com.example.pluginarchitecture.detail.C").getField("des_id").getInt(null) as Int)
    }

    override fun toListing() {

        navController.navigate(listingId)
    }

    override fun toDetail(id: String) {
        navController.navigate(detailId, Bundle().apply { putString("taskId", id) })
    }
}