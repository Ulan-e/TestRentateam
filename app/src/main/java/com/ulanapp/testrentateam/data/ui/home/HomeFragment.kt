package com.ulanapp.testrentateam.data.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.data.DataRepository
import com.ulanapp.testrentateam.data.data.model.User
import com.ulanapp.testrentateam.data.listeners.OnUserClickListener
import com.ulanapp.testrentateam.data.ui.details.DetailsFragment
import com.ulanapp.testrentateam.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(),
    OnUserClickListener {

    private lateinit var homeFragmentBinding: HomeFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false)
        return homeFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val repository = DataRepository(activity!!)
        val homeViewModel = ViewModelProvider(
            activity!!,
            HomeViewModelFactory(repository)
        ).get(HomeViewModel::class.java)
        homeFragmentBinding.homeViewModel = homeViewModel

        homeViewModel.data.observe(activity!!, Observer { t ->
            setUpAdapter(t)
        })

        homeViewModel.loadingProgress.observe(activity!!, Observer { t ->
            if (t == true) {
                progress_bar.visibility = View.VISIBLE
            } else {
                progress_bar.visibility = View.GONE
            }
        })

        homeViewModel.errorMessage.observe(activity!!, Observer { t ->
            if (!t.isNullOrEmpty()) {
                homeFragmentBinding.errorMessage.visibility = View.VISIBLE
                homeFragmentBinding.errorMessage.text = "Error loading data"
            }
        })
    }

    private fun setUpAdapter(list: List<User>?) {
        val userAdapter = UserAdapter(list!!, this)
        val linearLayoutInflater = LinearLayoutManager(activity!!)
        homeFragmentBinding.userRecyclerView.apply {
            layoutManager = linearLayoutInflater
            adapter = userAdapter
        }
        userAdapter.notifyDataSetChanged()
    }

    override fun onItemClick(user: User) {
        activity!!.supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, DetailsFragment.newInstance(user))
            .addToBackStack(null)
            .commit()
    }

}