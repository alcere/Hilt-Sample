package poc.android.hilt.dependencies

import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CakeProducer @Inject constructor(
    private val appliance: Appliance,
    private val mixer: Mixer
) {

    companion object {
        const val TEXT = "Cake: I'm mixing the ingredients %s, " +
                "then I will bake the cake for: %s"
    }

    fun bake(): String = TEXT.format(mixer.getSpeed(), appliance.getTime())
}
