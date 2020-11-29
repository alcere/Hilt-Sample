package poc.android.hilt

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class BakeryViewModel @ViewModelInject constructor(
    private val cakeProducer: CakeProducer
) : ViewModel() {


    private val _bakeyModel = MutableLiveData<String>()
    val bakeryModel = _bakeyModel as LiveData<String>

    fun bake() {
        _bakeyModel.value = cakeProducer.bake()
    }
}
