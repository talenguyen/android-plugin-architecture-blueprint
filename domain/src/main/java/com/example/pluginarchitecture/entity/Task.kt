package com.example.pluginarchitecture.entity


/**
 * Created by kietnlt on 12 Jul 2019.
 */
data class Task(
    val identity: String,
    val title: String,
    val content: String,
    val isDone: Boolean
)