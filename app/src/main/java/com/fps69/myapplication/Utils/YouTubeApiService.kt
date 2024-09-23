package com.fps69.myapplication.Utils

import com.fps69.myapplication.DataClass.YouTubeResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {

    @GET("search")
    fun searchVideos(
        @Query("part") part: String,
        @Query("channelId") channelId: String,
        @Query("maxResults") maxResults: Int,
        @Query("order") order: String,
        @Query("type") type: String,
        @Query("key") apiKey: String
    ): Call<YouTubeResponse>
}