package com.alizee.applicationtest.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.alizee.applicationtest.R

class FirstFragment:Fragment()  {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.first_fragment, container, false)

        var button = v.findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            var text = v.findViewById<EditText>(R.id.edit_text)
            var b = Bundle()
            b.putString("keyFragment2", text.text.toString())

            var fragment2 = SecondFragment()
            fragment2.arguments = b

            activity?.supportFragmentManager?.beginTransaction()?.replace(R.id.frame_layout, fragment2)?.commit()
        })


        return v
    }
}