package com.example.pluginarchitecture.core.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


/**
 * Created by kietnlt on 12 Jul 2019.
 */
interface LiveDataViewModel {

    private fun <T: Any> LiveData<T>.asMutable(): MutableLiveData<T> = (this as MutableLiveData<T>)

    fun <T: Any> mutableLiveDataOf(initValue: T): LiveData<T> {
        return MutableLiveData<T>().apply { value = initValue }
    }

    var <T: Any> LiveData<T>.v
        get() = value
        set(newValue) {
            asMutable().value = newValue
        }

    fun <T> mutableEventOf(): LiveData<Event<T.() -> Unit>> {
        return MutableLiveData<Event<T.() -> Unit>>()
    }

    fun <T> invokerEventOf(): LiveData<Event<T.() -> Unit>> = MutableLiveData<Event<T.() -> Unit>>()

    fun LiveData<Event<Unit>>.triggerNewEvent() {
        v = Event(Unit)
    }

    fun <T: Any> invokerEventOf(block: T.() -> Unit): Event<T.() -> Unit> = Event(block)
}