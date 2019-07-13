package com.example.pluginarchitecture.listing

import com.example.pluginarchitecture.navigation.Navigator
import javax.inject.Inject

/**
 * Created by kietnlt on 13 Jul 2019.
 */
class ListingNavigator @Inject constructor(
    private val navigator: Navigator
) {
    fun toDetail(id: String) {
        navigator.toDetail(id)
    }
}