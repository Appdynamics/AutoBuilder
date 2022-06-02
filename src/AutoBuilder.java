import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.File;
import java.io.IOException;

public class AutoBuilder
{
    public static void main(String[] args) throws IOException, GitAPIException, InterruptedException {

        String javaVersion = Runtime.class.getPackage().getImplementationVersion();
        if(javaVersion.startsWith("1.8")) {
            // System.out.println("\nEnter Absolute Path (Should be an empty directory) :");
            // Scanner scanner = new Scanner(System.in);
            // String path = scanner.next();
            String path = System.getProperty("autobuilder.path", System.getProperty("java.class.path").replaceAll("/AutoBuilder-[0-9]+.[0-9]+.[0-9]+.jar", "") + File.separator + "out");
            System.out.println("\nPath: " +path);
            String os = System.getProperty("os.name").toLowerCase();
            String Uri = Controller.chooseExtensionAndSetUri();
            Controller.cloneRepository(path, Uri);
            Controller.downloadApacheMaven(path);
            Controller.unzipApacheMaven(path);
            Controller.setEnvironmentVariableForMavenAndInstallZip(path, os);
            Controller.deleteUnwantedFilesAndDirectories(path, os);
        }
        else {
            System.out.println("Java version being used here is: " + javaVersion + ". Please point the $JAVA_HOME environment variable in your system to Java 8 and re-invoke this Jar file to continue!" );
            System.exit(0);
        }
    }
}
