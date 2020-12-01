package poc.android.hilt

import android.content.Context
import android.os.Build
import androidx.hilt.work.HiltWorkerFactory
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.work.ListenableWorker
import androidx.work.testing.TestListenableWorkerBuilder
import dagger.hilt.android.testing.*
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config
import poc.android.hilt.dependencies.Frosting
import poc.android.hilt.di.FrostingModule
import javax.inject.Inject

@HiltAndroidTest
@Config(sdk = [Build.VERSION_CODES.P], application = HiltTestApplication::class)
@UninstallModules(FrostingModule::class)
@RunWith(AndroidJUnit4::class)
class BakeryWorkerTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    @BindValue
    @JvmField
    val cream: Frosting = Frosting.create(Frosting.Flavour.Strawberry)

    private lateinit var context: Context

    @Before
    fun setup() {
        context = ApplicationProvider.getApplicationContext()
        hiltRule.inject()
    }

    @Test
    fun `Test_work_manager_success`() {
        val worker = TestListenableWorkerBuilder<BakeryWorker>(
            context
        ).setWorkerFactory(workerFactory).build()
        val result = worker.startWork().get()
        assertThat(
            result,
            CoreMatchers.`is`(ListenableWorker.Result.success())
        )
    }

}
