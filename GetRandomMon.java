import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

public class GetRandomMon {
    //Method to look at file and print line
    //TODO: put docs notes above method or class name - this is the convention in the industry
    public void getRandMon() {
        String route = new File("Pokemon.txt").getAbsolutePath();
        String randMon = Line(route);
        System.out.println(randMon);
    }

    public String Line(String route) {
        //Method reads all lines in file and picks a random line to show
        //TODO: I recommend using more meaningful variable names
        List<String> linesFromFile;
        try {
            linesFromFile = Files.readAllLines(Paths.get(route));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        return linesFromFile.get(random.nextInt(linesFromFile.size()));
    }

}
