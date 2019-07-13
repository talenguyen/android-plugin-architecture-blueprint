package com.example.pluginarchitecture.listing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider


/**
 * Created by kietnlt on 13 Jul 2019.
 */
class ListingViewModelFactory @Inject constructor(
    private val viewModelProvider: Provider<ListingViewModel>
): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return viewModelProvider.get() as T
    }
}