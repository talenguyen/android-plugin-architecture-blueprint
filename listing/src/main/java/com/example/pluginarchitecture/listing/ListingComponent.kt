package com.example.pluginarchitecture.listing

import androidx.fragment.app.FragmentActivity
import com.example.pluginarchitecture.core.ui.fragment.FragmentComponent
import com.example.pluginarchitecture.core.ui.fragment.FragmentComponentFactory
import com.example.pluginarchitecture.injection.AndroidComponent
import com.example.pluginarchitecture.injection.BaseComponent
import com.example.pluginarchitecture.injection.DataComponent
import com.example.pluginarchitecture.injection.DomainComponent
import com.example.pluginarchitecture.navigation.NavigatorModule
import dagger.BindsInstance
import dagger.Component


/**
 * Created by kietnlt on 13 Jul 2019.
 */
@Component(
    dependencies = [
        BaseComponent::class
    ],
    modules = [
        NavigatorModule::class
    ]
)
@ListingScope
interface ListingComponent : FragmentComponent<ListingFragment> {

    @Component.Factory
    interface Factory: FragmentComponentFactory<ListingFragment>

    companion object {
        fun componentFactory(): FragmentComponentFactory<ListingFragment> {
            return DaggerListingComponent.factory()
        }

    }
}