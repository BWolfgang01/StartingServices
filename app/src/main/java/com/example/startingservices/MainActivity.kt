package com.example.startingservices

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.editText1)
        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val countdownValue = editText.text.toString().toIntOrNull()
            if (countdownValue != null) {
                val intent = Intent(this, CountdownService::class.java)
                intent.putExtra("COUNTDOWN_VALUE", countdownValue)
                startService(intent)
            }
        }
    }
}
