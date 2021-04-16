package com.ulanapp.mvvm.project.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

data class UserResponse(
    val ad: Ad,
    val data: List<User>,
    val page: Int,
    val per_page: Int,
    val total: Int,
    val total_pages: Int
)

@Parcelize
@Entity(tableName = "cachedUsers")
data class User(
    @PrimaryKey
    var id: Int,
    var avatar: String,
    var email: String,
    var first_name: String,
    var last_name: String
) : Parcelable

data class Ad(
    var company: String,
    var text: String,
    var url: String
)