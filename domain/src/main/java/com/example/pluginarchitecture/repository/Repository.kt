package com.example.pluginarchitecture.repository

import com.example.pluginarchitecture.entity.Task


/**
 * Created by kietnlt on 12 Jul 2019.
 */
interface Repository {
    fun getAllTask(): List<Task>
    fun getTask(id: String): Task
    fun getRecentlyViewTask(): List<Task>
    fun saveToRecentlyView(task: Task)
}