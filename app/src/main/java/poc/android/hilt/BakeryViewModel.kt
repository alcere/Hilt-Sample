package poc.android.hilt

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import poc.android.hilt.dependencies.Frosting

class BakeryViewModel @ViewModelInject constructor(
    private val cakeProducer: CakeProducer,
    private val frosting: Frosting
) : ViewModel() {

    private val _bakeryModel = MutableLiveData<String>()
    val bakeryModel = _bakeryModel as LiveData<String>

    private val _frostingModel = MutableLiveData<String>()
    val frostingModel = _frostingModel as LiveData<String>

    fun bake() {
        _bakeryModel.value = cakeProducer.bake()
    }

    fun frost(context: Context) {
        _frostingModel.value = frosting.whip(context)
    }
}
