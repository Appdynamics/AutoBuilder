import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.errors.GitAPIException;
import java.io.*;
import java.net.URL;
import java.util.Map;
import java.util.Scanner;


public class Controller {
    public static String chooseExtensionAndSetUri() {
        System.out.println("\nChoose the extension you want to build: \n");
        System.out.println("1. URL Monitoring Extension");
        System.out.println("2. Process Monitoring Extension");
        System.out.println("3. Log Monitoring Extension");
        System.out.println("4. File Watcher Monitoring Extension");
        System.out.println("5. ActiveMQ Monitoring Extension");
        System.out.println("6. DataPower Monitoring Extension");
        System.out.println("7. RabbitMQ Monitoring Extension");
        System.out.println("8. Apache Monitoring Extension");
        System.out.println("9. Redis Monitoring Extension");
        System.out.println("10. Hadoop Monitoring Extension");
        System.out.println("11. Linux Monitoring Extension");
        System.out.println("12. SQL Monitoring Extension");
        System.out.println("13. F5 Monitoring Extension");
        System.out.println("14. NGINX Monitoring Extension");
        System.out.println("15. Zookeeper Monitoring Extension");
        System.out.println("16. HA Proxy Monitoring Extension");
        System.out.println("17. Kafka Monitoring Extension");
        System.out.println("18. ElasticSearch Monitoring Extension");
        System.out.println("19. SSL Certificate Monitoring Extension");
        System.out.println("20. Azure Monitoring Extension");
        System.out.println("21. VMware vSphere Monitoring Extension");
        System.out.println("22. Apache Spark Monitoring Extension");
        System.out.println("23. Docker Monitoring Extension");
        System.out.println("24. JMX Monitoring Extension");
        System.out.println("25. AWS EC2 Monitoring Extension");
        System.out.println("26. AWS Lambda Monitoring Extension");
        System.out.println("27. AWS RDS Monitoring Extension");
        System.out.println("28. AWS S3 Monitoring Extension");
        System.out.println("29. AWS SQS Monitoring Extension");
        System.out.println("30. AWS Custom Namespace Monitoring Extension\n");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        String Uri;
        switch (choice) {
            case 1:
                Uri = "https://github.com/Appdynamics/url-monitoring-extension.git";
                break;
            case 2:
                Uri = "https://github.com/Appdynamics/process-monitoring-extension.git";
                break;
            case 3:
                Uri = "https://github.com/Appdynamics/log-monitoring-extension.git";
                break;
            case 4:
                Uri = "https://github.com/Appdynamics/file-monitoring-extension.git";
                break;
            case 5:
                Uri = "https://github.com/Appdynamics/activemq-monitoring-extension.git";
                break;
            case 6:
                Uri = "https://github.com/Appdynamics/datapower-monitoring-extension.git";
                break;
            case 7:
                Uri = "https://github.com/Appdynamics/rabbitmq-monitoring-extension.git";
                break;
            case 8:
                Uri = "https://github.com/Appdynamics/apache-monitoring-extension.git";
                break;
            case 9:
                Uri = "https://github.com/Appdynamics/redis-monitoring-extension.git";
                break;
            case 10:
                Uri = "https://github.com/Appdynamics/hadoop-monitoring-extension.git";
                break;
            case 11:
                Uri = "https://github.com/Appdynamics/linux-monitoring-extension.git";
                break;
            case 12:
                Uri = "https://github.com/Appdynamics/SQLMonitor.git";
                break;
            case 13:
                Uri = "https://github.com/Appdynamics/f5-monitoring-extension.git";
                break;
            case 14:
                Uri = "https://github.com/Appdynamics/nginx-monitoring-extension.git";
                break;
            case 15:
                Uri = "https://github.com/Appdynamics/zookeeper-monitoring-extension.git";
                break;
            case 16:
                Uri = "https://github.com/Appdynamics/haproxy-monitoring-extension.git";
                break;
            case 17:
                Uri = "https://github.com/Appdynamics/kafka-monitoring-extension.git";
                break;
            case 18:
                Uri = "https://github.com/Appdynamics/elasticsearch-monitoring-extension.git";
                break;
            case 19:
                Uri = "https://github.com/Appdynamics/ssl-certificate-monitoring-extension.git";
                break;
            case 20:
                Uri = "https://github.com/Appdynamics/azure-monitoring-extension-archived.git";
                break;
            case 21:
                Uri = "https://github.com/Appdynamics/vmware-vsphere-monitoring-extension.git";
                break;
            case 22:
                Uri = "https://github.com/Appdynamics/apache-spark-monitoring-extension.git";
                break;
            case 23:
                Uri = "https://github.com/Appdynamics/docker-monitoring-extension.git";
                break;
            case 24:
                Uri = "https://github.com/Appdynamics/jmx-monitoring-extension.git";
                break;
            case 25:
                Uri = "https://github.com/Appdynamics/aws-ec2-monitoring-extension.git";
                break;
            case 26:
                Uri = "https://github.com/Appdynamics/aws-lambda-monitoring-extension.git";
                break;
            case 27:
                Uri = "https://github.com/Appdynamics/aws-rds-monitoring-extension.git";
                break;
            case 28:
                Uri = "https://github.com/Appdynamics/aws-s3-monitoring-extension.git";
                break;
            case 29:
                Uri = "https://github.com/Appdynamics/aws-sqs-monitoring-extension.git";
                break;
            case 30:
                Uri = "https://github.com/Appdynamics/aws-customnamespace-monitoring-extension.git";
                break;
            default:
                System.out.println("\nWrong Input Choice. Please enter the correct number in the range (1-30)");
                Uri = null;
                System.exit(0);

        }
        return Uri;
    }

    public static void cloneRepository(String path, String Uri) throws IOException, GitAPIException {
        System.out.println("\n(Step 1/5) Cloning Git repository...");
        PrintStream filterOut = new PrintStream(System.err) {
            public void println(String l) {
                if (!l.startsWith("SLF4J"))
                    super.println(l);
            }
        };
        System.setErr(filterOut);
        Git.cloneRepository().setURI(Uri).setDirectory(new File(path)).call();
        System.out.println("\nGit repository cloned successfully!");
    }

    public static void downloadApacheMaven(String path) {
        System.out.println("\n(Step 2/5) Downloading Apache Maven...");
        try (BufferedInputStream inputStream = new BufferedInputStream(new URL("https://dlcdn.apache.org/maven/maven-3/3.8.5/binaries/apache-maven-3.8.5-bin.zip").openStream());
             FileOutputStream fileOS = new FileOutputStream(path + File.separator + "apache-maven-3.8.5-bin.zip")) {
            byte data[] = new byte[1024];
            int byteContent;
            while ((byteContent = inputStream.read(data, 0, 1024)) != -1) {
                fileOS.write(data, 0, byteContent);
            }
        } catch (IOException e) {
            System.out.println("Unable to download Apache Maven!");
            System.exit(0);
        }
        System.out.println("\nApache Maven downloaded successfully!");
    }

    public static void unzipApacheMaven(String path) throws IOException {
        System.out.println("\n(Step 3/5) Unzipping Apache Maven...");
        String source = path + File.separator + "apache-maven-3.8.5-bin.zip";
        String destination = path;
        try {
            ZipFile zipFile = new ZipFile(source);
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            //    e.printStackTrace();
            System.exit(0);
        }
        System.out.println("\nApache Maven unzipped successfully!");
    }

    public static void setEnvironmentVariableForMavenAndInstallZip(String path, String os) throws IOException, InterruptedException {
        String loggingEnabled = System.getProperty("autobuilder.logging.enabled", "false");
        System.out.println("\n(Step 4/5) Sit back and have some coffee! Your extension will be built within a few minutes...\n");
        ProcessBuilder pb;
        if (os.contains("win"))
            pb = new ProcessBuilder("CMD", "/C", "SET");
        else
            pb = new ProcessBuilder("/bin/sh");

        Map<String, String> envMap = pb.environment();
        envMap.put("PATH", path + File.separator + "apache-maven-3.8.5" + File.separator + "bin:$PATH");
        pb.start();

        File file = new File(path + File.separator + "apache-maven-3.8.5" + File.separator + "bin" + File.separator + "mvn");
        file.setExecutable(true);
        System.setProperty("maven.test.skip", "true");
        ProcessBuilder build = new ProcessBuilder();
        if (os.contains("win"))
            build.command("cmd.exe", "/c", path + File.separator + "apache-maven-3.8.5" + File.separator + "bin" + File.separator + "mvn", "clean", "install");
        else
            build.command(path + File.separator + "apache-maven-3.8.5" + File.separator + "bin" + File.separator + "mvn", "clean", "install");



        build.directory(new File(path));
        Process process = build.start();

        if (loggingEnabled.equals("true")) {
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String s = null;
            while ((s = stdInput.readLine()) != null)
                System.out.println(s);
            System.out.println();
        }
        try {
            process.waitFor();
        } catch (InterruptedException e) {
            System.exit(0);
        }
        System.out.println("Congratulations! Your extension has been built successfully!\n");
    }

    public static void deleteUnwantedFilesAndDirectories(String path, String os) throws IOException {
        System.out.println("(Step 5/5)  Clearing unwanted files & directories... \n");
        String zipFile = Utils.scanPath(path + File.separator + "target");
        Utils.movezipFile(path + File.separator + "target" + File.separator + zipFile,  path + File.separator + zipFile);
        Utils.deleteFolderContents(new File(path), zipFile);
        boolean zipbuilt =  Utils.confirmBuild(new File(path), zipFile);
        if (zipbuilt)
            System.out.println("Thank you for using AutoBuilder! You can find your extension zip file under the path " + path + "\n");
    }


}


