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
            //Reading file and getting user input
            File read = new File("Pokemon.txt");
            Scanner reader = new Scanner(read);
            Scanner input = new Scanner(System.in);
            String chosen = input.next();
            //This loop prints selected pokémon
            while (reader.hasNext()) {
                String entry = reader.nextLine();
                //TODO: introduce variable that is used multiple times
                boolean contains = entry.toLowerCase().startsWith(chosen.toLowerCase());
                if(contains){
                    System.out.println("Pokemon that contain your parameters: " + entry);
                }
               //TODO: handle the case where the user enters something not in file and print a message
                //TODO: if you already know they're searching for Mewtwo you can immediately print that without using the reader
                //TODO: this conditional is always true - therefore it's unnecessary
            }
            reader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void getStats() {
        //Method takes user input in the form of an int and replies with the matched stats
        try {
            File read2 = new File("Pokemon.txt");
            Scanner reader2 = new Scanner(read2);
            Scanner stat = new Scanner(System.in);
            int points = stat.nextInt();
            while (reader2.hasNext()) {
                String entry2 = reader2.nextLine();
                String sP = Integer.toString(points);
                //Pattern and Matcher are to help find the int, "\\b" before and after the sP variable
                //tell program to only look for the given parts of the input
                Pattern pattern = Pattern.compile("\\b" + sP + "\\b");
                Matcher matcher = pattern.matcher(entry2);
                if (matcher.find()) {
                    System.out.println("Pokemon that contain your parameters: " + entry2);
                }
            }
            reader2.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}






