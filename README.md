# Addition:
1.	A start screen to enable player to start the game or look the basic instruction of the game.
2.	An info screen which describes how to operate the game and some rules.
3.	A difficulty screen to let the user select the difficulties (easy, medium and difficult). The movement speed and sprites in the game will different from the level that being selected. (snacks and crocodiles have been added into the game to extends playability)
4.	A game over window to let user input their player name.
5.	A high score screen to display the score stored in a permanent score list and current player's score. 
6.	Each round score and previous round score will display in game scene.
7.	The player only has three lives in each level (totally 5 levels), and limit time (count down displayed on the game screen), when one of them comes to zero, the game loses.
8.	All screens are designed with basic CSS.
# Maintenance:
# Fixed Bugs:
1.	When user continuously press the keyboard, the frog may only move half step, and the points will only add 10.
2.	When the score in 3digits change to 2digits, the redundant digits won't disappear.
3.	When the frog reaches the end that is activated, the score will be continuously added.
4.	When the frog in the left/right hand side of the start, when try to move down, the frog will initialize to the start point.
# Code refactor:
1.	Apply MVC design pattern: The main game GUI is in the MVC design pattern, which model and views are always stay in sync. This design pattern ensures the application can be easier updated and debugged, as the functions are clearly separated.
2.	Apply SOLID principle:  E.g. Move the codes for setting up the game scene in the "Main" into "GameWorld". Create five classes to generate the lists of actors needed in the game to provide a maintainable way for other developers to modify the elements in the game. [alt text](/resource/RefactorPic/Classes.png)Separate the methods related to animal death checking into "DeathChecking" class. This ensures the code is easier to be followed and implemented. "BasicGUI" interface has been used to generate the game scene, and is extended by "BasicWindowGUI" interface, which is used to generate another window scene. By using them, changes and usage of objects become cheap in matter of time and risks. 
3.	Apply design pattern: Factory pattern: "ActorFactory", which removes instantiation of actual implementation classes from client. Singleton pattern: "ActorFactory", ensures it can only be instantiated once.
4.	Extract long methods (e.g. methods in "Animal" to make it more understandable and easier to change).[alt text](/resource/RefactorPic/ExtractMethod.png)
5.	Rename the variable and method in all class to self-document (include class name).[alt text](/resource/RefactorPic/Rename.png)
6.	Change some public variables to private and retain it encapsulation.
7.	Delete the lazy classes (e.g. called "MyStage" and merge it with the game world).
8.	For large classes like "Animal", separate into "Frogger" and "FroggerImage" and extract the codes related to keyboard event to "GameController".

