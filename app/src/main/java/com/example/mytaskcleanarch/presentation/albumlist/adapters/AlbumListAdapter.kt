package com.example.mytaskcleanarch.presentation.albumlist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.mytaskcleanarch.databinding.AlbumItemBinding
import model.Album

class AlbumListAdapter() :
    ListAdapter<Album, AlbumListAdapter.AlbumHolder>(Companion) {

    companion object : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: Album, newItem: Album): Boolean =
            oldItem.id == newItem.id
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlbumHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AlbumItemBinding.inflate(layoutInflater, parent, false)

        return AlbumHolder(binding)
    }

    override fun onBindViewHolder(holder: AlbumHolder, position: Int) {
        val album = getItem(position)
        holder.binding.apply {
            this.album = album
            executePendingBindings()
        }
    }

    class AlbumHolder(val binding: AlbumItemBinding) : RecyclerView.ViewHolder(binding.root)
}