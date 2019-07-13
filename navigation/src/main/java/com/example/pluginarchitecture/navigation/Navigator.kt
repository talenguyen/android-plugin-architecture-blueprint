package com.example.pluginarchitecture.navigation


/**
 * Created by kietnlt on 12 Jul 2019.
 */
interface Navigator {
    fun toListing()
    fun toDetail(id: String)
}