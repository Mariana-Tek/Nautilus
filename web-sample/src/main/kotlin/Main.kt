import react.dom.*
import kotlin.browser.document
import com.marianatek.marianakit.platformName

fun main() {
    render(document.getElementById("root")) {
        h1 {
            +"Kotlin Rocks on ${platformName()}"
        }
    }
}