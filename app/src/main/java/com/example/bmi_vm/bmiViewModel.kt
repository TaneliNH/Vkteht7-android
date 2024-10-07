package com.example.bmi_vm

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import kotlin.math.pow

class bmiViewModel: ViewModel() {
    var weightInput by mutableStateOf("")
    var heightInput by mutableStateOf("")
    var bmi by mutableStateOf("0.0")
    val exponent = 2

    fun changeWeightInput(value: String) {
        weightInput = value
    }

    fun changeHeightInput(value: String) {
        heightInput = value
    }

    private var weight: Double? = 0.0
        get() = weightInput.toDoubleOrNull() ?: 0.0


    private var height: Double? = 0.0
        get() = heightInput.toDoubleOrNull() ?: 0.0


    fun calc() {
        if (height != null) {
            val bmiResult = weight?.div((height!!.pow(exponent)))
            bmi = bmiResult.toString()
        } else {
            bmi = "Invalid height!"
        }
    }
}