import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        first_puzzle();
        second_puzzle();
    }

    private static List<Integer> read_file(){
        List<Integer> elements = new ArrayList<>();
        try{
            Scanner reader = new Scanner(new File("input"));
            while(reader.hasNextLine()){
                elements.add(Integer.parseInt(reader.nextLine()));
            }
        }
        catch (FileNotFoundException e){
            System.out.println("Error ocurred when read input");
            e.printStackTrace();
        }
        return elements;
    }

    private static void first_puzzle(){
        List<Integer> elements = read_file();
        int increasses = 0;
        for(int i = 1; i <elements.size(); i++){
            if (elements.get(i-1) < elements.get(i)){
                increasses++;
            }
        }
        System.out.println("Increasses puzzle 1: " + increasses);
    }

    private static void second_puzzle(){
        List<Integer> elements = read_file();
        int increasses = 0;

        for(int i = 3; i < elements.size(); i++){
            int prev = elements.get(i-3) + elements.get(i-2) + elements.get(i-1);
            int next = elements.get(i-2) + elements.get(i-1) + elements.get(i);

            if(next > prev){
                increasses++;
            }
        }

        System.out.println("Increasses puzzle 2: " + increasses);
        
    }
}