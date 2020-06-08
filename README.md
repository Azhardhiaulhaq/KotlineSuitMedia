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
