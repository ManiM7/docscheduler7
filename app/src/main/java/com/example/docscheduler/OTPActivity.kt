package com.example.docscheduler

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener


class OTPActivity : AppCompatActivity() {

    private lateinit var editTextOTP: EditText
    private lateinit var btnVerify: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otpactivity)

        editTextOTP = findViewById(R.id.editTextOTP)
        btnVerify = findViewById(R.id.btnVerify)
        editTextOTP.addTextChangedListener {
            btnVerify.isEnabled = it.toString().length == 6
        }
        btnVerify.setOnClickListener {
            val enteredOTP = editTextOTP.text.toString()
            if (enteredOTP == "123456") {
                showToast("OTP Verified Successfully")
                // Navigate to the NextActivity upon successful OTP verification
                navigateToNextActivity()
            } else {
                // Incorrect OTP, show an error message
                showToast("Incorrect OTP. Please try again.")
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    // Function to navigate to the NextActivity
    private fun navigateToNextActivity() {
        // Create an Intent to launch the NextActivity
        val intent = Intent(this, Pat_dash_Activity::class.java)
        // You can also pass any data to the next activity if needed
        // intent.putExtra("key", "value")
        // Start the NextActivity
        startActivity(intent)
        // Finish the current activity to prevent going back to OTP verification
        finish()
    }
}
