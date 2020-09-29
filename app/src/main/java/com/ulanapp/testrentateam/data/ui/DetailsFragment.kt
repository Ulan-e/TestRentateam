package com.ulanapp.testrentateam.data.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ulanapp.testrentateam.R
import com.ulanapp.testrentateam.data.data.model.User

class DetailsFragment : Fragment() {

    private val USER_ARG: String? = "user_arg"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.details_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        fun newInstance(user: User) = DetailsFragment().apply {
            arguments = Bundle(2).apply {
                putParcelable(USER_ARG, user)
            }
        }
    }
}