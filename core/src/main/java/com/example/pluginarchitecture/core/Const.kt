package com.example.pluginarchitecture.core


/**
 * Created by kietnlt on 13 Jul 2019.
 */

object Const {
    val packageName = "com.example.pluginarchitecture"
    val listingFeatureName = "listing"
    private val fragment = "Fragment"
    private val component = "Component"
    val listingFragmentName = "$packageName.$listingFeatureName.${listingFeatureName.capitalize()}$fragment"

    fun componentNameOf(featureName: String): String {
        return "$packageName.$listingFeatureName.${featureName.capitalize()}$component"
    }
}