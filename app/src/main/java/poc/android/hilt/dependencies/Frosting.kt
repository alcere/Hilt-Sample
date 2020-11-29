package poc.android.hilt.dependencies

import android.content.Context
import dagger.hilt.EntryPoint
import dagger.hilt.EntryPoints
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

class Frosting private constructor(private val flavour: Flavour) {

    @EntryPoint
    @InstallIn(ActivityComponent::class)
    interface FrostingInterface {
        fun getMixer(): Mixer
    }

    enum class Flavour {
        Vanilla, Chocolate, Strawberry
    }

    companion object {
        const val TEXT = "Frosting %s frosting, using mixer speed: %s"
        fun create(flavour: Flavour): Frosting {
            return Frosting(flavour)
        }
    }

    fun whip(context: Context): String {
        val creamInterface = EntryPoints.get(context, FrostingInterface::class.java)
        val mixer = creamInterface.getMixer()
        return TEXT.format(flavour, mixer.getSpeed())
    }
}
