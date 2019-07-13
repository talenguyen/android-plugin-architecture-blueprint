package com.example.pluginarchitecture.data

import android.content.Context
import com.example.pluginarchitecture.entity.Task
import com.example.pluginarchitecture.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Created by kietnlt on 12 Jul 2019.
 */
@Singleton
class InMemoryRepository @Inject constructor(
    private val context: Context // for database implementation
) : Repository {
    private val history = HashMap<Task, Long>()

    private val tasks = mutableListOf(
        Task("a", "title a", "content a", false),
        Task("b", "title b", "content b", true),
        Task("c", "title c", "content c", false),
        Task("d", "title d", "content d", true),
        Task("e", "title e", "content e", false)
    )

    override fun getAllTask(): List<Task> {
        return tasks
    }

    override fun getTask(id: String): Task {
        return tasks.first { it.identity == id }
    }

    override fun getRecentlyViewTask(): List<Task> {
        return history
            .asSequence()
            .sortedByDescending { it.value }
            .map { it.key }
            .take(5)
            .toList()
    }

    override fun saveToRecentlyView(task: Task) {
        history[task] = System.currentTimeMillis()
    }
}