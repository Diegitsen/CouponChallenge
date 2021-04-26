package com.diegitsen.couponchallenge.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.databinding.AdapterCouponBinding

class CouponAdapter(private var items: ArrayList<Coupon>, private val mListener: CouponItemClickListener) : RecyclerView.Adapter<CouponAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AdapterCouponBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position], mListener)
    }

    fun replaceData(arrayList: ArrayList<Coupon>) {
        items = arrayList
        notifyDataSetChanged()
    }

    class ViewHolder(private var binding: AdapterCouponBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(coupon: Coupon, listener: CouponItemClickListener) {
            binding.coupon = coupon
            binding.couponItemClick = listener
            binding.executePendingBindings()
        }
    }

    interface CouponItemClickListener {
        fun onCouponItemClicked(coupon: Coupon)
    }

}