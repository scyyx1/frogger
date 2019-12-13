# Tested On:
Lab Machine/Mac Java 10 + JavaFX10 Eclipse
# Build Script:
Maven
# Trello
![alt text](/resource/RefactorPic/trello1.png)
![alt text](/resource/RefactorPic/trello2.png)
![alt text](/resource/RefactorPic/trello3.png)
# Brief View
![alt text](/resource/RefactorPic/windows.JPG)
# Main Game
![alt text](/resource/RefactorPic/MainGame.png)
# Addition:
1.	A start screen to enable player to start the game or look the instruction of the game.
2.	An info screen to describe the game operation and rules.
3.	A difficulty window to select the difficulties (easy, medium and difficult). The movement speed and sprites in the game will different from each level. (snacks and crocodiles have been added to extends playability)
4.	A game over window input player's name.
5.	A high score screen to display the score stored in a permanent score list and current player's score. 
6.	Each round score and previous round score will display in game scene.
7.	Three lives in each level (totally 5 levels), and limit time (count down displayed on the game screen), when one of them comes to zero, the game loses.

# Maintenance:
# Fixed Bugs:
1.	When user continuously press the keyboard, the frog may only move half step, and the points may only add 10.
2.	When the score in 3digits changes into 2digits, the redundant digits won't disappear.
3.	When the frog reaches the activated end, the score will continuously add.
4.	When the frog in the left/right hand side of the start line, when try to move down, the frog will initialize at the start point.

# Code refactor:
1.	Apply MVC design pattern:  
The main game GUI is in the MVC design pattern, which ensures the application can be easier updated and debugged, as the functions are clearly separated.
2.	Apply design pattern:  
Factory pattern: "ActorFactory", which removes instantiation of actual actor classes from client.  
Singleton pattern: "ActorFactory", as it is easier to control its instance and its implementation.
3.	Apply SOLID principle:  
Move the codes that set up the game scene in the "Main" into "GameWorld".  
Create five classes to generate the lists of actors needed in the game to provide a maintainable way for other developers to modify the elements [Classes pic](/resource/RefactorPic/Classes.png).  
Separate the methods related to animal death checking into "DeathChecking" class. This ensures the code to be easier followed and modified.  
"BasicGUI" interface [Basic GUI pic](/resource/RefactorPic/BasicGUI.png) has been used to generate the game scene, and is extended by "BasicWindowGUI" interface [Basic Window GUI pic](/resource/RefactorPic/BasicWindowGUI.png), which is used to generate another window scene. By using them, changes and usage of objects become cheap in matter of time and risks.  
Extract subclass "MovingActor" [MovingActor pic](/resource/RefactorPic/MovingActor.png) from "Actor" [Actor pic](/resource/RefactorPic/Actor.png) , push down the "act" method to "MovingActor" and pull up the "checkBoundaryAndReset" in different actors to "MovingActor". This ensures some static actors only extends the superclass with less redundant methods and reduce tight coupling.
4.	Extract long methods to make it more understandable and easily modified [Extract method pic](/resource/RefactorPic/ExtractMethod.png).
5.	Rename the variable and method in all class to self-document [Rename pic](/resource/RefactorPic/Rename.png).
6.	Organizing the code by dividing it into different packages [Different Packages pic](/resource/RefactorPic/Packages.png).
7.	Change some public variables to private and change it to "final" and retain it through encapsulation [Data pic](/resource/RefactorPic/Data.png).
8.	Delete the lazy classes (e.g. merge "MyStage" with the game world).
9.	Separate large classes like "Animal" into "Frogger" and "FroggerImage" and extract the codes related to keyboard event to "GameController".
10. Form template methods in create car death animation and water death animation [Template method pic](/resource/RefactorPic/templateMethod.png) .
