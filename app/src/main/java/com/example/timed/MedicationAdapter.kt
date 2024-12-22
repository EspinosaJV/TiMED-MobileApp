package com.example.timed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicationAdapter(private val medications: List<Medication>) :
        RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

            // Defines the Viewholder
            class MedicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
                val name: TextView = view.findViewById(R.id.tvMedicationName)
                val details: TextView = view.findViewById(R.id.tvMedicationDetails)
                val deleteButton: ImageButton = view.findViewById(R.id.btnDeleteMedication)
            }

            // Inflates item layout and ViewHolder creation
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.medication_item, parent, false)
                return MedicationViewHolder(view)
            }

            // Binds data to the item layout
            override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
                val medication = medications[position]
                holder.name.text = medication.name
                holder.details.text = "Dosage: ${medication.dosage}"
                holder.deleteButton.setOnClickListener {
                    // Deletion process to be handled here
                }
            }

            // Returns total item count
            override fun getItemCount() = medications.size
        }