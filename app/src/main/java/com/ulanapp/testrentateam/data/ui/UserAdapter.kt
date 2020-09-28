package com.ulanapp.testrentateam.data.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.ulanapp.testrentateam.data.model.User
import com.ulanapp.testrentateam.databinding.UserItemBinding
import com.ulanapp.testrentateam.databinding.UserItemBindingImpl

class UserAdapter(private var data: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val userBinding = UserItemBinding.inflate(inflater, parent, false)
        return UserViewHolder(userBinding.root)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = data[position]
        holder.userBinding?.setUser(user)
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var userBinding: UserItemBinding? = DataBindingUtil.bind<UserItemBinding>(itemView)
    }
}