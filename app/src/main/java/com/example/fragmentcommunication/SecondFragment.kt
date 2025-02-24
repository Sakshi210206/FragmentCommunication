package com.example.fragmentcommunication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.fragmentcommunication.FirstFragment.OnNameSetListener
import com.example.fragmentcommunication.databinding.FragmentSecondBinding

class SecondFragment :Fragment(){
    private lateinit var fragmentSecondBinding : FragmentSecondBinding
        var text2 =""
        set(value){
            field = value
            fragmentSecondBinding.edtCity.setText(value)
        }
    //way 3 - create an interface with a function inside it
    interface OnCitySetListener{
        fun onCitySet(text: String)
    }

    lateinit var onCitySetListener: OnCitySetListener  //reference of a listener

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentSecondBinding = FragmentSecondBinding.inflate(layoutInflater)
        fragmentSecondBinding.btnSendDataToSecondFragment.setOnClickListener{
            //way  3 using interface with a function inside it
            onCitySetListener.onCitySet(fragmentSecondBinding.edtCity.text.toString())

            //way 2
         //   (requireActivity() as MainActivity).sendDataToFirstFragment(
         //       fragmentSecondBinding.edtCity.text.toString())

            //way1
       //     (parentFragmentManager.findFragmentById(R.id.fragmentFirst) as FirstFragment).text1 =
        //        fragmentSecondBinding.edtCity.text.toString()
        }
        return fragmentSecondBinding.root
    }
}