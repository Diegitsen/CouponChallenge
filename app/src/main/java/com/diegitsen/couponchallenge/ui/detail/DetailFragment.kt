package com.diegitsen.couponchallenge.ui.detail

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.diegitsen.couponchallenge.R
import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.databinding.FragmentDetailBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.IOException


class DetailFragment : Fragment(), IDetailContract.IDetailView {

    private lateinit var presenter: DetailPresenter
    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = DetailPresenter()
        presenter.attachView(this)
        //presenter.getCoupon(1)
        binding.executePendingBindings()
        setupListeners(view)

        if (arguments != null) {
            val args = DetailFragmentArgs.fromBundle(requireArguments())
            val coupon = args.coupon
            presenter.getCoupon(coupon)
        }

    }

    override fun showCoupon(coupon: Coupon) {
        binding.coupon = coupon
    }

    override fun setupViews() {

    }

    override fun setupListeners(view: View) {
        view.findViewById<ImageButton>(R.id.ibDetailBack).setOnClickListener {
            findNavController().navigate(R.id.action_DetailFragment_to_HomeFragment)
        }
    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showError(error: String) {

    }

    interface BackClickListener {
        fun onBackClicked()
    }


}