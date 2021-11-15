package com.tuannguyen.shazammusic.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tuannguyen.shazammusic.data.model.Song
import com.tuannguyen.shazammusic.databinding.ItemSongBinding

class SongsAdapter: RecyclerView.Adapter<SongsAdapter.SongViewHolder>() {

    val callback = object : DiffUtil.ItemCallback<Song>() {
        override fun areItemsTheSame(oldItem: Song, newItem: Song): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Song, newItem: Song): Boolean {
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
        fun bind(song: Song) {
            binding.title.text = song.title
            binding.artist.text = song.primaryArtist!!.name

            Glide.with(binding.thumbnail.context)
                .load(song.ImageUrl)
                .into(binding.thumbnail)

            binding.root.setOnClickListener {
                onItemClickListener?.let {
                    it(song)
                }
            }
        }
    }

    private var onItemClickListener: ((Song) -> Unit)? = null

    fun setOnItemClickListener(listener: (Song) -> Unit) {
        onItemClickListener = listener
    }
}