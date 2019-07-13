package com.example.pluginarchitecture.core

import android.content.Context
import com.example.pluginarchitecture.injection.*


/**
 * Created by kietnlt on 12 Jul 2019.
 */
val Context.domainComponent: DomainComponent
    get() = (applicationContext as HasDomainComponent).domainComponent

val Context.dataComponent: DataComponent
    get() = (applicationContext as HasDataComponent).dataComponent

val Context.androidComponent: AndroidComponent
    get() = (applicationContext as HasAndroidComponent).androidComponent

val Context.baseComponent: BaseComponent
    get() = (applicationContext as HasBaseComponent).baseComponent
