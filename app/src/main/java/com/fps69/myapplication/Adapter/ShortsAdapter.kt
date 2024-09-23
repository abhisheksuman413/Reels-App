package com.fps69.myapplication.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.webkit.WebView
import androidx.recyclerview.widget.RecyclerView
import com.fps69.myapplication.DataClass.VideoItem
import com.fps69.myapplication.R
import com.fps69.myapplication.databinding.SingleShortItemBinding

class ShortsAdapter(private val videoItems: List<VideoItem>) :
    RecyclerView.Adapter<ShortsAdapter.ShortsViewHolder>() {

    inner class ShortsViewHolder(val binding: SingleShortItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShortsViewHolder {
        val binding = SingleShortItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ShortsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ShortsViewHolder, position: Int) {
        val videoId = videoItems[position].id.videoId

        holder.binding.webview.settings.javaScriptEnabled = true
        holder.binding.webview.loadUrl("https://www.youtube.com/embed/$videoId?autoplay=1&playsinline=1")
    }

    override fun getItemCount() = videoItems.size
}
