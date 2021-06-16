# ToyRobot Simulator Code challenge!

This application is developed to demonstrate programming skills in java. Application is gradle based java application that is built with java 8.

# Files

As a console java application main method is kept in Application class that is sitting at the root of project structure.

## Basic Requirements
you need minimum java 8 and gradle 2.14-rc-5
## Building the jar
This project is provided with gradle wrapper. Followig commands could be used to build the jar. Run below command from application directory

-	unzip the archive to place of your choice lets say ~/toyrobot
-	cd ~/toyrobot
-	gradle clean build

## Running the application

-	unzip the archive to place of your choice lets say ~/toyrobot
-	cd ~/toyrobot
-	gradle run -q (please do not forget to provide -q option otherwise console will get polluted)
     Application will start and wait for input
     Enter a command from below phrases
     PLACE X,Y,EAST, WEST, NORTH, SOUTH
     MOVE, LEFT, RIGHT, REPORT or EXIT
-	Please make a valid choice from above menu
-	To exit the application you use Ctl + C or provide EXIT as command
-	For example you can provide the below commands (Commands are case sensitive)
     -	PLACE 0,1,NORTH
     -	MOVE
     -	RIGHT
     -	REPORT
     you will get the followig output
     Output: 0,2,EAST
- You can try different combinations of commands for any kind of testing