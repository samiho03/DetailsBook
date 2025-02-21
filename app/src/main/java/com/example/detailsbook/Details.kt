package com.example.detailsbook

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_details)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        findViewById<Button>(R.id.bt1).setOnClickListener {
            replaceFragment(Fragment1())
        }

        findViewById<Button>(R.id.bt2).setOnClickListener {
            replaceFragment(Fragment2())
        }

        findViewById<Button>(R.id.bt3).setOnClickListener {
            replaceFragment(Fragment3())
        }

        findViewById<Button>(R.id.bt4).setOnClickListener {
            replaceFragment(Fragment4())
        }

        findViewById<Button>(R.id.bt5).setOnClickListener {
            replaceFragment(Fragment5())
        }


        findViewById<Button>(R.id.back).setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }

}