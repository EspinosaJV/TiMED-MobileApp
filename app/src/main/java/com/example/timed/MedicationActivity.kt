import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.timed.Medication
import com.example.timed.MedicationAdapter
import com.example.timed.R

class MedicationActivity : AppCompatActivity() {

    private lateinit var medicationAdapter: MedicationAdapter
    private lateinit var medicationList: MutableList<Medication>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.medication_list)

        medicationList = mutableListOf()

        Log.d("MedicationActivity", "Initial medication list size: ${medicationList.size}")

        medicationAdapter = MedicationAdapter(medicationList) { position ->
            medicationAdapter.deleteMedication(position)
        }

        val recyclerView: RecyclerView = findViewById(R.id.rvMedications)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = medicationAdapter

        val fabAddMedication: FloatingActionButton = findViewById(R.id.fabAddMedication)
        fabAddMedication.setOnClickListener {
            val newMedication = Medication("New Medication", "20mg")
            medicationAdapter.addMedication(newMedication)

            Log.d("MedicationActivity", "Medication added. List size: ${medicationList.size}")
        }
    }
}