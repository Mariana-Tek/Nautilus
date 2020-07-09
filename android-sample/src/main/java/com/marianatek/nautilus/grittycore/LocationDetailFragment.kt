package com.marianatek.nautilus.grittycore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.marianatek.marianakit.models.Location
import kotlinx.android.synthetic.main.fragment_detail_location.labelAddress
import kotlinx.android.synthetic.main.fragment_detail_location.labelLocationName
import kotlinx.android.synthetic.main.fragment_detail_location.labelPhoneNumber
import kotlinx.android.synthetic.main.fragment_detail_location.labelRegionName

class LocationDetailFragment(private val location: Location) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_detail_location, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        labelLocationName.text = "Name: ${location.name ?: "N/A"}"
        labelAddress.text = "Address: ${location.addressLine1 ?: "N/A"}"
        labelPhoneNumber.text = "Phone Number: ${location.phoneNumber ?: "N/A"}"
        labelRegionName.text = "Region: ${location.regionResponse?.name ?: "N/A"}"
    }
}