package com.example.ladm_u2_p1_bradleyaddielgonzalezflores_18401121_v1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Circulo() {

    var x: Float = 0f
    var y: Float = 0f
    var radius: Float = 0f
    var paint = Paint().apply {
        color = Color.WHITE
    }

    init {
        // val randomValue: Double = rangeMin + (rangeMax - rangeMin) * r.nextDouble()
        x = 5 + (1100 - 5) * Random.nextFloat()
        y = 5 + (2400 - 5) * Random.nextFloat()
    }

    fun drawSnow(canvas: Canvas) {
        radius = 5f
        canvas.drawCircle(x, y, radius, paint)
    }

    fun startSnowing(canvas: Canvas) {
        y += 5f
        if (y > canvas.height) {
            y = 0f
            x = 5 + (1100 - 5) * Random.nextFloat()
        }
    }

    fun drawBlizzard(canvas: Canvas) {
        radius = 8f
        canvas.drawCircle(x, y, radius, paint)
    }

    fun startBlizzard(canvas: Canvas) {
        y += 10f
        if (y > canvas.height) {
            y = 0f
            x = 0 + (1100 - 0) * Random.nextFloat()
        }
    }
}