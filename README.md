# Sports App

A work-in-progress Sports App 
This project is a personal sandbox of sorts, experimenting with the latest libraries and tools. These include:
-100% Kotlin
-UI wwritten in Jetpack Compose
-Dependacy Injections with Hilt
-AGSL rendering
-Compose navigation For navigation in the app
-ViewModel The ui layer uses the viewmodel pattern
-ExoPlayer For playing videos
-Coroutines For handling async work
-Retrofit For networking tasks

100% Jetpack compose && MVVM Architecture for sports.
UDF & reactice programing with Kotlin Flow API
App State & ScreeUIStates

Each UI 'screen' has its own ViewModel, which exposes a single StateFlow containing the entire view state. Each ViewModel is responsible for subscribing to any data streams required for the view, as well as exposing functions which allow the UI to send events.


This pattern is used across the different screens:
The ViewModel is implemented as ScreenViewModel, which exposes a StateFlow<ScreenViewState> for the UI to observe.
ScreenViewState contains the complete view state for the screen as an @Immutable data class.
The UI uses ScreenViewModel, and observes it's ScreenViewState as Compose State, using collectAsStateWithLifecycle():
  
The Repository class is responsible for handling the data fetching of all information:

  ![Video](https://github.com/salgut408/SportsJetpackCompose/assets/61568828/f4bb542e-7959-43aa-8372-81efed686536)
![ScoreboardScreen2](https://github.com/salgut408/SportsJetpackCompose/assets/61568828/a2eba9e1-6689-4e55-aa1a-d5163cf0e1a9)
![ScoreBoard](https://github.com/salgut408/SportsJetpackCompose/assets/61568828/58d9a86f-7f8d-4c73-89b4-cd9094a78125)
![MainScreen](https://github.com/salgut408/SportsJetpackCompose/assets/61568828/e9e5b7e8-ea16-4ba3-9b11-a3693985bfae)


