package com.technischools.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val programInput = findViewById<EditText>(R.id.programInput)
        val programResult = findViewById<TextView>(R.id.programResult)
        findViewById<Button>(R.id.confirmProgram).setOnClickListener {
            val program = programInput.text.toString().toIntOrNull()
            if (program != null && program in 1..12) {
                programResult.text = getString(R.string.program_selected, program)
            }
        }

        val vacuumButton = findViewById<Button>(R.id.toggleVacuum)
        val vacuumStatus = findViewById<TextView>(R.id.vacuumStatus)
        vacuumButton.setOnClickListener {
            val isOn = vacuumButton.text == getString(R.string.turn_on)
            vacuumButton.setText(if (isOn) R.string.turn_off else R.string.turn_on)
            vacuumStatus.setText(if (isOn) R.string.vacuum_on else R.string.vacuum_off)
        }
    }
}
