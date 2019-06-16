# jRobot
Recursion


jRobot is the leading advanced technology company when it comes to cleaning your virtual home. However, their latest product is so advanced that they require your help to implement the cleaning logic in their software. A prototype Robot has already been created and its binary has been provided to you. Your job is to create the JRobot from this Robot such that if given a text representation of a room and its starting location the JRobot can clean the entire room before returning to its starting location.

Important: You can assume that for every room, you will always be able to move forward from the starting position.


An example room would look like this:
```
00000000000000000000000
000000000000.......0000
0............00000.0..0
0.000000000..00..0.0..0
0.0....0.....00..0.0..0
0.0....0.00..00..0.0..0
0......0.00..00.......0
00000000*00000000000000
```

Where '0' indicates a wall, '.' indicates a dirty floor, '*' indicates the Robot starting location, and a ' ' indicates a clean floor.

Upon successfully cleaning the entire room, the output should look like this:
```
00000000000000000000000
000000000000       0000
0            00000 0  0
0 000000000  00  0 0  0
0 0    0     00  0 0  0
0 0    0 00  00  0 0  0
0      0 00  00       0
00000000 00000000000000
```

A visual representation of the JRobot in action can be seen when the show parameter of the constructor is set to true:
```
JRobot r = new JRobot(true);
```

![jRobot Simulation](/images/jRobot.png)

A Driver program has been provided for you. This will instantiate a new JRobot, turn on the visual simulator, start the robot, and stop it once it is finished. A testing room has been provided for you as well. Feel free to create as many rooms as you woul like to test out your new cleaning robot!

The documentation for the [Robot](https://dragonkarsh.github.io/jRobot/apidocs/Robot.html) and [Direction](https://dragonkarsh.github.io/jRobot/apidocs/Direction.html) classes are also available [here](https://dragonkarsh.github.io/jRobot/apidocs/index.html)


