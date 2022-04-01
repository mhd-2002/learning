package com.example.learning_bugeto.Fragment

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.learning_bugeto.R

class MyFragment : Fragment() {

    lateinit var name :String
    override fun onAttach(context: Context) {
        super.onAttach(context)   //موقی فرگمت به اکتیویتی اضافه میشه فراخونی میشه
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        name = "ali"
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState) //زمانی اجرا میشه که اکتیویتی والد فرگمنت اجرا بشه
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()  //موقعی که تعامل مخاطب با فرگمنت شروع میشه
    }

    override fun onDestroyView() {
        super.onDestroyView() //موقعی ui فرگمنت از اکتیویتی پاک کیشه
    }

    override fun onDetach() {
        super.onDetach() // موقعی فراخونی میشه ک فرگمنت به طور کامل از التیویتی پاک میشه
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my, container, false)
    }


}