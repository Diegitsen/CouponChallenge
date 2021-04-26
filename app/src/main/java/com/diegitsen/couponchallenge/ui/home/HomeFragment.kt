package com.diegitsen.couponchallenge.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.diegitsen.couponchallenge.R
import com.diegitsen.couponchallenge.data.entity.Coupon
import com.diegitsen.couponchallenge.databinding.FragmentHomeBinding
import com.diegitsen.couponchallenge.ui.detail.DetailFragmentDirections

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment(), IHomeContract.IHomeView, CouponAdapter.CouponItemClickListener {


    private lateinit var presenter: HomePresenter
    private val couponAdapter = CouponAdapter(arrayListOf(), this)
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_home, container, false)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = HomePresenter(context)
        presenter.attachView(this)
        presenter.getCoupons()

        binding.executePendingBindings()
        binding.rvCoupons.layoutManager = LinearLayoutManager(context)
        binding.rvCoupons.adapter = couponAdapter
        /*view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_DetailFragment)
        }*/
    }

    override fun showCoupons(coupons: ArrayList<Coupon>) {
        Log.e("hey!",coupons.toString())
        couponAdapter.replaceData(coupons)
    }

    override fun setupViews() {

    }

    override fun setupListeners(view: View) {

    }

    override fun showProgress() {

    }

    override fun hideProgress() {

    }

    override fun showError(error: String) {

    }

    override fun onCouponItemClicked(coupon: Coupon) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(coupon)
        findNavController().navigate(action)
        //findNavController().navigate(R.id.action_HomeFragment_to_DetailFragment)
        /*view.findViewById<Button>(R.id.button_first).setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_DetailFragment)
        }*/
       // val action =
        /*
        val action = HistoricFragmentDirections.actionNavHistoricToNavOrderDetail(id)
        navController.navigate(action)
         */
    }
}