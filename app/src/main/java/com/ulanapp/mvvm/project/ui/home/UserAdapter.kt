package com.ulanapp.mvvm.project.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ulanapp.mvvm.project.data.model.User
import com.ulanapp.mvvm.project.listeners.OnUserClickListener
import com.ulanapp.mvvm.databinding.UserItemBinding

class UserAdapter(
    private var data: List<User>,
    private var clickListener: OnUserClickListener
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val userBinding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(
            userBinding
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = data[position]
        holder.binding.setUser(user)
        holder.bind(clickListener)
    }

    class UserViewHolder(var binding: UserItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: OnUserClickListener){
            binding.clickListener = clickListener
        }
    }
}

