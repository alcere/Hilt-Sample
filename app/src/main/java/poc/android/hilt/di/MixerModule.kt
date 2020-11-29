package poc.android.hilt.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import poc.android.hilt.dependencies.Mixer
import poc.android.hilt.dependencies.SlowMixer

@Module
@InstallIn(ActivityComponent::class)
abstract class MixerModule {

    @Binds
    @ActivityScoped
    abstract fun provideMixer(mixer: SlowMixer): Mixer
}
