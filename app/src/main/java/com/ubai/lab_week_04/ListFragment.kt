package com.ubai.lab_week_04

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private val coffeeList = listOf("Americano", "Cappuccino", "Espresso")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = CoffeeAdapter(coffeeList) { coffeeName ->
            // Navigate ke DetailFragment (bukan CafeDetailFragment)
            val bundle = Bundle().apply {
                putString("coffeeName", coffeeName)
            }
            findNavController().navigate(R.id.action_listFragment_to_detailFragment, bundle)
        }
    }

    class CoffeeAdapter(
        private val data: List<String>,
        private val onItemClick: (String) -> Unit
    ) : RecyclerView.Adapter<CoffeeAdapter.ViewHolder>() {

        class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val text: TextView = view.findViewById(android.R.id.text1)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(android.R.layout.simple_list_item_1, parent, false)
            return ViewHolder(view)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            holder.text.text = data[position]
            holder.itemView.setOnClickListener {
                onItemClick(data[position])
            }
        }

        override fun getItemCount() = data.size
    }
}
