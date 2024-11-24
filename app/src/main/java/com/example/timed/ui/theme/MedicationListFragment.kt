package com.example.timed.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.timed.R
import com.example.timed.model.Medication
import com.example.timed.ui.theme.MedicationAdapter

class MedicationListFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_medication_list, container, false)

        // Find the RecyclerView
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewMedications)

        // Set layout manager
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        // Dummy data
        val dummyMedications = listOf(
            Medication("Paracetamol", "Pain reliever"),
            Medication("Aspirin", "Reduces fever and pain"),
            Medication("Metformin", "Controls blood sugar levels")
        )

        // Set adapter
        val adapter = MedicationAdapter(dummyMedications)
        recyclerView.adapter = adapter

        return view
    }
}