import java.util.*;
import java.io.*;
import java.util.regex.*;

public class GetMons {
    public void findEntry() {
        /*Goal of method is to find an entry in the pokedex and print the whole line
          from that entry line*/
        try {
            File read = new File("Pokemon.txt");
            Scanner reader = new Scanner(read);
            Scanner input = new Scanner(System.in);
            String chosen = input.next();
            //This loop prints selected pokemon
            while (reader.hasNext()) {
                String entry = reader.nextLine();
                if (entry.toLowerCase().contains(chosen.toLowerCase()) && chosen.length() == 3) {
                    if (chosen.toLowerCase().contains("mew")) {
                        //If block to determine if looking for Mew or Mewtwo

                        if (chosen.length() == 3) {
                            System.out.println("Your selected Pokemon is: " + reader.nextLine());
                        }

                        if (chosen.length() == 6) {
                            System.out.println("Your selected Pokemon is: " + entry);
                        }

                    }
                    if(!chosen.toLowerCase().contains("mew")){
                        System.out.println("Pokemon that contain your parameters: " + entry);
                    }

                }
                if (entry.toLowerCase().contains(chosen.toLowerCase()) && chosen.length() > 3) {
                    System.out.println("Pokemon that contain your parameters: " + entry);
                }

                if (entry.toLowerCase().contains(chosen.toLowerCase()) && chosen.length() <= 2) {
                    System.out.println("Pokemon that contain your parameters: " + entry);
                }

            }
            reader.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
            }

    }

    public void getStats(){
        //Method takes user input in the form of an int and replies with the matched stats
     try{
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
            if(matcher.find()) {
                System.out.println("Pokemon that contain your parameters: " + entry2);
            }

        }
         reader2.close();
     } catch (FileNotFoundException e) {
             e.printStackTrace();
     }

    }

}






