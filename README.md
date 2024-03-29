# AutoBuilder

This tool helps in building the AppDynamics open-source extensions automatically. No more hicups of installing maven or git commands in your production server, and run into various troubles building the extensions manually.

Output: Zip file of the target extension.

**Prerequisite: Java 1.8 is required and $JAVA_HOME should point to the same.**

**Step-1:** Run "echo $JAVA_HOME" command in your machine where you want to build the extension/s. The output should point to the path of Java 1.8. Only after confirming this, proceed to Step-2.

**Step-2:** Download the latest available version of the attached file AutoBuilder-<x.y.z>.jar.

**Step-3:** From the terminal or the command prompt (in case of windows), navigate to the path where you have downloaded the above JAR file and run this command:
            java -jar AutoBuilder-<x.y.z>.jar

**Step-4:** Enter the absolute path where you want the zip file to be. This path should be an empty directory.

**Step-5:** Select the number from the list of extensions you want to build. This should be a numeric input. Only one extension can be built at a time.

**Step-6:** That's it! Now, sit back and relax. It will take a few minutes before the zip file gets ready at the target path.


**Additional Logging**: This will help you diagnose if any issues related to maven/build. If you notice any error/s in building the extension or you don't see the zip file in the target directory, then you can enable additional maven related logging by restarting the AutoBuilder with this command:
           java -Dautobuilder.logging.enabled=true -jar AutoBuilder-<x.y.z>.jar
           
 
