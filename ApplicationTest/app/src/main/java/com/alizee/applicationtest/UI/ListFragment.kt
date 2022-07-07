package com.alizee.applicationtest.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.alizee.applicationtest.API.ApiClient
import com.alizee.applicationtest.R
import com.alizee.applicationtest.adaptateurs.UserAdapter
import com.alizee.applicationtest.models.User
import com.alizee.applicationtest.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class ListFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.list_fragment, container, false)

        getListOfUsers(v)

        return v
    }

    fun getListOfUsers(v: View){
        var repository = UserRepository(requireActivity())
        var all_users = repository.getAllUsers()

        if (all_users.isNotEmpty()){
            var listView = v.findViewById<ListView>(R.id.list_view)
            var adapter = UserAdapter(all_users as MutableList<User>, requireActivity())
            listView.adapter = adapter
            Toast.makeText(activity, "Data found from db", Toast.LENGTH_LONG).show()
        } else {
            GlobalScope.launch(Dispatchers.Main) { // lancement de la coroutine
                var apiClient = ApiClient()
                val response = apiClient.apiService.getUsers()

                if (response.isSuccessful && response.body() != null) {
                    var content = response.body() // list des users
                    var list = content as MutableList<User>

                    var listView = v.findViewById<ListView>(R.id.list_view)
                    var adapter = UserAdapter(list, requireActivity())
                    listView.adapter = adapter

                    repository.insertAllUserS(list)
                    Toast.makeText(activity, "Data found from api", Toast.LENGTH_LONG).show()
                }
            }
        }
    }


}