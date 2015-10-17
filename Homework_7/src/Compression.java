import java.io.*;
import java.nio.Buffer;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Pratik on 10/9/2015.
 */
public class Compression {
    private int bufferSize = 1024;
    private int maxSize = 100;
    private int size = 0;
    private double loadingFactor = 0.75d;
    private int threshhold = (int)(maxSize * loadingFactor);
    private String[] dictionary = new String[maxSize];

    private int isPresent(String input) {
        for (int index = 0; index < size; index ++) {
            if (dictionary[index].equals(input)) {
                return index;
            }
        }
        return -1;
    }

    private void add(String input) {
        if (size == threshhold) {
            this.expand();
        }
        dictionary[size++] = input;
    }

    private void expand() {
        int previousMaxSize = maxSize;
        maxSize += threshhold;
        threshhold = (int)(maxSize * loadingFactor);
        String newString[]  = new String[maxSize];
        for (int index = 0; index < previousMaxSize; index++)  {
            newString[index] = dictionary[index];
        }
        dictionary = newString;
    }

    public void compress(File file) throws IOException {
        int code;
        boolean printed = false;
        char currentChar;
        String input, word ="", prevWord = "", compressedString = "";
        String newline = System.getProperty("line.separator");
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);
        CompressedOutput output = new CompressedOutput();
        while ((input = reader.readLine()) != null) {
            printed = false;
            for (int counter = 0; counter <= input.length(); counter++) {
                if (counter == input.length()) {
                    int p = Integer.parseInt("0220E", 16);
                    compressedString += Character.toString((char)p);
                    prevWord = "";
                    continue;
                }
                word += String.valueOf(input.charAt(counter));
                if (word.contains(" ") || word.contains(newline)) {
                    if (!printed) {
                        code = isPresent(prevWord);
                        if (code >= 0) {
                            compressedString += code;
                        } else {
                            compressedString += prevWord;
                        }
                    }
                    compressedString += " ";
                    prevWord = "";
                    word = "";
                    printed = false;
                    continue;
                }
                prevWord += word;
                code = isPresent(prevWord);
                if (code < 0) {
                    compressedString += word;
                    add(prevWord);
                    word = "";
                    printed = true;
                }
            }
        }
        System.out.println(compressedString);
    }

    public static void main(String[] args) throws IOException {
        int p = Integer.parseInt("E2888E", 16);
//        System.out.println(Character.toString((char)p));
//        OutputStream writer = new FileOutputStream(new File("C:\\Users\\Pratik\\Documents\\GitHub\\AOOP\\Homework_7\\src\\myFile2.txt"));
//        writer.write("pppprrrr".getBytes());
//        writer.write("\n".getBytes());
//        System.exit(0);
        File f = new File("C:\\Users\\Pratik\\Documents\\GitHub\\AOOP\\Homework_7\\src\\myFile.txt");
        new Compression().compress1(f);
    }


    public void compress1(File file) throws IOException {
        int counter = 0;
        String compressedString = "";
        String w = "";
        String k;
        int code;
        boolean printed = false;
        String input="";
        FileReader fileReader = new FileReader(file);
        BufferedReader reader = new BufferedReader(fileReader);

        while (counter < 25010 && ((input = reader.readLine()) != null)) {
            for (int index = 0; index <= input.length(); index++) {
                if (index == input.length()) {
                    compressedString += "\n";
                    w = "";
                    continue;
                }
                k = String.valueOf(input.charAt(index));
                if (k.equals(" ")) {
                    if (!printed) {
                        if (isPresent(w) >= 0) {
                            compressedString += isPresent(w);
                        } else {
                            compressedString += w;
                        }
                    }
                    compressedString += " ";
                    w = "";
                    k = "";
                    printed = false;
                    continue;
                }
                if(isPresent(w + k) >= 0) {
                    w += k;
                    continue;
                } else {
                    if (!printed) {
                        compressedString += w;
                    }
                    add(w+k);
                    w = w+k;
                    compressedString += k;
                    printed = true;
                }
            }
            counter++;
        }
        OutputStream writer = new FileOutputStream(new File("C:\\Users\\Pratik\\Documents\\GitHub\\AOOP\\Homework_7\\src\\myFile2.txt"));
        byte buffer2[] = compressedString.getBytes();
        writer.write(buffer2);
    }
}
