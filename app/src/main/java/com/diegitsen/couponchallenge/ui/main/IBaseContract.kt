package com.diegitsen.couponchallenge.ui.main

import android.view.View

interface IBaseContract {

    interface IBaseView {
        fun setupViews()
        fun setupListeners(view: View)
        fun showProgress()
        fun hideProgress()
        fun showError(error: String)
    }

    interface IBasePresenter {
        fun attachView(view: IBaseView)
        fun dettachView()
        fun isViewAttached(): Boolean
    }

}