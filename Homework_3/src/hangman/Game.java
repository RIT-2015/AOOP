package hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Pratik on 9/14/2015.
 */
public class Game {
    private Vector<String> words = new Vector<>();
    private Scanner input = new Scanner(System.in);
    private Random random = new Random();
    String partialString;



    public void readFile(String fileName) throws FileNotFoundException {
        Scanner fileScanner = new Scanner(new File(fileName));
        while(fileScanner.hasNext()) {
            words.add(fileScanner.next());
        }
    }

    private String selectWord() {
        int random = this.random.nextInt(20);
        return words.get(random);
    }

    private void makePartialString(String word) {
        char[] chars = new char[word.length()];
        for(int i = 0; i < chars.length; i++) {
            chars[i] = '-';
        }

        partialString = new String(chars);
    }
    private void showPartialWord(String word, char inputChar) {
        char c;
        char[] charArray = partialString.toCharArray();
        for(int counter = 0; counter < word.length(); counter++) {
            c = word.charAt(counter);
            if(c == inputChar) {
                charArray[counter] = inputChar;
            }
        }
        partialString = new String(charArray);
        System.out.println(partialString);
    }

    private int getWordLength(String word) {
        int counter = 0;
        for (int i = 0; i< word.length(); i++) {
            if(word.charAt(i) != '_') {
                counter++;
            }
        }
        return counter;
    }
    public void playGame(Player player) {
        String word = selectWord();
        makePartialString(word);
        System.out.println(word);
        int counter = 0, wrongAttempts = 0;
        while ((wrongAttempts < 8) && (counter < getWordLength(word))) {
            System.out.println("Enter next letter : ");
            String inputChar = input.next();
            if (inputChar.length() != 1) {
                System.out.println("Please enter valid input");
                System.exit(0);
            }
            if (word.contains(inputChar)) {
                counter++;
                showPartialWord(word, inputChar.charAt(0));
                word = word.replaceAll(inputChar, "_");
                continue;
            } else {
                wrongAttempts++;
                System.out.println("No of wrongs:  " + wrongAttempts);
            }
        }

        if (wrongAttempts == 8) {
            System.out.println("Sorry " + player.getName());
            player.setScore(-5);
        } else {
            player.setScore(10);
            System.out.println("well Done " + player.getName());
        }
    }
}
