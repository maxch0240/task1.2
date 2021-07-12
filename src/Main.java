import java.io.*;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) throws IOException {
        String path = args[0];
        String symbols = args[1];
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        PrintWriter writer = new PrintWriter("merged.txt", StandardCharsets.UTF_8);
        int deletedLines = 0;

        assert listOfFiles != null;
        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println(file.getName());
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    if(line.contains(symbols)) deletedLines++;
                    if(!line.contains(symbols)) writer.println(line);
                    line = reader.readLine();
                }
            }
        }
        writer.close();
        System.out.println("deleted lines: " + deletedLines);
    }
}
