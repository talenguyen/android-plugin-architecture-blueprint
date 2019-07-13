package com.example.pluginarchitecture.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.pluginarchitecture.navigation.NavigatorProvider


/**
 * Created by kietnlt on 12 Jul 2019.
 */
class DetailFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val args = DetailFragmentArgs.fromBundle(arguments!!)
        return inflater.inflate(R.layout.detail_fragment, container, false).apply {
            findViewById<TextView>(R.id.arg_text_view).text = "args is $args"
            findViewById<Button>(R.id.button).setOnClickListener {
                (requireActivity() as NavigatorProvider).navigator.toListing()
            }
        }
    }
}