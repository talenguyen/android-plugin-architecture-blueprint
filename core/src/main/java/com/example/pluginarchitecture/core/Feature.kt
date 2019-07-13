package com.example.pluginarchitecture.core

import androidx.annotation.IdRes


/**
 * Created by kietnlt on 13 Jul 2019.
 */
sealed class Feature(val name: String) {
    val fragmentName = "${Const.packageName}.$name.${name.capitalize()}Fragment"
    val componentName = "${Const.packageName}.$name.${name.capitalize()}Component"

    val navGraphResId: Int by lazy(LazyThreadSafetyMode.NONE) {
        Class.forName("${Const.packageName}.$name.C").getField("nav_graph").getInt(null)
    }
    val destinationId: Int by lazy(LazyThreadSafetyMode.NONE) {
        Class.forName("${Const.packageName}.$name.C").getField("des_id").getInt(null)
    }

    object Listing : Feature("listing")
    object Detail : Feature("detail")
}
