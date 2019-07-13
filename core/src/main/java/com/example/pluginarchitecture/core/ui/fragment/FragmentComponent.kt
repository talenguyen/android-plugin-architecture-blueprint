package com.example.pluginarchitecture.core.ui.fragment

import androidx.fragment.app.Fragment


/**
 * Created by kietnlt on 13 Jul 2019.
 */
interface FragmentComponent<T: Fragment> {
    val fragment: T
}