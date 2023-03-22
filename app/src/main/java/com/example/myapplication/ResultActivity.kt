package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView

class ResultActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val resultTxt = findViewById<TextView>(R.id.result_txt)
        val classificationTxt = findViewById<TextView>(R.id.classification_txt)

        val result = intent.getFloatExtra("extraImc", 0.1f)

        resultTxt.text = result.toString()

        var classificacao = ""

        when{
          result < 18.5 -> classificacao = "Abaixo do peso"
          result < 25.0 -> classificacao = "Peso ideal"
          result < 30.0 -> classificacao = "Excesso de peso"
          else -> classificacao = "Obesidade"
        }

        classificationTxt.text = getString(R.string.classification, classificacao)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }
}