package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Actividad1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad1)

        var insertarBtn = findViewById<Button>(R.id.insertarBtn)
        val tuNombreLayout = findViewById<TextInputLayout>(R.id.tuNombre)
        val tuEdadLayout = findViewById<TextInputLayout>(R.id.tuEdad)

        insertarBtn.setOnClickListener {
            val nombreValido = validarNombre(tuNombreLayout.editText!!)
            val edadValida = tuEdadLayout.editText!!.text.toString().isEmpty() || validadEdad(tuEdadLayout.editText!!)

            if (nombreValido && edadValida) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                if (!nombreValido) {
                    tuNombreLayout.error = "El nombre debe tener al menos 2 caracteres"
                } else if (!edadValida) {
                    tuEdadLayout.error = "Debes ser mayor de edad"
                }
            }
        }
    }
    fun validarNombre(e: EditText): Boolean {
        var isValid = true
        if(e.text.toString().length < 2) {
            isValid = false
        } else {
            e.error = null
        }
        return isValid
    }

    fun validadEdad(e: EditText): Boolean {
        var isValid = true
        if(e.text.toString().toInt() < 18) {
            isValid = false
        } else {
            e.error = null
        }
        return isValid
    }
}