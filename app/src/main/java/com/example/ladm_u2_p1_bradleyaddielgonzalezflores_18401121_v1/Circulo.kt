package com.example.ladm_u2_p1_bradleyaddielgonzalezflores_18401121_v1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import kotlin.random.Random

class Circulo(lienzo: Lienzo) {

    var x: Float = 0f
    var y: Float = 0f
    var radius: Float = 0f

    init {
        // val randomValue: Double = rangeMin + (rangeMax - rangeMin) * r.nextDouble()
        val randomX: Float = 25 + (1100 - 25) * Random.nextFloat()
        val randomY: Float = 100 + (2100 - 100) * Random.nextFloat()
        x = randomX
        y = randomY
        radius = 10f
    }

    fun startSnowing(canvas: Canvas) {
        y += 10

        if (x > canvas.height) x = 100f
    }

    fun drawSnow(canvas: Canvas) {
        var paint = Paint()
        paint.color = Color.WHITE
        canvas.drawCircle(x, y, radius, paint)
    }

}