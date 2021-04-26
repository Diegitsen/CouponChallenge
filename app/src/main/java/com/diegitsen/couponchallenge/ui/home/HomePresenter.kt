package com.diegitsen.couponchallenge.ui.home

import android.content.Context
import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.data.repository.CouponRepository
import com.diegitsen.couponchallenge.data.repository.OnCouponRepositoryReadyCallback
import com.diegitsen.couponchallenge.ui.main.IBaseContract

class HomePresenter(context: Context?) : IHomeContract.IHomePresenter {

    private var view: IHomeContract.IHomeView? = null
    private var couponRepository = context?.let { CouponRepository(it) }

    override fun getCoupons() {
        couponRepository?.getCoupons(object : OnCouponRepositoryReadyCallback{
            override fun onDataReady(data: ArrayList<Coupon>) {
                view?.showCoupons(data)
            }
        })
    }

    override fun attachView(view: IBaseContract.IBaseView) {
        this.view = view as IHomeContract.IHomeView
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }
}