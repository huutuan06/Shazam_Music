package com.tuannguyen.shazammusic.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.tuannguyen.shazammusic.data.model.SongInfo
import com.tuannguyen.shazammusic.databinding.ItemSongBinding

class SongsAdapter: RecyclerView.Adapter<SongsAdapter.SongViewHolder>() {

    val callback = object : DiffUtil.ItemCallback<SongInfo>() {
        override fun areItemsTheSame(oldItem: SongInfo, newItem: SongInfo): Boolean {
            return oldItem.key == newItem.key
        }

        override fun areContentsTheSame(oldItem: SongInfo, newItem: SongInfo): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val binding = ItemSongBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return SongViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        val song = differ.currentList[position]
        holder.bind(song)
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    val differ = AsyncListDiffer(this, callback)

    inner class SongViewHolder(
        private val binding: ItemSongBinding
    ): RecyclerView.ViewHolder(binding.root) {
        fun bind(song: SongInfo) {
            binding.songTitle.text = song.title
        }
    }
}