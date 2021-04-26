package com.diegitsen.couponchallenge.ui.detail

import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.ui.main.IBaseContract

interface IDetailContract {
    interface IDetailView: IBaseContract.IBaseView {
        fun showCoupon(coupon:Coupon)
    }

    interface IDetailPresenter: IBaseContract.IBasePresenter {
        fun getCoupon(coupon:Coupon)
    }
}