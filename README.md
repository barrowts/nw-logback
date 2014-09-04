
## Logback Appender for SAP NetWeaver Java Locations Logging ##

Latest Version: 0.0.1


### How do I get set up? ###

* You need to first get the required SAP NW Jar file and add it to your local maven repo
* Dependencies 
* Database configuration
* How to run tests
* Deployment instructions

### Eclipse ###

The gradle script is configured to set up the eclipse project and classpath.
Because dependecies are stored in your user's maven repo (/Users/name/.m2) or gradle caches (/Users/name/.gradle), and because eclipse does not support env variables, the gradle eclipse configuration will replace those user specific values with 'M2_REPO' and 'GRADLE_CACHES'.
The M2_REPO variable will already exist if you have the m2e eclipse plugin installed. You will need to manually add the GRADLE_CACHES variable once per workspace, referencing /Users/name/.gradle/caches). This way, the .classpath file can be checked into soruce control.

To refresh the eclipse setup, run `gradle eclipse`.

To change any gradle ecliplse settings, refer to the `eclipse.gradle` file.


### Contribution guidelines ###

* Write tests!?!?
