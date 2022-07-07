package com.alizee.applicationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.alizee.applicationtest.UI.FirstFragment
import com.alizee.applicationtest.UI.ListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var firstFragment = ListFragment()
        supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout, firstFragment)?.commit()
    }

}