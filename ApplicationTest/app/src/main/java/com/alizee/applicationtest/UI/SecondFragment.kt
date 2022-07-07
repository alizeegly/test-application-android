package com.alizee.applicationtest.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.alizee.applicationtest.R

class SecondFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.second_fragment, container, false)
        var b = arguments
        var reception = b?.getString("keyFragment2")

        var textView = v.findViewById<TextView>(R.id.textView)
        textView.text = reception

        return v
    }
}