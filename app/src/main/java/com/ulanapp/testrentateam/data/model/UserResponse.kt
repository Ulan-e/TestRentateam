package com.ulanapp.testrentateam.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


data class UserResponse(
    val ad: Ad,
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)

@Entity(tableName = "cachedUsers")
data class User(
    @PrimaryKey
    val id: Int,
    val avatar: String,
    val email: String,
    val first_name: String,
    val last_name: String
)

data class Ad(
    val company: String,
    val text: String,
    val url: String
)