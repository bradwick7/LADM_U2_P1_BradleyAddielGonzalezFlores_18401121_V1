package com.example.ladm_u2_p1_bradleyaddielgonzalezflores_18401121_v1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.delay

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(Lienzo(this))
        supportActionBar!!.hide()
    }
}