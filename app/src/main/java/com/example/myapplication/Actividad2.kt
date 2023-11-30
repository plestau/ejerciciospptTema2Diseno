package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class Actividad2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad2)

        var insertarBtn = findViewById<Button>(R.id.insertarBtn)
        val tuUsuarioLayout = findViewById<TextInputLayout>(R.id.tuUsuario)
        val tuCorreoLayout = findViewById<TextInputLayout>(R.id.tuCorreo)
        val tuContrasenaLayout = findViewById<TextInputLayout>(R.id.tuContrasena)

        insertarBtn.setOnClickListener {
            val usuarioValido = validarNombre(tuUsuarioLayout.editText!!)
            val correoValido = validarCorreo(tuCorreoLayout.editText!!)
            val contrasenaValida = validarContrasena(tuContrasenaLayout.editText!!)

            if (usuarioValido && correoValido && contrasenaValida) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            } else {
                if (usuarioValido) {
                    tuUsuarioLayout.boxStrokeColor = getColor(R.color.verde)
                    tuUsuarioLayout.errorIconDrawable = null
                    tuUsuarioLayout.error = null

                }
                if(correoValido) {
                    tuCorreoLayout.boxStrokeColor = getColor(R.color.verde)
                    tuCorreoLayout.errorIconDrawable = null
                    tuCorreoLayout.error = null
                }
                if(contrasenaValida) {
                    tuContrasenaLayout.boxStrokeColor = getColor(R.color.verde)
                    tuContrasenaLayout.errorIconDrawable = null
                    tuContrasenaLayout.error = null
                }
                if (!usuarioValido) {
                    tuUsuarioLayout.error = "El nombre de usuario no puede estar vacío"
                } else if (!correoValido) {
                    tuCorreoLayout.error = "El correo electrónico debe ser válido(contener '@' y al menos un punto)"
                }else if (!contrasenaValida) {
                    tuContrasenaLayout.error = "La contraseña debe tener al menos 6 caracteres"
                }
            }
        }
    }
    fun validarNombre(e: EditText): Boolean {
        var isValid = true
        if(e.text.toString().isEmpty()) {
            isValid = false
        } else {
            e.error = null
        }
        return isValid
    }

    fun validarCorreo(e: EditText): Boolean {
        var isValid = true
        if(e.text.toString().isEmpty() || !e.text.toString().contains("@") || !e.text.toString().contains(".")) {
            isValid = false
        } else {
            e.error = null
        }
        return isValid
    }

    fun validarContrasena(e: EditText): Boolean {
        var isValid = true
        if(e.text.toString().length < 6) {
            isValid = false
        } else {
            e.error = null
        }
        return isValid
    }
}