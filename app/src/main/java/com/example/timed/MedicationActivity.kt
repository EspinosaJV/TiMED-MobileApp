class MedicationActivity : AppCompatActivity() {

    private lateinit var medicationAdapter: MedicationAdapter
    private lateinit var medicationList: MutableList<Medication>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medication_list) // Adjust with your layout resource

        medicationList = mutableListOf() // Initialize the medication list

        medicationAdapter = MedicationAdapter(medicationList) { position ->
            // Handle delete action
            medicationAdapter.deleteMedication(position)
        }

        val recyclerView: RecyclerView = findViewById(R.id.rvMedications)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = medicationAdapter

        val fabAddMedication: FloatingActionButton = findViewById(R.id.fabAddMedication)
        fabAddMedication.setOnClickListener {
            // Sample data: You can change this to whatever data you want to add
            val newMedication = Medication("New Medication", "20mg")
            medicationAdapter.addMedication(newMedication)
        }
    }
}
