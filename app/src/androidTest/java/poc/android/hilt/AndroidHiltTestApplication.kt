package poc.android.hilt

import android.app.Application
import android.util.Log
import androidx.work.Configuration
import androidx.work.impl.utils.SynchronousExecutor
import androidx.work.testing.WorkManagerTestInitHelper
import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(AndroidHiltTestApplication::class)
open class AndroidHiltTestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        val config: Configuration = Configuration.Builder()
            .setMinimumLoggingLevel(Log.DEBUG)
            .setExecutor(SynchronousExecutor())
            .build()
        WorkManagerTestInitHelper.initializeTestWorkManager(
            this, config
        )
    }
}
