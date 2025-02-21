package com.example.detailsbook

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nicInput = findViewById<TextInputEditText>(R.id.nicInput)
        val loginButton = findViewById<MaterialButton>(R.id.loginButton)


        loginButton.setOnClickListener {
            val nicNumber = nicInput.text.toString()

            if (isValidNic(nicNumber)) {
                val intent = Intent(this, Details::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid NIC number", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, ErrorPage::class.java)
                startActivity(intent)
            }
        }
    }

    private fun isValidNic(nic: String): Boolean {
        return nic.length == 12 && nic.all { it.isDigit() }
    }

}
