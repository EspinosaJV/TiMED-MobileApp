package com.example.timed.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.timed.R
import com.example.timed.model.Medication

class MedicationAdapter(private val medications: List<Medication>) :
        RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

            // ViewHolder class to hold references to the UI Components
            class MedicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val nameTextView: TextView = view.findViewById(R.id.textViewName)
                val descriptionTextView: TextView = view.findViewById(R.id.textViewDescription)
            }

            // Inflate the layout for each item and return a ViewHolder
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_medication, parent, false)
                return MedicationViewHolder(view)
            }

            // Bind data to the ViewHolder
            override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
                val medication = medications[position]
                holder.nameTextView.text = medication.name
                holder.descriptionTextView.text = medication.description
            }

            // Return the total number of items in the list
            override fun getItemCount(): Int = medications.size
        }