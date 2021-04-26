package com.diegitsen.couponchallenge.data.entity

import android.os.Parcelable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coupon(
    val id: Int,
    val name: String,
    val description: String,
    val type: Int,
    val date: String,
    val image: String):Parcelable
{
}
//to load the image of coupons using glide library
@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).centerCrop().into(view)
}

//to load the image in a circle way using glide library
@BindingAdapter("imageUrlCircle")
fun loadImageCircle(view: ImageView, url: String?) {
    Glide.with(view.context).load(url).circleCrop().into(view)
}