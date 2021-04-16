package com.ulanapp.mvvm.project.ui.details

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class ProfileImageAdapter {

    companion object{

        @BindingAdapter("imageUrl", "errorImage", requireAll = false)
        @JvmStatic
        fun ImageView.setPhoto(url: String, errorImage: Drawable){
            Glide.with(context).load(url).circleCrop().error(errorImage).into(this)
        }
    }
}