package com.ulanapp.mvvm.project.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ulanapp.mvvm.project.data.model.User
import com.ulanapp.mvvm.project.ui.main.MainActivity
import com.ulanapp.mvvm.databinding.DetailsFragmentBinding
import com.ulanapp.mvvm.project.ui.BaseFragment

class DetailsFragment : BaseFragment() {

    private lateinit var currentUser: User
    private lateinit var detailsFragmentBinding: DetailsFragmentBinding

    companion object {

        const val USER_ARG: String = "user_arg"

        fun newInstance(user: User) = DetailsFragment()
            .apply {
                arguments = Bundle(2).apply {
                    putParcelable(USER_ARG, user)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        detailsFragmentBinding = DetailsFragmentBinding.inflate(inflater, container, false)
        return detailsFragmentBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (activity as MainActivity).supportActionBar?.title = "Профиль"

        currentUser = arguments!!.getParcelable(USER_ARG)
        detailsFragmentBinding.curentUser = currentUser

    }
}