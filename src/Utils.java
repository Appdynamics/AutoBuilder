import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Utils {
    static String scanPath(String path)
    {
        String targetFile;
        File folderToScan = new File(path);
        File[] listOfFiles = folderToScan.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
                targetFile = listOfFiles[i].getName();
                if (targetFile.endsWith(".zip"))
                    return targetFile;
            }
        }
        return null;
    }
    static void movezipFile(String src, String dest) {
        Path result = null;
        try {
            result = Files.move(Paths.get(src), Paths.get(dest));
        } catch (IOException e) {
            System.out.println("Exception while moving file: " + e.getMessage());
            e.printStackTrace();
            System.out.println("Thank you for using AutoBuilder! You can find your extension zip file in the path " + dest + "\n");
            System.exit(0);
        }
    }

    public static void deleteFolderContents(File file, String zipFile)
    {
        for (File subfile : file.listFiles()) {
            if (subfile.isDirectory())
                deleteFolderContents(subfile, zipFile);
            if(!subfile.getName().equals(zipFile))
                subfile.delete();
        }
    }

    public static boolean confirmBuild(File file, String zipFile)
    {
        for (File subfile : file.listFiles())
            if (subfile.getName().equals(zipFile))
                return true;
        return false;

    }
}
