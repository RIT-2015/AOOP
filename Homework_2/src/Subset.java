/**
 * Created by Pratik on 9/2/2015.
 */
public class Subset {
    public static void main(String[] args) {
        if(args.length == 0) {
            System.out.println("Please enter valid integer");
            System.exit(0);
        }
        int number = Integer.valueOf(args[0]);
        String[] subset = new String[2^number];
        String str = null;
        for(int i = 0; i < number; i++) {
            subset[i] = String.valueOf(i+1);
        }

    }
}
