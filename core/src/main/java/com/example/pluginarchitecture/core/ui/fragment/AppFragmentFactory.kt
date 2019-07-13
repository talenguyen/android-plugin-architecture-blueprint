package com.example.pluginarchitecture.core.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.example.pluginarchitecture.core.Feature
import com.example.pluginarchitecture.core.baseComponent
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.functions


/**
 * Created by kietnlt on 13 Jul 2019.
 */
class AppFragmentFactory(
    private val fragmentActivity: FragmentActivity
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == Feature.Listing.fragmentName) {
            return Feature.Listing.fragmentComponent.create(
                fragmentActivity,
                fragmentActivity.baseComponent
            ).fragment
        }

        return super.instantiate(classLoader, className)
    }


    private val Feature.fragmentComponent: FragmentComponentFactory<*>
        get() = run {
            val kClass = Class.forName(componentName).kotlin
            kClass.companionObject!!
                .functions
                .first { it.name == "componentFactory" }
                .call(kClass.companionObjectInstance) as FragmentComponentFactory<*>
        }
}