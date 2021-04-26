package com.diegitsen.couponchallenge.ui.home

import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.ui.main.IBaseContract


interface IHomeContract {
    interface IHomeView: IBaseContract.IBaseView {
        fun showCoupons(coupons:ArrayList<Coupon>)
    }

    interface IHomePresenter: IBaseContract.IBasePresenter {
        fun getCoupons()
    }
}