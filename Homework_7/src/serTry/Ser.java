package serTry;

import java.io.*;

/**
 * Created by Pratik on 10/8/2015.
 */
class Ser {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        trySer ser = new trySer();
        ser.setA("Hello");
        ser.setB(5);
        File file1 = new File("ser.txt");
        FileOutputStream fileWriter = new FileOutputStream(file1);
        ObjectOutputStream out = new ObjectOutputStream(fileWriter);
        out.writeObject(ser);
    }
}
