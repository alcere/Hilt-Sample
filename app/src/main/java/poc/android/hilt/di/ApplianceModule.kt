package poc.android.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import poc.android.hilt.dependencies.Appliance
import poc.android.hilt.dependencies.Oven

@Module
@InstallIn(ActivityComponent::class)
object ApplianceModule {

    @Provides
    @ActivityScoped
    fun provideAppliance(): Appliance = Oven()

}
