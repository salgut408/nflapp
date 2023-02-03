# Sports App
100% Jetpack compose && MVVM Architecture for sports.
UDF & reactice programing with Kotlin Flow API
App State & ScreeUIStates

The app is built in a Redux-style, where each UI 'screen' has its own ViewModel, which exposes a single StateFlow containing the entire view state. Each ViewModel is responsible for subscribing to any data streams required for the view, as well as exposing functions which allow the UI to send events.


This pattern is used across the different screens:
The ViewModel is implemented as ScreenViewModel, which exposes a StateFlow<ScreenViewState> for the UI to observe.
ScreenViewState contains the complete view state for the screen as an @Immutable data class.
The UI uses ScreenViewModel, and observes it's ScreenViewState as Compose State, using collectAsStateWithLifecycle():
