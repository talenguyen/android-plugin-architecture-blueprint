package com.example.pluginarchitecture.listing

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.pluginarchitecture.core.livedata.observeEvent
import javax.inject.Inject

/**
 * Created by kietnlt on 12 Jul 2019.
 */
class ListingFragment @Inject constructor(
    private val navigator: ListingNavigator,
    private val notificationManager: NotificationManagerCompat,
    private val viewModelFactory: ListingViewModelFactory
) : Fragment() {

    lateinit var viewModel: ListingViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ListingViewModel::class.java)
        return inflater.inflate(R.layout.listing_fragment, container, false).apply {
            findViewById<Button>(R.id.button).setOnClickListener(viewModel.onButtonClick)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.navigationEvent.observeEvent(viewLifecycleOwner) {
            it(navigator)
        }
    }
}