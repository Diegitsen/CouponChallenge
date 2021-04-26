package com.diegitsen.couponchallenge.data.datasource

import android.content.Context
import android.util.Log
import com.diegitsen.couponchallenge.data.entity.Coupon
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException

class CouponLocalDatasource(context: Context) {

    var mContext: Context = context

    private fun getJsonDataFromAsset(context: Context, fileName: String): String? {
        val jsonString: String
        try {
            jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        } catch (ioException: IOException) {
            ioException.printStackTrace()
            return null
        }
        return jsonString
    }

    fun getCoupons(onCouponLocalReadyCallback: OnCouponLocalReadyCallback) {

        val jsonFileString =  getJsonDataFromAsset(mContext, "coupons.json")

        val gson = Gson()
        val listCouponType = object : TypeToken<List<Coupon>>() {}.type

        var coupons: ArrayList<Coupon> = gson.fromJson(jsonFileString, listCouponType)

        onCouponLocalReadyCallback.onCouponDataReady(
            coupons
        )
    }

}

interface OnCouponLocalReadyCallback {
    fun onCouponDataReady(
        data: ArrayList<Coupon>
    )
}