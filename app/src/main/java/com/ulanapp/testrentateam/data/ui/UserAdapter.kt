package com.ulanapp.testrentateam.data.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ulanapp.testrentateam.data.model.User
import com.ulanapp.testrentateam.databinding.UserItemBinding
import com.ulanapp.testrentateam.databinding.UserItemBindingImpl
import okhttp3.internal.userAgent

class UserAdapter: RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    val data : List<User> = TODO()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val userBinding = UserItemBinding.inflate(inflater,parent, false)
        return UserViewHolder(userBinding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = data[position]
        holder.userBinding.user
    }

    class UserViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
        var userBinding: UserItemBinding= UserItemBinding.bind(itemView)
    }
}