package poc.android.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import poc.android.hilt.dependencies.Frosting

@Module
@InstallIn(ApplicationComponent::class)
object FrostingModule {

    @Provides
    fun provideFlavour(): Frosting.Flavour = Frosting.Flavour.Chocolate

    @Provides
    fun provideCream(flavour: Frosting.Flavour): Frosting = Frosting.create(flavour)
}
