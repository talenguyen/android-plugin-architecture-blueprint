package com.example.pluginarchitecture.core.livedata

import androidx.annotation.MainThread
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer


/**
 * Created by kietnlt on 12 Jul 2019.
 */
@MainThread
inline fun <T> LiveData<Event<T>>.observeEvent(
    owner: LifecycleOwner,
    crossinline onEventUnhandled: (T) -> Unit
): Observer<Event<T>> {
    val wrappedObserver = Observer<Event<T>> { event ->
        event?.getContentIfNotHandled()?.let(onEventUnhandled)
    }
    observe(owner, wrappedObserver)
    return wrappedObserver
}
