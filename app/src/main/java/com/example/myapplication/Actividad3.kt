package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout
import java.util.Calendar

class Actividad3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actividad3)

        val insertarBtn = findViewById<Button>(R.id.insertarBtn)
        val tuCorreoLayout = findViewById<TextInputLayout>(R.id.tuCorreo)
        val tuContrasenaLayout = findViewById<TextInputLayout>(R.id.tuContrasena)
        val tuNombreLayout = findViewById<TextInputLayout>(R.id.tuNombre)
        val tuCPLayout = findViewById<TextInputLayout>(R.id.tuCP)
        val tuNacimientoLayout = findViewById<TextInputLayout>(R.id.tuNacimiento)

        insertarBtn.setOnClickListener{
            val correoValido = validarCorreo(tuCorreoLayout.editText!!)
            val contrasenaValida = validarContrasena(tuContrasenaLayout.editText!!)
            val cpValido = tuCPLayout.editText!!.text.toString().isEmpty() || validarCP(tuCPLayout.editText!!)
            val nacimientoValido = validarNacimiento(tuNacimientoLayout.editText!!)

            if(correoValido && contrasenaValida && cpValido && nacimientoValido) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }else{
                if (!correoValido) {
                    tuCorreoLayout.error = "El correo electrónico debe ser válido (contener '@' y al menos un punto)"
                } else {
                    tuCorreoLayout.boxStrokeColor = getColor(R.color.verde)
                    tuCorreoLayout.errorIconDrawable = null
                    tuCorreoLayout.error = null
                }
                if(!contrasenaValida) {
                    tuContrasenaLayout.error = "La contraseña debe tener al menos 7 caracteres, una mayúscula, una minúscula y un número"
                } else {
                    tuContrasenaLayout.boxStrokeColor = getColor(R.color.verde)
                    tuContrasenaLayout.errorIconDrawable = null
                    tuContrasenaLayout.error = null
                }
                if(!cpValido) {
                    tuCPLayout.error = "El código postal debe tener 5 dígitos"
                }else{
                    tuCPLayout.boxStrokeColor = getColor(R.color.verde)
                    tuCPLayout.errorIconDrawable = null
                    tuCPLayout.error = null
                }
                if(!nacimientoValido) {
                    tuNacimientoLayout.error = "Debes ser mayor de edad"
                }else {
                    tuNacimientoLayout.boxStrokeColor = getColor(R.color.verde)
                    tuNacimientoLayout.errorIconDrawable = null
                    tuNacimientoLayout.error = null
                }
            }
        }
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
        if(e.text.toString().length < 7) {
            isValid = false
        }
        if(!e.text.toString().contains(Regex("[0-9]"))) {
            isValid = false
        }
        if(!e.text.toString().contains(Regex("[A-Z]"))) {
            isValid = false
        }
        if(!e.text.toString().contains(Regex("[a-z]"))) {
            isValid = false
        }
        if(!e.text.toString().isEmpty()) {
            e.error = null
        }
        else {
            e.error = null
        }
        return isValid
    }

    fun validarCP(e: EditText): Boolean {
        var isValid = true
        if(e.text.toString().length != 5) {
            isValid = false
        } else {
            e.error = null
        }
        return isValid
    }

    fun validarNacimiento(e: EditText): Boolean {
        var fechaActual = Calendar.getInstance()
        var isValid = true

        if (e.text.toString().isNotEmpty()) {
            val yearOfBirth = e.text.toString().substring(6, 10).toIntOrNull()

            if (yearOfBirth != null) {
                val edad = fechaActual.get(Calendar.YEAR) - yearOfBirth

                if (edad < 18) {
                    isValid = false
                } else {
                    e.error = null
                }
            } else {
                isValid = false // Manejo del error si no se puede obtener el año de nacimiento
            }
        } else {
            isValid = false // El campo está vacío, se considera inválido
        }

        return isValid
    }
}