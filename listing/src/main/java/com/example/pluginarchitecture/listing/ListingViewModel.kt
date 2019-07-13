package com.example.pluginarchitecture.listing

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.pluginarchitecture.core.livedata.LiveDataViewModel
import com.example.pluginarchitecture.interactor.Noop
import javax.inject.Inject
import kotlin.random.Random


/**
 * Created by kietnlt on 13 Jul 2019.
 */
class ListingViewModel @Inject constructor(
    private val noop: Noop
) : ViewModel(), LiveDataViewModel {
    val navigationEvent = mutableEventOf<ListingNavigator>()

    val onButtonClick = View.OnClickListener {
        noop()
        navigationEvent.v = invokerEventOf {
            toDetail(Random.nextInt().toString())
        }
    }
}