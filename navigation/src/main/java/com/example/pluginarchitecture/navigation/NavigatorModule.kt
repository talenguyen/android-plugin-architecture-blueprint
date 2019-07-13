package com.example.pluginarchitecture.navigation

import androidx.fragment.app.FragmentActivity
import dagger.Module
import dagger.Provides


/**
 * Created by kietnlt on 13 Jul 2019.
 */
@Module
object NavigatorModule {

    @JvmStatic
    @Provides
    fun navigator(activity: FragmentActivity): Navigator {
        return (activity as NavigatorProvider).navigator
    }
}