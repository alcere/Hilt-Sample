package poc.android.hilt.dependencies

interface Appliance {
    fun getTime(): Int
}

class Oven : Appliance {
    companion object {
        const val TIME = 40
    }

    override fun getTime() = TIME
}

class Microwave : Appliance {
    companion object {
        const val TIME = 5
    }

    override fun getTime() = TIME
}
