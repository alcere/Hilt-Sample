package poc.android.hilt.modules

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped
import poc.android.hilt.dependencies.Mixer
import poc.android.hilt.dependencies.QuickMixer

@Module
@InstallIn(ActivityComponent::class)
abstract class TestMixerModule {

    @Binds
    @ActivityScoped
    abstract fun provideMixer(mixer: QuickMixer): Mixer
}
