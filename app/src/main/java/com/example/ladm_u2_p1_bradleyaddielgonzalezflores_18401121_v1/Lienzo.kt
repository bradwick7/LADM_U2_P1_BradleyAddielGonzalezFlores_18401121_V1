package com.example.ladm_u2_p1_bradleyaddielgonzalezflores_18401121_v1

import android.annotation.SuppressLint
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.*
import kotlin.random.Random

@SuppressLint("ViewConstructor")
class Lienzo constructor(pointer: MainActivity) : View(pointer) {

    var circulos = Array(300) { Circulo() }
    var circulosBig = Array(300) { Circulo() }
    val p = Paint()

    var counter = 0
    var decrement = 0
    var randomB = 0
    var blizzard = false

    init {
        randomB = Random.nextInt(5) + 2
        randomB *= 100
        decrement = randomB * (Random.nextInt(3) + 3)

        println("SecondsBlizzard =$randomB")
        println("Decrement =$decrement")
    }

    @DelicateCoroutinesApi
    val coroutine = GlobalScope.launch {
        while (true) {
            pointer.runOnUiThread {
                if (randomB == counter) {
                    blizzard = true
                    if (decrement == 0) {
                        blizzard = false
                        counter = 0
                        decrement = randomB * (Random.nextInt(3) + 1)
                    } else {
                        decrement--
                    }
                } else {
                    counter++
                }

                invalidate()
            }
            delay(5L)
        }
    }

    @SuppressLint("DrawAllocation")
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        // Background
        p.style = Paint.Style.FILL
        canvas.drawColor(rgb(27, 35, 46))

        // Moon
        p.color = Color.LTGRAY
        canvas.drawCircle(250f, 270f, 150f, p)

        // Hills
        p.color = rgb(0, 94, 44)
        canvas.drawCircle(900f, 1540f, 600f, p)
        p.color = rgb(0, 168, 0)
        canvas.drawCircle(0f, 1840f, 600f, p)
        p.color = rgb(85, 179, 129)
        canvas.drawCircle(900f, 2240f, 600f, p)

        // House front wall
        p.color = rgb(42, 75, 80)
        canvas.drawRoundRect(1000f, (height - 450f), (width - 500f), (height + 0f), 20f, 20f, p)
        // House window
        p.color = Color.LTGRAY
        canvas.drawRoundRect(620f, (height - 400f), 750f, (height - 210f), 20f, 20f, p)
        // House door
        p.color = rgb(128, 28, 13)
        canvas.drawRoundRect(800f, (height - 300f), 900f, (height + 0f), 20f, 20f, p)
        // House door window
        p.color = rgb(255, 231, 85)
        canvas.drawCircle(880f, (height - 220f), 5f, p)
        // House three windows
        p.color = Color.LTGRAY
        canvas.drawCircle(880f, (height - 400f), 25f, p)
        canvas.drawCircle(950f, (height - 400f), 25f, p)
        // House base
        p.color = rgb(100, 100, 100)
        canvas.drawRoundRect(1000f, (height - 120f), (width - 500f), (height + 0f), 20f, 20f, p)

        // Lamp post
        p.color = rgb(122, 100, 56)
        canvas.drawRoundRect(230f, (height - 450f), 250f, (height + 0f), 20f, 20f, p)
        p.color = rgb(255, 231, 85)
        canvas.drawCircle(240f, (height - 450f), 30f, p)

        // Ground
        p.color = Color.WHITE// dark green rgb(20, 70, 42)
        canvas.drawRoundRect(0f, (height - 100f), (width + 0f), (height + 0f), 20f, 20f, p)

        // Snow
        for (circulo in circulos) {
            circulo.drawSnow(canvas)
            circulo.startSnowing(canvas)
        }

        // Blizzard
        if (blizzard) {
            // Lamp light turns red when a blizzard occurs
            p.color = Color.RED
            canvas.drawCircle(240f, (height - 450f), 30f, p)

            for (circulo in circulosBig) {
                circulo.drawBlizzard(canvas)
                circulo.startBlizzard(canvas)
            }
        } else {
            // Lamp light turns yellow when there is no blizzard
            p.color = rgb(255, 231, 85)
            canvas.drawCircle(240f, (height - 450f), 30f, p)
        }
    }
}