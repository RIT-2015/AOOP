import java.util.Random;

/**
 * Created by Pratik on 9/28/2015.
 */
public class StorageDynamicTest {
    Storage<String, String> aDynamicStorageString = new StorageDynamic<>();
    Storage<Integer, String> aDynamicStorageInteger = new StorageDynamic<>();

    public void addTest(){
        for (int index = 0; index <= 25; index++) {
            aDynamicStorageString.add("String " + index + " part 0");
            aDynamicStorageString.addElement("String " + index + " part 1");
            aDynamicStorageString.add(index + 1, "String " + index + " part 2");
            aDynamicStorageString.addElement("String " + index + " part 3", "String " + index + " part 3");
        }

        if (aDynamicStorageString.add("100")) {
            System.out.println("addTest successful for aDynamicStorageString.");
        } else {
            System.out.println("addTest Failed!");
        }
        for (int index = 0; index <= 99; index += 4) {
            aDynamicStorageInteger.add(index);
            aDynamicStorageInteger.addElement(index + 1);
            aDynamicStorageInteger.add(index + 1, index + 2);
            aDynamicStorageInteger.addElement(index + 3, String.valueOf(index + 3));
        }
        if (aDynamicStorageInteger.add(100)) {
            System.out.println("addTest successful for aDynamicStorageInteger.");
        } else {
            System.out.println("addTest Failed!");
        }
    }

    public void testClearAndCapacity() {
        System.out.println("Before clear() \nDynamic Storage capacity: " + aDynamicStorageString.capacity());
        aDynamicStorageString.clear();
        System.out.println("After clear() \nDynamic Storage capacity: " + aDynamicStorageString.capacity());
        if (aDynamicStorageString.capacity() == 0) {
            System.out.println("testClearAndCapacity successful for aDynamicStorageString.");
        } else {
            System.out.println("testClearAndCapacity failed for aDynamicStorageString.");
        }

        System.out.println("Before clear() \nDynamic Storage capacity: " + aDynamicStorageInteger.capacity());
        aDynamicStorageInteger.clear();
        System.out.println("After clear() \nDynamic Storage capacity: " + aDynamicStorageInteger.capacity());
        if (aDynamicStorageInteger.capacity() == 0) {
            System.out.println("testClearAndCapacity successful for aDynamicStorageInteger.");
        } else {
            System.out.println("testClearAndCapacity failed for aDynamicStorageInteger.");
        }
    }

    public void testFirstGetLast() {
        int index = 57;
        boolean first = aDynamicStorageString.firstElement().equals("String 0 part 0");
        boolean get = aDynamicStorageString.get(index).equals("String 10 part 1");
        boolean last = aDynamicStorageString.lastElement().equals("100");
        if (first && get && last) {
            System.out.println("testFirstGetLast successful for aDynamicStorageString.");
        } else {
            System.out.println("testFirstGetLast failed for aDynamicStorageString.");
        }

        first = aDynamicStorageInteger.firstElement() == 0;
        get = aDynamicStorageInteger.get(index) == 58;
        last = aDynamicStorageInteger.lastElement() == 100;
        if (first && get && last) {
            System.out.println("testFirstGetLast successful for aDynamicStorageInteger.");
        } else {
            System.out.println("testFirstGetLast failed for aDynamicStorageInteger.");
        }
    }

    @SuppressWarnings("unchecked")
    public void testClone() {
        Storage<String, String> newStorageString = (Storage<String, String>) aDynamicStorageString.clone();
        Storage<Integer, String> newStorageInteger = (Storage<Integer, String>) aDynamicStorageInteger.clone();
        boolean first,  get, last;
        int randomInt = new Random().nextInt(100);

        first = aDynamicStorageString.firstElement().equals(newStorageString.firstElement());
        last = aDynamicStorageString.lastElement().equals(newStorageString.lastElement());
        get = aDynamicStorageString.get(randomInt).equals(newStorageString.get(randomInt));
        if (first && get && last) {
            System.out.println("testClone successful for aDynamicStorageString.");
        } else {
            System.out.println("testClone failed for aDynamicStorageString.");
        }

        first = aDynamicStorageInteger.firstElement().equals(newStorageInteger.firstElement());
        last = aDynamicStorageInteger.lastElement().equals(newStorageInteger.lastElement());
        get = aDynamicStorageInteger.get(randomInt).equals(newStorageInteger.get(randomInt));
        if (first && get && last) {
            System.out.println("testClone successful for aDynamicStorageInteger.");
        } else {
            System.out.println("testClone failed for aDynamicStorageInteger.");
        }

    }

    public static void main(String args[])	{
        StorageDynamicTest storageTest = new StorageDynamicTest();
        storageTest.addTest();
        storageTest.testFirstGetLast();
        storageTest.testClone();
        storageTest.testClearAndCapacity();

    }
}
