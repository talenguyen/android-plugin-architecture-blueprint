package com.example.pluginarchitecture.core.ui.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.pluginarchitecture.injection.AndroidComponent
import com.example.pluginarchitecture.injection.BaseComponent
import com.example.pluginarchitecture.injection.DataComponent
import com.example.pluginarchitecture.injection.DomainComponent
import dagger.BindsInstance


/**
 * Created by kietnlt on 13 Jul 2019.
 */
interface FragmentComponentFactory<T: Fragment> {
    fun create(
        @BindsInstance activity: FragmentActivity,
        baseComponent: BaseComponent
    ): FragmentComponent<T>
}