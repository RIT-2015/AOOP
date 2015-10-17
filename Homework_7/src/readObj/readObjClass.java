package readObj;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by Pratik on 10/10/2015.
 */
class readObjClass {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file1 = new File("ser.txt");
        FileInputStream fileReader = new FileInputStream(file1);
        ObjectInputStream input = new ObjectInputStream(fileReader);
        Object ser2 = input.readObject();
        System.out.println(ser2);
    }
}
