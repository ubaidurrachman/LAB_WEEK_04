package com.ubai.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class ListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // contoh kalau item di-click → navigasi ke detail
        view.findViewById<View>(R.id.affogato).setOnClickListener {
            val bundle = Bundle().apply { putInt(DetailFragment.COFFEE_ID, R.id.affogato) }
            findNavController().navigate(R.id.detailFragment, bundle)
        }
    }
}
