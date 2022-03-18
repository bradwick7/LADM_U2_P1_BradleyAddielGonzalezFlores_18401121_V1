package com.example.ladm_u2_p1_bradleyaddielgonzalezflores_18401121_v1

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.rgb
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class Lienzo(pointer: MainActivity) : View(pointer) {

    var circulos = Array(150) { Circulo(this) }

    val coroutine = GlobalScope.launch {
        while (true) {
            pointer.runOnUiThread {
                invalidate()
            }
            delay(1L)
        }
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val p = Paint()

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
        p.color = rgb(20, 70, 42)
        canvas.drawRoundRect(0f, (height - 100f), (width + 0f), (height + 0f), 20f, 20f, p)

        // Snow
        for (circulo in circulos) {
            circulo.drawSnow(canvas)
            circulo.startSnowing(canvas)
        }
    }
}