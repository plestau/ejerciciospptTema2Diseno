package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ejercicio1 = findViewById<Button>(R.id.ejercicio1Btn)
        val ejercicio2 = findViewById<Button>(R.id.ejercicio2Btn)
        val ejercicio3 = findViewById<Button>(R.id.ejercicio3Btn)

        ejercicio1.setOnClickListener {
            val intent = Intent(this, Actividad1::class.java)
            startActivity(intent)
        }

        ejercicio2.setOnClickListener {
            val intent = Intent(this, Actividad2::class.java)
            startActivity(intent)
        }

        ejercicio3.setOnClickListener{
            val intent = Intent(this, Actividad3::class.java)
            startActivity(intent)
        }
    }
}