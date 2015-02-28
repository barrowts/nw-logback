
## Logback Appender for SAP NetWeaver Java Locations Logging ##

Latest Version: 0.0.1

## Dependencies ##

- Maven (install)
- Gradle (install)
- Logback Jar files
- SAP NW Logging API Jar

The logback jar files are sourced from maven central by gradle. However the SAP jar files are not stored in a publically accessible repository. Clone the git repo at [https://bitbucket.org/barrowts/sap-nw-jars](https://bitbucket.org/barrowts/sap-nw-jars) and follow its instructions for installing into local maven repo.


## Local Maven Repo Install ##

Installing the library into your local maven repo allows it to be easily used by maven and gradle build scripts of other projects and allows the use of non-NWDS (which in Windows only) IDEs. The build.gradle script has applied the maven plugin, so just install by running the following gradle command.

	gradle install

## Eclipse ##

The gradle script is configured to set up the eclipse project and classpath.
Because dependecies are stored in your user's maven repo (/Users/name/.m2) or gradle caches (/Users/name/.gradle), and because eclipse does not support env variables, the gradle eclipse configuration will replace those user specific values with 'M2_REPO' and 'GRADLE_CACHES'.
The M2_REPO variable will already exist if you have the m2e eclipse plugin installed. You will need to manually add the GRADLE_CACHES variable once per workspace, referencing /Users/name/.gradle/caches). This way, the .classpath file can be checked into soruce control.

To refresh the eclipse setup, run:

	gradle eclipse

To change any gradle ecliplse settings, refer to the `eclipse.gradle` file.

## Running Tests ##

Tests can be run with the command:
	
	gradle test
	
The gradle script has also been comfigured to automatically run the tests during the `install` command.

## Other Available Gradle Commands ##

| Command | Notes  |
|---------------|----------------|
| gradle tasks  |   print available tasks   |
| gradle dependencies  |   print dependency trees   |
| gradle compileJava  |   exports to .build/classes   |
| gradle jar |   exports to .build/libs   |

