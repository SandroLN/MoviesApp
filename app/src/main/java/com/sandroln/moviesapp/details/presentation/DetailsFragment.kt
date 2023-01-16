package com.sandroln.moviesapp.details.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sandroln.moviesapp.R

class DetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        //todo make better
        private const val KEY = "DETAILS"

        fun newInstance(value: String) = DetailsFragment().apply {
            arguments = Bundle().apply {
                putString(KEY, value)
            }
        }
    }
}