# AutoBuilder

**Prerequisite: Java 1.8 is required and $JAVA_HOME should point to the same.**

Step-1: Run "java -version" command in your machine where you want to build the extension/s. The output should point to Java 1.8.

Step-2: Download the latest available version of the attached file AutoBuilder-<x.y.z>.jar.

Step-3: From the terminal or the command prompt (in case of windows), navigate to the path where you have downloaded the above JAR file and run this command:
            java -jar AutoBuilder-<x.y.z>.jar
            
Step-4: Enter the absolute path of the directory where you want the extension zip file to be created. This should be an empty directory. If the same directory does not exist, then it will be created automatically at the mentioned path.

Step-5: Select the number from the list of extensions you want to build. This should be a numeric input. Only one extension can be built at a time.

Step-6: That's it! Now, sit back and relax. It will take a few minutes before the zip file gets ready at the path mentioned earlier.


Additional Logging
-> Additional logging will help you diagnose if any issues. If you notice any error/s in building the extension or you don't see the zip file in the target directory, then you can enable additional maven logging by restarting the AutoBuilder with this command:
           java -Dautobuilder.logging.enabled=true -jar AutoBuilder-<x.y.z>.jar
           
 
