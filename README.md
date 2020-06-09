# Exploration Result

## MVP Design Pattern
MVP Design Pattern basically will divide the responsibility for certain activity into three parts, namely : 

1. Model 
The Model is the part that is responsible for providing data and handling the business logic of an activity.

2. View
The one that interacts directly with user is this part. When user interacts with View Component, let's say click a button, View Component must notify Presenter Component. When the Presenter Component notifies back, View Component will do or display data that command/data.

3. Presenter
Presenter Component functions more as a link between Model Component and View Component. When View Component notifies Presenter Component,it will decide which data to take from The Model and give back to the View Component.

These three components have their own responsibilities for the flow of an activity. It will make the development and maintenance of application a lot more easier.

## MVVM Design Pattern
In Principle, MVVM and MVP want to achieve the same goal. The goal is to dividing responsibility for an activity in order to make development and maintenance of the application a lot more easier. In MVVM, the division is as follows :

1. Model
Model is a data class, database, API, and also a Repository. The part that serves to provide data that can be retrieved and then stored in the view model.

2. View
View is a UI component that functions to display data in ViewModel. If the data in the View Model changes, the data displayed in the UI component will also change

3. View Model
Contains data needed in View. In its implementation, View Model uses Live Data. an observable class that makes the data in the View Model can withstand configuration changes such as screen rotation

The biggest difference between MVVM and MVP is the relationship between View-Presenter and View-View Model. In View-Presenter, Presenter Component has the responsibilities to sending data back to View Component in order to make a change. While in View-View Model, View Model only provides the data. And View Component will always observe the data in View Model. 

## Repository Pattern
Pattern repositories are like extensions of the Model section in MVP or MVVM Design Pattern. As we know, Android can take data from two different source, External data (eg. API Call) and Internal data (eg. Database). The Pattern Repository tries to simplify this by creating a repository class. A separate class whose contents are only commands to retrieve or add data. The Repository class does not need to know that the data comes from External or Internal sources.

## Room Database Android
Room provides an abstraction layer over SQLite to allow fluent database access without decreasing the power of SQLite itself. There are 3 major components in Room :

1. Database 
Contains the database holder. In Repository Pattern, database class has responsibility to hold DAO and building Room Instance.

2. Entity
Represents a table within the database

3. DAO 
Contains the methods used for accessing the database

## Reactive Programming
Reactive Programming does not need to re-execute some code when we change the data. The result will be updated automatically. It is possible because we always observing the data.

*RxJava :*
Reactive Extensions for the JVM. a library for composing asynchronous and event-based programs using observable sequence for the Java VM. 

*RxKotlin :*
Simply is a RxJava Wrapper for Kotlin Programming Language. When it comes to code Android Apps in Reactive Programming, we need to use RxJava for java Project. On the other hand, we could use both RxJava and RxKotlin in Kotlin Project.

*RxAndroid :*
Offers schedulers to manage the thread. Mostly, schedulers.io() and AndroidSchedulers. mainThread() is used in android programming.

*Terms : *
1. Observable
Observable is a data stream that been observed by observer and would emit data to observer. Observable can emit multiple items. So the lifecycle of observable after being subscribed is doing onNext until it reach onComplete or onError. There are many type of observable based on the data that being emitted, those are :

    - Single : Single is an observable which only emits one item or throws an error. The lifecycle of Single is pretty straightforward. After being subscribed, It goes to either onSuccess or onError.

    - Maybe : Just like single, but it allows for no emission at all. In order to achieve zero emission, onComplete was added to the Maybe's lifecycle.

    - Completable : Only concerned with execution of completion. Whether the task has reach to completion or some error has occured. 

2. Observer
Observer will receive the data emitted by observables

3. Subscribe
The things that link between observable and observer. There can be multiple observer subscribed to a single observable

4. Operators
Operators modify data which is emitted by observable. The Observer will get the data that has changed.

5. Schedulers
Schedulers determine which thread should observable emit the data and on which observer should receive the data

## Live Data
Live Data is an observable data holder class. Live Data is different among the other observable because it is aware of the activity lifecycle (Lifecycle Aware). It means that the component will only be updated on Active Lifecycle state.

Live Data considers an observer, represented by observer class. Live Data will notifies the active observer about the updates of data. Active Observer is an observer which its lifecycle is in STARTED or RESUMED. Inactive observer arent notified about the updates.

*The Advantage : *
1. Up to date Data 
Live Data will notifies if there are any updates on data. Which mean that the UI will always have the up to date data

2. No Memory Leak
Observere are bound to lifecycle objects and clean up themselves when their associated lifecycle is destroyed.

3. No crashes due to stopped activities
if the observers are inactive, it wont received any Live Data event.

4. Sharing Resources
any activity/observers that need the resource can just watch the LiveData Object

*Observe Live Data Objects*

To ensure the system doesn't make redundat calls from an activity onResume() methods, we need to call Live Data Object in onCreate() methods. We can observe the Live Data object using observe() methods. when it is called, the onChanged() method is immediately invoked providing the most recent value to show in the UI. if the Live Data object hasn't set a value in UI, onChanged() is not called.

*Transform Live Data : *

It works like operators in RxKotlin. We can transform our Live Data to match our needs in UI. The lifecycle package provides the transformations class which includes helper methods that support these scenarios.

    1. Transformations.map ()
    Applies a function on the value stored in the LiveData object and propagates the result downstream.

    2. Transformations.switchMap()
    Similar to map(). The difference is that the function passed to switchMap() must return a LiveData object.