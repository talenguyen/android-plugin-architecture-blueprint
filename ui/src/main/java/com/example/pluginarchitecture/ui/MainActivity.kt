package com.example.pluginarchitecture.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pluginarchitecture.core.ui.fragment.AppFragmentFactory
import com.example.pluginarchitecture.navigation.Navigator
import com.example.pluginarchitecture.navigation.NavigatorProvider


/**
 * Created by kietnlt on 12 Jul 2019.
 */
class MainActivity : AppCompatActivity(), NavigatorProvider {
    private lateinit var _navigator: Navigator
    override val navigator: Navigator
        get() = _navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        supportFragmentManager.fragmentFactory = AppFragmentFactory(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        _navigator = NavigatorImpl(this)
        navigator.toListing()
    }
}