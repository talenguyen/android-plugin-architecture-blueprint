package com.example.pluginarchitecture

import android.app.Application
import android.content.Context
import androidx.core.app.NotificationManagerCompat
import com.example.pluginarchitecture.injection.*
import com.example.pluginarchitecture.interactor.Noop
import com.example.pluginarchitecture.repository.Repository
import kotlin.reflect.full.companionObject
import kotlin.reflect.full.companionObjectInstance
import kotlin.reflect.full.functions


/**
 * Created by kietnlt on 12 Jul 2019.
 */
class MyApplication : Application(), HasDataComponent, HasDomainComponent, HasAndroidComponent, HasBaseComponent {


    override val dataComponent: DataComponent by lazy {
        val kclass = Class.forName("com.example.pluginarchitecture.data.DataComponentImpl").kotlin
        val function = kclass.companionObject!!.functions.first { it.name == "create" }
        function.call(kclass.companionObjectInstance, this) as DataComponent
    }

    override val domainComponent: DomainComponent by lazy {
        DaggerDomainComponentImpl.factory().create(dataComponent.repository)
    }

    override val androidComponent: AndroidComponent by lazy {
        DaggerAndroidComponentImpl.factory().create(this)
    }

    override val baseComponent: BaseComponent by lazy {
        object : BaseComponent,
            DomainComponent by domainComponent,
            AndroidComponent by androidComponent,
            DataComponent by dataComponent{

        }
    }
}