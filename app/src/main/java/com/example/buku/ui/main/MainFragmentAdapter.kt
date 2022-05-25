package com.example.buku.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.ListAdapter
import com.example.buku.data.BukuJapan
import com.example.buku.databinding.ListViewItemBinding

class MainFragmentAdapter(private val clickListener: PoetryListener) :
    ListAdapter<BukuJapan, MainFragmentAdapter.PoetryViewHolder>(DiffCallback)
{
    class PoetryViewHolder(
        var binding: ListViewItemBinding
    ) : RecyclerView.ViewHolder(binding.root){
        fun bind(clickListener: PoetryListener, poetry: BukuJapan){
            binding.bukuJapan = poetry
            binding.clickListener = clickListener
            binding.executePendingBindings()
        }
    }

    companion object DiffCallback : DiffUtil.ItemCallback<BukuJapan>(){
        override fun areItemsTheSame(oldItem: BukuJapan, newItem: BukuJapan): Boolean {
            return oldItem.results?.id == newItem.results?.id
        }

        override fun areContentsTheSame(oldItem: BukuJapan, newItem: BukuJapan): Boolean {
            return oldItem.results?.title == newItem.results?.title
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : PoetryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return PoetryViewHolder(
            ListViewItemBinding.inflate(layoutInflater, parent, false)
        )
    }

    override fun onBindViewHolder(holder: PoetryViewHolder, position: Int){
        val poetry = getItem(position)
        holder.bind(clickListener, poetry)
    }
}

class PoetryListener(val clickListener: (poetry: BukuJapan) -> Unit){
    fun onClick(poetry: BukuJapan) = clickListener(poetry)
}