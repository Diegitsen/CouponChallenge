package com.diegitsen.couponchallenge.ui.detail

import android.util.Log
import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.ui.home.IHomeContract
import com.diegitsen.couponchallenge.ui.main.IBaseContract

class DetailPresenter : IDetailContract.IDetailPresenter  {

    private var view: IDetailContract.IDetailView? = null

    override fun getCoupon(coupon: Coupon) {
        view?.showCoupon(coupon)
    }

    override fun attachView(view: IBaseContract.IBaseView) {
        this.view = view as IDetailContract.IDetailView
    }

    override fun dettachView() {
        view = null
    }

    override fun isViewAttached(): Boolean {
        return view != null
    }
}