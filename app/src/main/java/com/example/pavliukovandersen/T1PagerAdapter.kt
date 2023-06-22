package com.example.pavliukovandersen

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class T1PagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {

    override fun getItemCount() = 3

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> T1TextViewFragment()
            1 -> T1EditTextFragment()
            else -> T1RecyclerViewFragment()
        }
    }
}