package com.example.docscheduler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var patient_btn = findViewById<Button>(R.id.patient_btn)
        patient_btn.setOnClickListener {
            val intent = Intent(this, PatientActivity::class.java)
            startActivity(intent)
        }

        var doctor_btn = findViewById<Button>(R.id.doctor_btn)
        doctor_btn.setOnClickListener { // Corrected here
            val intent = Intent(this, DoctorActivity::class.java)
            startActivity(intent)
        }
    }
}
