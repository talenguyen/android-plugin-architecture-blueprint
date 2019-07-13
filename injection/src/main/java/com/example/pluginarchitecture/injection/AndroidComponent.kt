package com.example.pluginarchitecture.injection

import android.content.Context
import androidx.core.app.NotificationManagerCompat


/**
 * Created by kietnlt on 12 Jul 2019.
 */
interface AndroidComponent {
    val notificationManagerCompat: NotificationManagerCompat
    val context: Context
}