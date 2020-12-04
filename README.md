# Hilt-Sample
Hilt is the latest attempt from Google to standardize Dagger usage for dependency injection in Android, and it feels like a complete success.

Generally speaking, having some Dagger knowledge would make it easier understanding how to use Hilt, and more importantly, how it works, but it is not a requirement at all.

This repository shows how to configure Hilt in an Android project from zero.
# Repository structure
The code is structured in the following way:
- **root**: Android classes to serve as the consumer of dependencies: Activity, ViewModel, and WorkManager.
- **dependencies**: the set of classes that will provide basic functionality defined by an abstraction. We can also find some concrete implementations adding a particular behavior; we would use this to modify the abstraction's behavior according to the scenario: test or 'production.' These classes work as a dependency and as a consumer of dependencies.
- **di**: the set of modules or classes that defines the dependencies that Hilt provides and how to create them.

The repo also includes some basic instrumented test to go through this scenario and how Hilt provides dependencies using Espresso:
- **modules**: the set of modules or classes that define dependencies provided by Hilt for testing.
- **test**: contains two basic samples showcasing a WorkManager test and an Espresso test.

# Resources
- 📖. [A pragmatic guide to Hilt with Kotlin](https://medium.com/androiddevelopers/a-pragmatic-guide-to-hilt-with-kotlin-a76859c324a1)
- 📖. [Official Android documentation](https://developer.android.com/training/dependency-injection/hilt-android)
- 📼. [Hilt Dependecy Injection](https://www.youtube.com/watch?v=B56oV3IHMxg)
