package com.example.timed

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MedicationAdapter(
    private val medications: MutableList<Medication>,
    private val onDelete: (Int) -> Unit // Adding a lambda for delete functionality
) : RecyclerView.Adapter<MedicationAdapter.MedicationViewHolder>() {

    class MedicationViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvMedicationName)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedicationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.medication_item, parent, false)
        return MedicationViewHolder(view)
    }

    override fun onBindViewHolder(holder: MedicationViewHolder, position: Int) {
        val medication = medications[position]
        holder.name.text = medication.name

        // Add delete button listener (or any other UI element that should trigger the deletion)
        holder.itemView.setOnLongClickListener {
            onDelete(position) // Call the delete lambda when the item is long-clicked
            true
        }
    }

    override fun getItemCount(): Int {
        return medications.size
    }

    fun addMedication(medication: Medication) {
        medications.add(medication)
        notifyItemInserted(medications.size - 1)
    }

    // Optionally, you can add a method to handle deletion
    fun deleteMedication(position: Int) {
        medications.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, medications.size)
    }
}
