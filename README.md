# Dazn

An app using Compose and Hilt on MAD stacks and architecture to consume Dazn api to display a list of events and a playback screen, playing a video. 

## Install

You can build the project with Android Studio or [download the apk directly](https://github.com/carolinemusyoka/Dazn/blob/master/app/releases/app-debug.apk) from releases.

## Screenshots and recordings

<img src="https://user-images.githubusercontent.com/44951692/183297595-d0a5e77c-21c6-48ea-ab7b-6c08bda421a2.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/183297600-56e0997b-a3d9-4496-862d-c462495b676b.jpg" width=30% height=30%> <img src="https://user-images.githubusercontent.com/44951692/183297605-87374485-e117-41d0-bde4-f23696275097.jpg" width=30% height=30%>  <img src="https://user-images.githubusercontent.com/44951692/183297591-b7f7eca4-838e-4584-aea2-24ebd260ef26.jpg" width=30% height=30%>



https://user-images.githubusercontent.com/44951692/183297815-6d355ed2-43dd-44f8-b9c1-52b66a622687.mp4




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

