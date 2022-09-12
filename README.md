# 🍔 FastFood

<img align="right" width="30%" src="demo/Demo.gif">

An Android application where you can view and examine the details of fast food divided into categories.

## 🛠 Tech Stack & Open-Source Libraries
- [Kotlin](https://kotlinlang.org/) - Google officially supports Kotlin on Android as a “first-class” language and it has a [a lot of benefits](https://developer.android.com/kotlin).
- [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) & [Flow](https://developer.android.com/kotlin/flow).
- [MVVM Architecture](https://developer.android.com/jetpack/guide) - Modern, maintainable, and Google-suggested app architecture.
- [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - A single-activity architecture, using the [Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started) to manage fragment operations.
  - [ViewBinding](https://developer.android.com/topic/libraries/view-binding) - Generates a binding class for each XML layout file present in that module and allows you to write code more easily that interacts with views.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - Perform an action when lifecycle state changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Repository](https://developer.android.com/topic/architecture/data-layer) - Located in the data layer that contains application data and business logic.
- Dependency Injection
  - [Hilt](https://developer.android.com/training/dependency-injection/hilt-android) - Easy implementation and less boilerplate code than Dagger2.
- Networking
  - [Retrofit](https://square.github.io/retrofit/) - A type-safe HTTP client for Android and Java.
  - [OkHttp](https://square.github.io/okhttp/) - An HTTP client that efficiently make network requests.
- Design
  - [Material Design 3](https://m3.material.io/) - Material Design is an adaptable system of guidelines, components, and tools that support the best practices of user interface design. Backed by open-source code, Material Design streamlines collaboration between designers and developers and helps teams quickly build beautiful products.
  - [Shimmer for Android](https://facebook.github.io/shimmer-android/) - An Android library that provides an easy way to add a shimmer effect to any view in an Android app

## Package Structure

```
fastfood/          # Root package
├─ data/           # Data layer
│  ├─ remote/      # Api service
│  ├─ model/       # Data transfer objects for remote response
│  ├─ mapper/      # Mapper for remote responses
│  ├─ repository/  # Repository implementations
├─ di/             # Dependency injection module
├─ domain/         # Domain layer
│  ├─ model/       # UI model
│  ├─ repository/  # Repository interface
│  ├─ util/        # Domain mapper
├─ ui/             # Presentation layer
│  ├─ detail/      # Product details
│  │  ├─ model/    # Product UI state
│  ├─ home/        # Main screen (Products, categories)
│  │  ├─ model/    # UI state for products & categories
├─ util/           # Utility classes
│  ├─ extension/   # Kotlin extensions
```

## License

```
MIT License

Copyright (c) 2022 Muhammed Esad Cömert

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```
