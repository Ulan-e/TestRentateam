package com.ulanapp.testrentateam.project.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.project.data.DataRepository
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.listeners.OnUserClickListener
import com.ulanapp.testrentateam.project.ui.details.DetailsFragment
import com.ulanapp.testrentateam.project.ui.main.MainActivity
import com.ulanapp.testrentateam.databinding.HomeFragmentBinding
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(),
    OnUserClickListener {

    private lateinit var homeFragmentBinding: HomeFragmentBinding
    private lateinit var homeViewModel: HomeViewModel

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

        (activity as MainActivity).supportActionBar?.title = "Главная"

        val repository = DataRepository(activity!!)
        homeViewModel = ViewModelProvider(
            activity!!,
            HomeViewModelFactory(repository)
        ).get(HomeViewModel::class.java)
        homeFragmentBinding.homeViewModel = homeViewModel

        homeViewModel.data.observe(activity!!, Observer { users ->
            setUpAdapter(users)
        })

        homeViewModel.loadingProgress.observe(activity!!, Observer { progress ->
            progress_bar.visibility = if (progress == true)
                View.VISIBLE
            else
                View.GONE
        })

        homeViewModel.errorMessage.observe(activity!!, Observer { errorMessage ->
            if (!errorMessage.isNullOrEmpty()) {
                Toast.makeText(activity!!, "Error loading data", Toast.LENGTH_SHORT).show()
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