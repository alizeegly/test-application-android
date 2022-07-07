package com.alizee.applicationtest.UI

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.alizee.applicationtest.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapFragment: DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v = inflater.inflate(R.layout.map_fragment, container, false)

        var fragment = childFragmentManager.findFragmentById(R.id.map_fragment) as SupportMapFragment
        fragment!!.getMapAsync(OnMapReadyCallback { mMap: GoogleMap ->
            var lat = arguments?.getDouble("keyLat") as Double
            var lng = arguments?.getDouble("keyLng") as Double
            var username = arguments?.getString("keyUsername")

            if (activity != null) {
                var googleMap = mMap
                googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL)
                googleMap.getUiSettings().setMyLocationButtonEnabled(true)
                googleMap.getUiSettings().setCompassEnabled(true)
                googleMap.getUiSettings().setRotateGesturesEnabled(true)
                googleMap.getUiSettings().setZoomGesturesEnabled(true)

                // Add a marker in Sydney and move the camera
                val latlng = LatLng(lat, lng)
                googleMap.addMarker(MarkerOptions().position(latlng).title(username))
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(latlng))
            }
        })

        return v
    }
}