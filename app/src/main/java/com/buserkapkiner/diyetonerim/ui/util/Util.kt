package com.buserkapkiner.diyetonerim.ui.util

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.buserkapkiner.diyetonerim.R

fun ImageView.pictureInstall(url:String?,placeholder:CircularProgressDrawable){
    val option=RequestOptions().placeholder(placeholder).error(R.drawable.error)
    Glide.with(context).setDefaultRequestOptions(option).load(url).into(this)

}
fun placeholderCreate(context:Context):CircularProgressDrawable{
    return CircularProgressDrawable(context).apply {
        strokeWidth=7f
        centerRadius=35f
        start()
    }

}