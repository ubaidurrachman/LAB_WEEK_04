package com.ubai.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class CafeFragment : Fragment() {

    private val tabTitleIds = listOf(
        R.string.starbucks_title,
        R.string.janjijiwa_title,
        R.string.kopikenangan_title
    )

    private val tabContentIds = listOf(
        R.string.starbucks_desc,
        R.string.janjijiwa_desc,
        R.string.kopikenangan_desc
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewPager = view.findViewById<ViewPager2>(R.id.view_pager)
        val tabLayout = view.findViewById<TabLayout>(R.id.tab_layout)

        val contents = tabContentIds.map { getString(it) }
        val adapter = CafeAdapter(childFragmentManager, lifecycle, contents)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = getString(tabTitleIds[position])
        }.attach()
    }
}
