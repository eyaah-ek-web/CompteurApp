package com.example.tp3_composant

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.tp3_composant.CounterViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: CounterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        val btnIncrement = findViewById<Button>(R.id.btnIncrement)
        val btnDecrement = findViewById<Button>(R.id.btnDecrement)

        viewModel = ViewModelProvider(this)
            .get(CounterViewModel::class.java)
        viewModel.counter.observe(this) { value ->
            tvCounter.text = "Compteur : $value"
        }
        btnIncrement.setOnClickListener {
            viewModel.increment()
        }
        btnDecrement.setOnClickListener {
            viewModel.decrement()
        }
    }
}
