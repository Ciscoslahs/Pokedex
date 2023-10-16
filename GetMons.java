import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetMons {
    /*Goal of method is to find an entry in the pokédex and print the whole line
      from that entry line*/
    //TODO: put docs notes above method or class name - this is the convention in the industry
    public void findEntry() {
        try {
            File readMons = new File("Pokemon.txt");
            Scanner monFinder = new Scanner(readMons);
            Scanner userMon = new Scanner(System.in);
            String chosenMon = userMon.next();
            while (monFinder.hasNext()) {
                String dexEntry = monFinder.nextLine();
                //TODO: introduce variable that is used multiple times
                boolean containsMon = dexEntry.toLowerCase().startsWith(chosenMon.toLowerCase());
                if(containsMon){
                    System.out.println("Pokémon that contain your parameters: " + dexEntry);
                }
                //TODO: handle the case where the user enters something not in file and print a message

            }
            monFinder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
    //Method takes user input in the form of an int and replies with the matched stats
    public void getStats() {
        try {
            File readStats = new File("Pokemon.txt");
            Scanner statFinder = new Scanner(readStats);
            Scanner givenStat = new Scanner(System.in);
            int givenPoints = givenStat.nextInt();
            while (statFinder.hasNext()) {
                String userStats = statFinder.nextLine();
                String statPoints = Integer.toString(givenPoints);
                Pattern statsOfMon = Pattern.compile("\\b" + statPoints + "\\b");
                Matcher matchToStats = statsOfMon.matcher(userStats);
                if (matchToStats.find()) {
                    System.out.println("Pokémon that contain your parameters: " + userStats);
                }
            }
            statFinder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}






