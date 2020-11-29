package poc.android.hilt

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: BakeryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel.bakeryModel.observe(this, Observer { text -> updateBakeryText(text) })
        viewModel.bake()
    }

    private fun updateBakeryText(text: String) {
        findViewById<TextView>(R.id.bakery_text).text = text
    }
}
