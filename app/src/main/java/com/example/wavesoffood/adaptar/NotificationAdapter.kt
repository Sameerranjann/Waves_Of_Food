package com.example.wavesoffood.adaptar

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.wavesoffood.databinding.FragmentHistoryBinding
import com.example.wavesoffood.databinding.NotificationItemBinding

class NotificationAdapter (private var notification :ArrayList<String>, private var notificationImage :ArrayList<Int>): RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationViewHolder {
       val binding = NotificationItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NotificationViewHolder(binding)
    }


    override fun onBindViewHolder(holder: NotificationViewHolder, position: Int) {
        holder.bind(position)

    }
    override fun getItemCount(): Int  = notification.size


    inner class NotificationViewHolder(private val binding: NotificationItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(position: Int) {
      binding.apply {
          notificationTextView.text  = notification[position]
          notoficationImageView.setImageResource(notificationImage[position])
      }
        }

    }
}