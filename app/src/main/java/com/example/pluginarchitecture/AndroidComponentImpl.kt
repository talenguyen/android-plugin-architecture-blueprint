package com.example.pluginarchitecture

import android.content.Context
import androidx.core.app.NotificationManagerCompat
import com.example.pluginarchitecture.injection.AndroidComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * Created by kietnlt on 12 Jul 2019.
 */
@Component(
    modules = [
        AndroidComponentImpl.Provision::class
    ]
)
@Singleton
interface AndroidComponentImpl : AndroidComponent {


    @Module
    object Provision {
        @JvmStatic
        @Provides
        @Singleton
        fun notificationManager(context: Context): NotificationManagerCompat {
            return NotificationManagerCompat.from(context)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AndroidComponentImpl
    }
}