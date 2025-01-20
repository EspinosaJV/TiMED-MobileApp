package com.example.timed.ui.theme

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ImageButton
import androidx.recyclerview.widget.RecyclerView
import com.example.timed.R
import com.example.timed.model.Medication

class MedicationAdapter(
    private val medications: List<Medication>,
    private val onDeleteClick: (Medication) -> Unit
) : RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    // ViewHolder class holds references to the UI Components
    class MedicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val nameTextView: TextView = view.findViewById(R.id.tvMedicationName)
        val descriptionTextView: TextView = view.findViewById(R.id.tvMedicationDetails)
        val deleteButton: ImageButton = view.findViewById(R.id.btnDeleteMedication)
    }

    // Inflates layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.medication_item, parent, false)
        return MedicationViewHolder(view)
    }

    // Binds data to the ViewHolder
    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val medication = medications[position]
        holder.nameTextView.text = medication.name
        holder.descriptionTextView.text = medication.description

        // Handles delete button click event
        holder.deleteButton.setOnClickListener {
            onDeleteClick(medication)
        }
    }

    // Returns total number of items in the list
    override fun getItemCount(): Int = medications.size
}