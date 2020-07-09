import com.marianatek.marianakit.Mariana
import com.marianatek.marianakit.apiclient.ResultType
import com.marianatek.marianakit.models.Location
import com.marianatek.marianakit.platformName
import react.*
import react.dom.*
import kotlin.browser.document

fun main() {
    render(document.getElementById("root")) {
        child(App::class) {}
    }
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        locations = listOf<Location>()

        Mariana().getLocations().get {
            when (it) {
                is ResultType.Success -> {
                    setState {
                        locations = it.data
                    }
                }
                is ResultType.Failure -> {} // Later Alligator
            }
        }
    }

    override fun RBuilder.render() {
        h1 {
            +"Kotlin Rocks on ${platformName()}"
        }
        child(LocationList::class) {
            attrs.locations = state.locations
        }
    }
}

class LocationList: RComponent<LocationListProps, RState>() {
    override fun RBuilder.render() {
        for (location in props.locations) {
            h3 {
                val locationName = location.name ?: "Location-${location.id}"
                +locationName
            }
            p {
                +"Address: ${location.addressLine1 ?: "N/A"}"
            }
            p {
                +"Region: ${location.regionResponse?.name ?: "N/A"}"
            }
            p {
                +"Phone Number: ${location.phoneNumber ?: "N/A"}"
            }
        }
    }
}

external interface LocationListProps: RProps {
    var locations: List<Location>
}

external interface AppState : RState {
    var locations: List<Location>
}