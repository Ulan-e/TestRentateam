package com.ulanapp.testrentateam.data.ui.details

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.home_fragment.view.*

class ProfileImageAdapter {

    companion object{

        @BindingAdapter("imageUrl", "errorImage", requireAll = false)
        @JvmStatic
        fun ImageView.setPhoto(url: String, errorImage: Drawable){
            Glide.with(context).load(url).circleCrop().error(errorImage).into(this)
        }
    }

}