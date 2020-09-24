# LPOO T7-G712 - Snake

### About the game
Snake is the common game where the player controls a line which grows in length when the snake eats, with the line itself being an obstacle.

This project was developed by Tiago Pinto (up201808907@fe.up.pt).

### Implemented Features
	* Moving Snake - To move the snake just use the following keys:
		- Arrow Up;
		- Arrow Down;
		- Arrow Right;
		- Arrow Left;

	* PowerUps - There are two types:
		- FastPowerUp - Increased speed;
		- SlowPowerUp - Decreased speed;

### Not Implemented Features
Due to the lack of time, it was not possible to implement the following features:

	* 3 Levels - Easy, Medium and Hard;
	* Best Score;
	* Actual Score;

### Design
#### 1. Power-Up
##### The problem
Power-ups need to change the speed state of the snake. It would be necessary to implement a control for this.

##### The Solution
To solve this problem, the State Pattern was implemented.

##### Implementation
An interface called "Power-Up" was created that will be implemented by other classes for all types of elements that need to be changed. When the snake collides with a Power-Up, the effect happens for a limited time.

##### Consequences
As a consequence, it is necessary to verify that no SOLID principles are violated, such as the Single Responsibility Principle and Open / Close Principle.

#### 2. Commands
##### The problem
I want to make the snake move but it is necessary to have a method for this without having to constantly check the input.

##### The Solution
As a solution, the Command Pattern was used. Thus, this pattern is responsible for changing the snake's position.

##### Implementation
An abstract class called Command was created and declared as an interface. Thus, when the class is created, for example, MoveUpCommand will extend the Command.

##### Consequences
It is necessary to verify that the SRP and OCP are not violated.

#### 3. Elements
##### The Problem
The only problem that was found was perhaps the fact that whenever it was necessary to create an element, for example, "Power-Ups", "Cell", "Wall", etc... I would be obliged to make further changes to the code.

##### The Solution
The solution was to implement the interface 'Element'. In this way, it is possible to add new elements but which always depend on an 'Element' interface. This interface has a method 'draw' and 'getPosition'.

##### Implementation
Therefore, now we only have Elements and they are easier to manage.

##### Consequences
In this way, I can have several types of elements as long as I implement an "Element" class.

#### 4. MVC Architecture
##### The Problem
It was necessary to find a way to separate the controllers, the models and what is presented to the user.

##### The Solution
The solution was to implement the MVC architecture.
This is divided into 3 parts:
	- Model: stores data and program logic;
	- View: this part of the program is the presentation to the user;
	- Controller: this is what handles the keyboard inputs and makes the model interact with the view;

##### Implementation
The classes were separated according to what each one represents, being made the division with the architecture principles.

##### Consequences
With these changes, in addition to the code becoming more organized, the code becomes simpler to increase and manage.

### Known Code Smells and Refactoring Suggestions
I didn't spend much time looking for code smells.
The only one I found I solved using Polymorphism with the interface 'Element'.

### Testing
#### Coverage Report

![Coverage Report](https://github.com/FEUP-LPOO/lpoo-2020-g712/blob/master/docs/Final/Coverage_Test_Final.png?raw=true)

#### PIT Report

![PIT Report](https://github.com/FEUP-LPOO/lpoo-2020-g712/blob/master/docs/Final/Pitest_Final.png?raw=true)


### Final game

![GIF](https://github.com/FEUP-LPOO/lpoo-2020-g712/blob/master/docs/Final/snake.gif?raw=true)
