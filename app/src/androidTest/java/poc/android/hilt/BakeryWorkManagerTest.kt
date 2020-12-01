package poc.android.hilt

import android.content.Context
import androidx.hilt.work.HiltWorkerFactory
import androidx.test.core.app.ApplicationProvider
import androidx.work.ListenableWorker
import androidx.work.testing.TestListenableWorkerBuilder
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import poc.android.hilt.dependencies.Frosting
import poc.android.hilt.di.FrostingModule
import poc.android.hilt.di.MixerModule
import javax.inject.Inject

@HiltAndroidTest
@UninstallModules(FrostingModule::class, MixerModule::class)
class BakeryWorkManagerTest {

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
        val worker = TestListenableWorkerBuilder<BakeryWorkManager>(
            context
        ).setWorkerFactory(workerFactory).build()
        val result = worker.startWork().get()
        assertThat(
            result,
            CoreMatchers.`is`(ListenableWorker.Result.success())
        )
    }

}
