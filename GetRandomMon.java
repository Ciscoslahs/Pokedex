import java.util.*;
import java.io.*;
import java.nio.file.*;


public class GetRandomMon {
    public void getRandMon(){
        //Method to look at file and print line
        String route = new File("Pokemon.txt").getAbsolutePath();
        String randMon = Line(route);
        System.out.println(randMon);
    }
    public String Line(String route) {
        //Method reads all lines in file and picks a random line to show
        List<String> l;
        try {
            l = Files.readAllLines(Paths.get(route));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        Random random = new Random();
        return l.get(random.nextInt(l.size()));
    }

}
