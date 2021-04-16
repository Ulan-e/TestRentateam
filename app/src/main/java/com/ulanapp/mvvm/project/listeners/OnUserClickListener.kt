package com.ulanapp.mvvm.project.listeners

import com.ulanapp.mvvm.project.data.model.User

interface OnUserClickListener {

    fun onItemClick(user: User)
}