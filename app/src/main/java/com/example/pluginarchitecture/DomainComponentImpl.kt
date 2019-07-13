package com.example.pluginarchitecture

import com.example.pluginarchitecture.injection.DomainComponent
import com.example.pluginarchitecture.interactor.Noop
import com.example.pluginarchitecture.repository.Repository
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by kietnlt on 12 Jul 2019.
 */
@Component(modules = [DomainComponentImpl.Provision::class])
@Singleton
interface DomainComponentImpl : DomainComponent {

    @Module
    object Provision {
        @JvmStatic
        @Provides
        @Singleton
        fun noop(repository: Repository): Noop {
            return Noop(
                repository = repository
            )
        }
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance repository: Repository): DomainComponent
    }
}