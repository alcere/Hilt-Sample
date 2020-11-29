package poc.android.hilt.dependencies

import javax.inject.Inject

interface Mixer {
    fun getSpeed(): String
}

class QuickMixer @Inject constructor() : Mixer {
    companion object {
        const val SPEED = "fast"
    }

    override fun getSpeed(): String = SPEED
}

class SlowMixer @Inject constructor() : Mixer {
    companion object {
        const val SPEED = "slow"
    }

    override fun getSpeed(): String = SPEED
}
