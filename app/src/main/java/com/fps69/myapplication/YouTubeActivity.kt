package com.fps69.myapplication

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fps69.Reels.R
import com.fps69.Reels.databinding.ActivityYouTubeBinding
import com.fps69.myapplication.Adapter.ShortsAdapter
import com.fps69.myapplication.DataClass.YouTubeResponse
import com.fps69.myapplication.Utils.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class YouTubeActivity : AppCompatActivity() {

    private val apiKey = getString(R.string.apikey)
    private val channelId = "UCkvtJk_Ph_kQHkvtNGzmFmQ"
    private lateinit var adapter: ShortsAdapter


    private lateinit var binding: ActivityYouTubeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityYouTubeBinding.inflate(layoutInflater)
        setContentView(binding.root)


        fetchYouTubeVideos()
    }

    private fun fetchYouTubeVideos() {
        RetrofitInstance.apiService.searchVideos(
            part = "snippet",
            channelId = channelId,
            maxResults = 10,
            order = "date",
            type = "video",
            apiKey = apiKey
        ).enqueue(object : Callback<YouTubeResponse> {
            override fun onResponse(call: Call<YouTubeResponse>, response: Response<YouTubeResponse>) {
                if (response.isSuccessful) {
                    val videoItems = response.body()?.items ?: emptyList()
                    adapter = ShortsAdapter(videoItems)
                    setupRecyclerView()
                }
            }

            override fun onFailure(call: Call<YouTubeResponse>, t: Throwable) {
                // Handle failure
            }
        })
    }

    private fun setupRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.adapter = adapter
    }
}
