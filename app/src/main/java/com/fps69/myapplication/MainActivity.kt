package com.fps69.myapplication

import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import com.fps69.Reels.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        binding.apply {
            BTN1.setOnClickListener {
                startActivity(Intent(this@MainActivity, YouTubeActivity::class.java))
                finish()
            }
        }


    }
}