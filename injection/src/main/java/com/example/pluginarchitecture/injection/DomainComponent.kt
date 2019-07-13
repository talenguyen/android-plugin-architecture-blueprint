package com.example.pluginarchitecture.injection

import com.example.pluginarchitecture.interactor.Noop


/**
 * Created by kietnlt on 12 Jul 2019.
 */
interface DomainComponent {
    val noop: Noop
}