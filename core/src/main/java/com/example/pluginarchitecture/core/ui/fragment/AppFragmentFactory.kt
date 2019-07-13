package com.example.pluginarchitecture.core.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.example.pluginarchitecture.core.*
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.declaredMembers
import kotlin.reflect.full.functions


/**
 * Created by kietnlt on 13 Jul 2019.
 */
class AppFragmentFactory(
    private val fragmentActivity: FragmentActivity
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        if (className == Const.listingFragmentName) {
            return fragmentComponentOf(Const.listingFeatureName).create(
                fragmentActivity,
                fragmentActivity.baseComponent
            ).fragment
        }

        return super.instantiate(classLoader, className)
    }


    private fun fragmentComponentOf(featureName: String): FragmentComponentFactory<*> {
        val kClass = Class.forName(Const.componentNameOf(featureName)).kotlin
        return kClass.companionObjectInstance!!::class
            .functions
            .first { it.name == "componentFactory" }
            .call(
                kClass.companionObjectInstance

            ) as FragmentComponentFactory<*>
    }
}