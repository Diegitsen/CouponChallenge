package com.diegitsen.couponchallenge.data.repository

import android.content.Context
import com.diegitsen.couponchallenge.data.datasource.CouponLocalDatasource
import com.diegitsen.couponchallenge.data.datasource.OnCouponLocalReadyCallback
import com.diegitsen.couponchallenge.data.entity.Coupon

class CouponRepository(context: Context) {
    private val localDataSource = CouponLocalDatasource(context)

    fun getCoupons(onCouponRepositoryReadyCallback: OnCouponRepositoryReadyCallback) {
        localDataSource.getCoupons(object : OnCouponLocalReadyCallback{
            override fun onCouponDataReady(data: ArrayList<Coupon>) {
                onCouponRepositoryReadyCallback.onDataReady(data)
            }
        })
    }
}

interface OnCouponRepositoryReadyCallback {
    fun onDataReady(
        data: ArrayList<Coupon>
    )
}