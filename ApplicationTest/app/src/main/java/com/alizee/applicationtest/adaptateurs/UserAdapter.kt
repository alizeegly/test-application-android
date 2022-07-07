package com.alizee.applicationtest.adaptateurs

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.alizee.applicationtest.MainActivity
import com.alizee.applicationtest.R
import com.alizee.applicationtest.UI.MapFragment
import com.alizee.applicationtest.UI.SecondFragment
import com.alizee.applicationtest.models.User

class UserAdapter(val users:MutableList<User>, val context: Context): BaseAdapter() {

    override fun getCount(): Int {
        return users.size
    }

    override fun getItem(p0: Int): Any {
        return users.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return users.get(p0).id.toLong()
    }

    override fun getView(p0: Int, convertView: View?, p2: ViewGroup?): View? {
        var convertView: View? = convertView
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, p2, false)
        }

        var textView2 = convertView?.findViewById<TextView>(R.id.textView2)
        var textView3 = convertView?.findViewById<TextView>(R.id.textView3)
        var textView4 = convertView?.findViewById<TextView>(R.id.textView4)
        var textView5 = convertView?.findViewById<TextView>(R.id.textView5)

        var item = getItem(p0) as User
        textView2?.text = item.username
        textView3?.text = item.website
        textView4?.text = item.name
        textView5?.text = item.email

        var image = convertView?.findViewById<ImageView>(R.id.imageView)
        image?.setOnClickListener(View.OnClickListener {
            var b = Bundle()
            b.putDouble("keyLat", item.lat)
            b.putDouble("keyLng", item.lng)
            b.putString("keyUsername", item.username)

            var fragment = MapFragment()
            fragment.arguments = b

            val transaction =  ( context as MainActivity).
            supportFragmentManager.beginTransaction()
            fragment.show(transaction,"MapFragment")
        })

        return convertView
    }


}