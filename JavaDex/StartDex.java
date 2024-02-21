import java.util.Scanner;

/** Class starts the user into the loop of picking a Pokédex to view and continues looping through until the user stops it*/
public class StartDex {
    // TODO: consider using picocli library for building the commandline functionality
    // https://www.baeldung.com/java-picocli-create-command-line-program
    // this will more easily allow you to parse user input
    // also consider using the *Command Pattern* so that you don't need to use so many statements and you can
    // consolidate all of the functionality of parsing user input into a single location - https://www.baeldung.com/java-command-pattern
    // https://refactoring.guru/design-patterns/command
    // https://www.tutorialspoint.com/design_pattern/command_pattern.htm
    /** Method asks a user which Pokédex functionality they want* */
    public static void getDex() {
        //TODO: changed the output to be easier to read
        System.out.println("""
                Enter which Pokédex mode you want to use:
                'random' for random Pokédex entry
                'stats' to search by stats
                'regular' to search with given parameters:
                """);
        boolean dex = true;
        loopChooseDex(dex);
    }
    /** Method loops the chooseDex() function*/
    public static void loopChooseDex(boolean moreDex){
        while (moreDex) {
          if(chooseDex()){
            moreDex = true;
          } else {
              moreDex = false;
          }
        }
    }
    /** Method uses user input prompted by getDex() to call Pokédex functions*/
    public static boolean chooseDex(){
        boolean moreDex = true;
        Scanner pickDex = new Scanner(System.in);
        String wantedDex = pickDex.next();
        if (wantedDex.toLowerCase().startsWith("ra")) {
            GetRandomMon randDex = new GetRandomMon();
            System.out.println("Your Random Pokémon:");
            randDex.getRandMon();
            moreDex = moreMons();
        }
        if (wantedDex.toLowerCase().startsWith("st")) {
            System.out.println("You chose to enter your own parameters\nEnter your" +
                    " chosen parameters:");
            GetMons statDex = new GetMons();
            statDex.getStats();
            moreDex = moreMons();
        }
        if (wantedDex.toLowerCase().startsWith("re")) {
            System.out.println("You chose to enter your own parameters\nEnter your" +
                    " chosen parameters:");
            GetMons regDex = new GetMons();
            regDex.findEntry();
            moreDex = moreMons();
        } else {
            if (moreDex) {
                System.out.println("That's not an option :/\n\n\n");
                System.out.println("""
                        Enter which Dex mode you want to use:
                        'random' for random Dex entry
                        'stats' to search by stats
                        'regular' to search with given parameters:""");
                chooseDex();
            }
            moreDex = false;

        }
        pickDex.close();
        return moreDex;
    }
    /** Method asks user if they want to search for more Pokémon or closes the loop*/
    public static boolean moreMons() {
        String stillMons;
        System.out.println("\nIf you want to keep searching type 'y' if not, type any other key.");
        Scanner yesOrNo = new Scanner(System.in);
        stillMons = yesOrNo.next();

        if (stillMons.toLowerCase().startsWith("y")) {
            getDex();
        } else {
            EndDex seeYa = new EndDex();
            System.out.println("\n\nSee you next time!");
            seeYa.goodbye();
            return false;
        }
        yesOrNo.close();
        return false;
    }
    /** ASCII art to welcome the user*/
    public static void welcome() {
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
        System.out.println("You can search for Pokémon by name, stats, or get shown a random Pokémon with this Pokédex!" +
                "\nIf your parameters apply to multiple Pokémon, you will be shown all of them in National Pokédex order.");
    }
}
    //This method is for debugging purposes
   /*public void getAllPokemon() {
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
    }*/
