# Ride Booking System (Java OOP)

## Overview

This project is a simple ride booking system implemented in Java. It demonstrates core Object-Oriented Programming concepts including inheritance, polymorphism, constructors, and the use of ArrayList. The system simulates how riders are matched with available drivers and how rides are managed.

## Features

* Create and manage drivers and riders
* Request rides and assign available drivers
* Track ride status
* Display all drivers and rides

## OOP Concepts Used

* Inheritance: Rider and Driver extend the User class
* Polymorphism: Method overriding in displayInfo()
* Encapsulation: Private fields with controlled access
* Constructors: Used to initialize objects
* Collections: ArrayList to store drivers and rides

## How to Run

1. Save the file as Main.java
2. Open a terminal in the project directory
3. Compile the program:
   javac Main.java
4. Run the program:
   java Main

## Structure

* User: Base class
* Rider: Inherits from User
* Driver: Inherits from User
* Ride: Represents a ride instance
* RideService: Manages drivers and ride requests
* Main: Entry point of the program

## Notes

This is a basic simulation and does not include user input or advanced features like pricing or location tracking.
