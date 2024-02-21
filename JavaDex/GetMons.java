import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Class to find Pokémon in the line with a String input or an Integer input from the user*/
public class GetMons {
    /** Goal of method is to find an entry in the pokédex and print the whole line
      from that entry line*/
    public void findEntry() {
        try {
            File readMons = new File("Pokemon.txt");
            Scanner monFinder = new Scanner(readMons);
            Scanner userMon = new Scanner(System.in);
            String chosenMon = userMon.next();
            boolean foundMon = false;
            while (monFinder.hasNext()) {
                //TODO: introduce variable that is used multiple times
                String dexEntry = monFinder.nextLine();
                if(dexEntry.toLowerCase().contains(chosenMon.toLowerCase())){
                    System.out.println("Pokémon that contain your parameters: " + dexEntry);
                    foundMon = true;
                }
            }
            if(!foundMon){
                System.out.println("No Pokémon found\n\n");

            }
            monFinder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            SurprisedPikachuImage error = new SurprisedPikachuImage();
            error.surprisedPikachu();
        }

    }
    /** Method takes user input in the form of an int and replies with the matched stats*/
    public void getStats() {
        try {
            File readStats = new File("Pokemon.txt");
            Scanner statFinder = new Scanner(readStats);
            Scanner givenStat = new Scanner(System.in);
            int givenPoints = givenStat.nextInt();
            boolean foundStat = false;
            while (statFinder.hasNext()) {
                String userStats = statFinder.nextLine();
                String statPoints = Integer.toString(givenPoints);
                Pattern statsOfMon = Pattern.compile("\\b" + statPoints + "\\b");
                Matcher matchToStats = statsOfMon.matcher(userStats);
                if (matchToStats.find()) {
                    System.out.println("Pokémon that contain your parameters: " + userStats);
                    foundStat = true;
                }
            }
            if(!foundStat){
                System.out.println("No Pokémon found\n\n");
            }
            statFinder.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            SurprisedPikachuImage error = new SurprisedPikachuImage();
            error.surprisedPikachu();
        }
    }
}
