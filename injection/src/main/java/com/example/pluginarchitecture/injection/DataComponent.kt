package com.example.pluginarchitecture.injection

import com.example.pluginarchitecture.repository.Repository


/**
 * Created by kietnlt on 12 Jul 2019.
 */
interface DataComponent {
    val repository: Repository
}