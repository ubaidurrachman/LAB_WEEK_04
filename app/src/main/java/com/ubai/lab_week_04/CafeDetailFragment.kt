package com.ubai.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class CafeDetailFragment : Fragment() {

    private var content: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        content = arguments?.getString(ARG_CONTENT)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cafe_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.content_description)?.text = content
    }

    companion object {
        private const val ARG_CONTENT = "ARG_CONTENT"
        fun newInstance(content: String) =
            CafeDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CONTENT, content)
                }
            }
    }
}
