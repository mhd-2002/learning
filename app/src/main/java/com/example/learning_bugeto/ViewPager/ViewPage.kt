package com.example.learning_bugeto.ViewPager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.learning_bugeto.databinding.ActivityViewPageBinding
import com.google.android.material.tabs.TabLayoutMediator

class ViewPage : AppCompatActivity() {
    lateinit var binding: ActivityViewPageBinding

    private val tabs = arrayOf("chats", "status", "calls")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        tabAdapter()
    }

    private fun tabAdapter() {
        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = tabs[position]

        }.attach()

    }
}