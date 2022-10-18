package com.example.mvvm_assignment_01.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.mvvm_tests.R
import com.example.mvvm_tests.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel
    private lateinit var binding: FragmentMainBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
       binding =  DataBindingUtil.inflate<FragmentMainBinding>(inflater,R.layout.fragment_main,container,false)
       binding.vm = viewModel
       return binding.root;
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

       binding.input.addTextChangedListener(object : TextWatcher {

           override fun afterTextChanged(s: Editable) {}

           override fun beforeTextChanged(s: CharSequence, start: Int,
                                          count: Int, after: Int) {
           }

           override fun onTextChanged(s: CharSequence, start: Int,
                                      before: Int, count: Int) {
               viewModel.update(binding.message, s)
               println(s)
           }
       })


    }

}