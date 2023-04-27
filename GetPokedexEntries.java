import java.util.*;
import java.io.*;
public class GetPokedexEntries
{
    /*This class will drive finding a pokemon and display its line or
    will display all pokemon of a certain type*/
    public static void main(String [] args){
        StartDex start = new StartDex();
        //start.getAllPokemon();//debug
        start.welcome();
        start.whichDex();
    }


}
