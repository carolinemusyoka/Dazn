# Dazn

An app using Compose and Hilt on MAD stacks and architecture to consume Dazn api to display a list of events and a playback screen, playing a video. 

## Install

You can build the project with Android Studio or [download the apk directly](https://github.com/carolinemusyoka/Dazn/blob/master/app/releases/app-debug.apk) from releases.

## Screenshots

## Built with

- 100% [Kotlin](https://kotlinlang.org/) based + [Coroutines](https://github.com/Kotlin/kotlinx.coroutines) + [Flow](https://kotlin.github.io/kotlinx.coroutines/kotlinx-coroutines-core/kotlinx.coroutines.flow/) for asynchronous.
- Hilt for dependency injection.
- JetPack
  - Compose - A modern toolkit for building native Android UI.
  - Lifecycle - dispose observing data when lifecycle state changes.
  - ViewModel - UI related data holder, lifecycle aware.
  - Navigation - Navigation support for compose applications. Navigate between composables while taking advantage of the components' infrastructure and features. 
- Architecture
  - MVVM Architecture (Declarative View - ViewModel - Model)
  - Repository pattern
- Material Design & Animations
- [Accompanist](https://github.com/google/accompanist) - A collection of extension libraries for Jetpack Compose.
- [Retrofit2 & OkHttp3](https://github.com/square/retrofit) - construct the REST APIs and paging network data.
- [ExoPlayer](https://exoplayer.dev/) - Application level media player for Android. 
- [Coil](https://coil-kt.github.io/coil/) - Image loading library backed by kotlin coroutines.
