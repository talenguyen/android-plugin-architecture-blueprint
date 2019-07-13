package com.example.pluginarchitecture.data

import android.content.Context
import com.example.pluginarchitecture.injection.DataComponent
import com.example.pluginarchitecture.repository.Repository
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton


/**
 * Created by kietnlt on 12 Jul 2019.
 */
@Singleton
@Component(modules = [DataComponentImpl.Binding::class])
interface DataComponentImpl : DataComponent {

    @Module
    interface Binding {
        @Binds
        fun bind(impl: InMemoryRepository): Repository
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): DataComponent
    }

    companion object {
        fun create(context: Context): DataComponent {
            return DaggerDataComponentImpl.factory().create(context)
        }
    }
}