package com.ulanapp.testrentateam.data.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.DataRepository
import com.ulanapp.testrentateam.data.model.User
import kotlinx.android.synthetic.main.home_fragment.*

class HomeFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val homeViewModel  = ViewModelProvider(activity!!).get(HomeViewModel::class.java)
        val repo = DataRepository(activity!!)
        homeViewModel.setRepo(repo)
        homeViewModel.doSomething()
        homeViewModel.data.observe(activity!!, Observer { t ->
            setUpAdapter(t)
        }        )
    }

    private fun setUpAdapter(list: List<User>?) {
        val adapter = UserAdapter(list!!)
        val layoutManager = LinearLayoutManager(activity!!)
        user_recycler_view.layoutManager  = layoutManager
        user_recycler_view.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}