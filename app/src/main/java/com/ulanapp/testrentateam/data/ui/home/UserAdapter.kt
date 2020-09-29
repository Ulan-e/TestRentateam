package com.ulanapp.testrentateam.data.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.ulanapp.testrentateam.data.data.model.User
import com.ulanapp.testrentateam.data.ui.OnUserClickListener
import com.ulanapp.testrentateam.databinding.UserItemBinding
import kotlinx.android.synthetic.main.user_item.view.*

class UserAdapter(private var data: List<User>,
private var clickListener: OnUserClickListener) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

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

