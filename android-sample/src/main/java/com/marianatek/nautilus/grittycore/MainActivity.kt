package com.marianatek.nautilus.grittycore

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.lifecycleScope
import com.marianatek.marianakit.Mariana
import com.marianatek.marianakit.apiclient.ResultType
import com.marianatek.marianakit.models.Location
import com.marianatek.marianakit.platformName
import com.seannajera.dkouple.Component
import com.seannajera.dkouple.ComponentAdapter
import com.seannajera.dkouple.ComponentFactory
import com.seannajera.dkouple.ComponentView
import com.seannajera.dkouple.DKoupleComponent
import kotlinx.android.synthetic.main.activity_main.locationsList
import kotlinx.android.synthetic.main.activity_main.textView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    private val mariana = Mariana()
    private val componentAdapter = ComponentAdapter(NautilusComponentFactory())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        locationsList.adapter = componentAdapter
    }

    @SuppressLint("SetTextI18n")
    override fun onResume() {
        super.onResume()

        textView.text = "Kotlin Rocks on ${platformName()}, D'UH"

        mariana.getLocations().get {
            lifecycleScope.launch(Dispatchers.Main) {
                when (it) {
                    is ResultType.Success -> {
                        componentAdapter.applyComponents(it.data
                            .map { location ->
                                LocationComponent(location).apply {
                                    action = {
                                        supportFragmentManager
                                            .beginTransaction()
                                            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                            .replace(R.id.fragmentContainer, LocationDetailFragment(it))
                                            .addToBackStack(null)
                                            .commit()
                                    }
                                }
                            }
                        )
                    }
                    is ResultType.Failure -> {// We don't make errors
                    }
                }
            }
        }
    }
}

@DKoupleComponent(R.layout.component_location)
data class LocationComponent(val location: Location) : Component {
    override val id = location.id

    var action: ((Location) -> Unit)? = null

    override fun contentSameAs(otherComponent: Any): Boolean {
        return (otherComponent as? LocationComponent)?.location == this.location
    }
}

class LocationView(view: View) : ComponentView<LocationComponent>(view) {

    private val locationName: TextView by lazy { view.findViewById<TextView>(R.id.location_component) }
    override fun onViewUpdate(previous: LocationComponent?, current: LocationComponent) {
        locationName.text = current.location.name
        locationName.setOnClickListener {
            current.action?.invoke(current.location)
        }
    }
}

class NautilusComponentFactory : ComponentFactory {
    override fun createView(layoutId: Int, view: View): ComponentView<out Component> {
        return when (layoutId) {
            R.layout.component_location -> LocationView(view)
            else -> throw IllegalStateException()
        }
    }
}
