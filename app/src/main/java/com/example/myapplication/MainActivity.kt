package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userPeso = findViewById<EditText>(R.id.userPeso)
        val userAltura = findViewById<EditText>(R.id.userAltura)
        val btnCalc:Button = findViewById(R.id.btnCalc)




        btnCalc.setOnClickListener {
            val altStr  = userAltura.text.toString()
            val pesoStr = userPeso.text.toString()
            if(altStr.isNotEmpty() && pesoStr.isNotEmpty()) {
                val altura = altStr.toFloat()
                val peso = pesoStr.toFloat()
                val altura2 = altura * altura
                val imc = peso / altura2

                val intent = Intent(this, ResultActivity::class.java)
                    .apply {
                        putExtra("extraImc", imc)
                    }
                    startActivity(intent)
            } else {
                Toast.makeText(this, "Preencha todos os campos!", Toast.LENGTH_LONG).show()
              }
        }
    }
}