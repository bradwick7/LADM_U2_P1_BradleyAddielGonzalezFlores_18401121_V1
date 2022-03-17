package com.example.ladm_u2_p1_bradleyaddielgonzalezflores_18401121_v1

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
}