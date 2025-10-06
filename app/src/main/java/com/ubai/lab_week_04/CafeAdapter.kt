package com.ubai.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val contents: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = contents.size

    override fun createFragment(position: Int): Fragment {
        return CafeDetailFragment.newInstance(contents[position])
    }
}
