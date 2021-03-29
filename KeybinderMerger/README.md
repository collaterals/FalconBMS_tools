# Keybinder Merger Tool
The Keybinder Merger Tool runs a small server which can be accessed via browser at http://localhost:7000.

## For developers
Developed with Javalin, Vue and some Apache Tools.

### Enable Development Mode
In your Intellij/Eclipse set an environment variable for enabling the development mode.
Then you can see every change in html and other static files by just refreshing.

    set developmentMode=true

### Build

    mvn clean install

The result is a simple jar "FalconBMS-version.jar" that is runnable by doubleclick in Windows.

Or call it with a cmd line

    java -jar FalconBMS-version.jar
