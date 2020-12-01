package poc.android.hilt

import android.content.Context
import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.work.WorkerInject
import androidx.work.*
import poc.android.hilt.dependencies.Frosting
import java.util.concurrent.TimeUnit

class BakeryWorkManager @WorkerInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val creamProducer: Frosting
) : CoroutineWorker(appContext, workerParams) {

    companion object {
        private const val TAG = "BakeryWorkManager"

        private val constraints = Constraints.Builder()
            .setRequiresBatteryNotLow(true)
            .build()

        fun enqueueUpdate(context: Context) {
            WorkManager.getInstance(context).enqueueUniqueWork(
                TAG,
                ExistingWorkPolicy.REPLACE,
                createRequest()
            )
        }

        private fun createRequest(): OneTimeWorkRequest {
            return OneTimeWorkRequestBuilder<BakeryWorkManager>()
                .setConstraints(constraints)
                .setBackoffCriteria(
                    BackoffPolicy.EXPONENTIAL,
                    OneTimeWorkRequest.MIN_BACKOFF_MILLIS,
                    TimeUnit.MILLISECONDS
                )
                .build()
        }
    }

    override suspend fun doWork(): Result {
        Log.i(TAG, "Cake: Preparing filling: ${creamProducer.flavour}")
        return Result.success()
    }

}
