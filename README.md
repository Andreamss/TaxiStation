# Taxi Station Simulator
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FAndreamss%2FTaxiStation.svg?type=shield)](https://app.fossa.com/projects/git%2Bgithub.com%2FAndreamss%2FTaxiStation?ref=badge_shield)


This is study project for course "JAVA Programming Languages" @ Afeka College of Engineering.

Project simulates lifecycle of taxi station. 
There is station that has taxi cabs and passengers.
Each taxi can be in one of the next 3 states: waiting for passengers, on break or driving to the distination.
Passengers can wait in queue for available taxi cab or drive to destination.
At the end of the trip taxi creates reciept and store it in the db.

## Implementation Highlights

* Java 1.7 compatible
* Maven dependency manager
* 4 different implmentations: Swing GUI, Socket Client-Server, Web Application, [Android Client][1]
* Derby db
* Glassfish web server for web application and authentification
* Socket Server and Clinet (Communication using JSON format)
* Spring Framework
* JPA or JDBC to communicate with db (Can be switched in spring.xml)
* JAXB for loading and saving of configuration
* Spring AOP used for logging
* Multi-threading: Station, taxis and passengers are running in separate threads 

## Authors

Alex Gavrishev, Eran Zimbler 2012

 [1]: https://github.com/anod/TaxiStationAndroid


## License
[![FOSSA Status](https://app.fossa.com/api/projects/git%2Bgithub.com%2FAndreamss%2FTaxiStation.svg?type=large)](https://app.fossa.com/projects/git%2Bgithub.com%2FAndreamss%2FTaxiStation?ref=badge_large)