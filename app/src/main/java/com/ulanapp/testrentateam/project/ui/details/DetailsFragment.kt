package com.ulanapp.testrentateam.project.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ulanapp.testrentateam.project.data.model.User
import com.ulanapp.testrentateam.project.ui.main.MainActivity
import com.ulanapp.testrentateam.databinding.DetailsFragmentBinding
import com.ulanapp.testrentateam.project.ui.BaseFragment
import dagger.android.support.DaggerFragment

class DetailsFragment : BaseFragment() {

    private val USER_ARG: String? = "user_arg"

    private lateinit var currentUser: User
    private lateinit var detailsFragmentBinding: DetailsFragmentBinding

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

    companion object {
        fun newInstance(user: User) = DetailsFragment()
            .apply {
                arguments = Bundle(2).apply {
                    putParcelable(USER_ARG, user)
                }
            }
    }
}