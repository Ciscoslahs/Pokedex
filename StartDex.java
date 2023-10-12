import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
//TODO: do not use '*' import - only import that parts of the packages that you
// '*' import causes unnecessary bloat

public class StartDex {
    public void welcome() {
        System.out.println("""

                                                                                                                     \s
                     _____           _____     ____    ____       ______        _____        ______                  \s
                 ___|\\    \\     ____|\\    \\   |    |  |    |  ___|\\     \\   ___|\\    \\   ___|\\     \\  _____      _____
                |    |\\    \\   /     /\\    \\  |    |  |    | |     \\     \\ |    |\\    \\ |     \\     \\ \\    \\    /    /
                |    | |    | /     /  \\    \\ |    | /    // |     ,_____/||    | |    ||     ,_____/| \\    \\  /    /\s
                |    |/____/||     |    |    ||    |/ _ _//  |     \\--'\\_|/|    | |    ||     \\--'\\_|/  \\____\\/____/ \s
                |    ||    |||     |    |    ||    |\\    \\'  |     /___/|  |    | |    ||     /___/|    /    /\\    \\ \s
                |    ||____|/|\\     \\  /    /||    | \\    \\  |     \\____|\\ |    | |    ||     \\____|\\  /    /  \\    \\\s
                |____|       | \\_____\\/____/ ||____|  \\____\\ |____ '     /||____|/____/||____ '     /|/____/ /\\ \\____\\
                |    |        \\ |    ||    | /|    |   |    ||    /_____/ ||    /    | ||    /_____/ ||    |/  \\|    |
                |____|         \\|____||____|/ |____|   |____||____|     | /|____|____|/ |____|     | /|____|    |____|
                  \\(              \\(    )/      \\(       )/    \\( |_____|/   \\(    )/     \\( |_____|/   \\(        )/ \s
                   '               '    '        '       '      '    )/       '    '       '    )/       '        '  \s
                                                                     '                          '                    \s""");
        System.out.println("You can search for pokemon by type or search for a single " +
                "pokemon with this method or get shown a random Pokemon");
    }

    // TODO: consider using picocli library for building the commandline functionality
    // https://www.baeldung.com/java-picocli-create-command-line-program
    // this will more easily allow you to parse user input
    // also consider using the *Command Pattern* so that you don't need to use so many statements and you can
    // consolidate all of the functionality of parsing user input into a single location - https://www.baeldung.com/java-command-pattern
    // https://refactoring.guru/design-patterns/command
    // https://www.tutorialspoint.com/design_pattern/command_pattern.htm
    public static void whichDex() {
        //TODO: changed the output to be easier to read
        System.out.println("""
                Enter which Dex mode you want to use:
                'random' for random Dex entry
                'stats' to search by stats
                'regular' to search with given parameters:
                """);
        Scanner which = new Scanner(System.in);
        String thisOne = which.next();
        //boolean to keep the while loop going
        boolean moreDex = true;
        while (moreDex != false) {
            //gets random pokemon
            if (thisOne.toLowerCase().contains("ra")) {
                GetRandomMon randMon = new GetRandomMon();
                System.out.println("Your Random Pokemon:");
                randMon.getRandMon();
                moreDex = keepGoing();
            }
            //gets pokemon by stats
            if (thisOne.toLowerCase().contains("st")) {
                System.out.println("You chose to enter your own parameters\nEnter your" +
                        " chosen parameters:");
                GetMons sDex = new GetMons();
                sDex.getStats();
                moreDex = keepGoing();
            }
            //gets Pokémon by string input
            if (thisOne.toLowerCase().contains("re")) {
                System.out.println("You chose to enter your own parameters\nEnter your" +
                        " chosen parameters:");
                GetMons dex = new GetMons();
                dex.findEntry();
                moreDex = keepGoing();
                //if the input is not one of the options, it asks the question again
            }else if(!thisOne.toLowerCase().contains("re") || !thisOne.toLowerCase().contains("ra") || !thisOne.toLowerCase().contains("st")){
                if(moreDex != false){
                    System.out.println("That's not an option :/\n\n\n");
                    whichDex();
                }
                //if the user wants to stop playing, the boolean is set to false and the game stops
                moreDex = false;

            }
        }

    }
    //Asks players if they want to continue playing or stop
    public static boolean keepGoing() {
        String answer;
            //Scanner takes input from keyboard and evaluates what it is, 'y' continues game, 'n' stops game, and any other option asks the question again
            System.out.println("\nIf you want to keep playing type 'y' if not, type any other key.");
            Scanner keyboard = new Scanner(System.in);
            answer = keyboard.next();

            if (answer.toLowerCase().contains("y")) {
                whichDex();
            }else {
                EndDex seeYa = new EndDex();
                System.out.println("\n\nSee you next time!");
                seeYa.goodbye();
                return false;
            }
            return false;
    }

    //This method is for debugging purposes
    public void getAllPokemon() {
        try {
            File all = new File("Pokemon.txt");
            Scanner reader = new Scanner(all);
            while (reader.hasNextLine()) {
                String printDex = reader.nextLine();
                System.out.println(printDex);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
            e.printStackTrace();
        }
    }
}
