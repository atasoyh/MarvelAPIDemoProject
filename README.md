###3rd Party Libraries:

##REST Service Libraries
        : "com.squareup.retrofit2:adapter-rxjava2:2.2.0"
Retrofit is one of Rest Services Libraries. It's easy to use with it's Annotation Support.

##logging-interceptor
        : 'com.squareup.okhttp3:logging-interceptor:3.6.0'
HttpLoggingInterceptor is for logging network on OKHTTP.

##GSON
        : 'com.google.code.gson:gson:2.8.0'
Gson is a Java library that can be used to convert Java Objects into their JSON representation.
It can also be used to convert a JSON string to an equivalent Java object.

##GSON Converter
        : "com.squareup.retrofit2:converter-gson:2.2.0"
By default, Retrofit can only deserialize HTTP bodies into OkHttp's ResponseBody type and it can only accept its RequestBody type for Body Annotation.
Converter is added to support other types.

##RXJava2
        : 'io.reactivex.rxjava2:rxjava:2.0.8'
        : 'io.reactivex.rxjava2:rxandroid:2.0.1'
Reactive Programming and it's libraries are for composing asynchronous and event-based programs by using observable sequence

##Dagger2
        : "com.google.dagger:dagger:2.9"
        : "com.google.dagger:dagger-compiler:2.9"
        : 'javax.annotation:jsr250-api:1.0'
Dagger is a fully static, compile-time dependency injection framework for both Java and Android.

##Fresco
        : "com.facebook.fresco:fresco:1.3.0"
Fresco is one of Facebook's Libraries for ImageLoading.


##Butterknife
        : 'com.jakewharton:butterknife:8.6.0'
        : 'com.jakewharton:butterknife-compiler:8.6.0'
This is a good library for binding views. It saves time, it makes you write less and more readable code..:)


### App Architecture

I designed this project with MVP approach.

#MODEL 
Our model objects are in there. They were created from MarvelApi Documentation.

#PRESENTER
The presenter is responsible to act as the middle layer between view and model. It retrieves data from the model and returns it formatted to the view.
There are subpackages for each part of responsibility. It is more readable and editable. (base, comics, comicdetail....)
I generally create BasePresenter and BaseView(interface), but it depends on project's design. It helps me about like showing progressbar, errors, or handling general errors,...

#VIEW 
The view, usually implemented by an Activity (it may be a Fragment, a View… depending on how the app is structured), will contain a reference to the presenter.
This layer controls UI interactions.(showing a text, handling a click)... There should be no usecase there.. It's only for UI.
There are subpackages for each part of responsibility. (base, comics, comicdetail....) Generally, View and Presenter layers look similar hyerarch.
I generally create BaseActivity, BaseFragment,... for handling BaseView's Interaction. it helps me about like showing progressbar, errors, or handling general errors,...

##INTERACTOR 
It manages data traffic. You can think it is middle of presenter and datasource.

##DI
I create modules classes in di package. (submodules are in presenter package for easy to read.)








