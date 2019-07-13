package com.example.pluginarchitecture.interactor

import com.example.pluginarchitecture.repository.Repository


/**
 * Created by kietnlt on 12 Jul 2019.
 */
class Noop constructor(
    private val repository: Repository
) {
    operator fun invoke() {
        // no-op
    }
}