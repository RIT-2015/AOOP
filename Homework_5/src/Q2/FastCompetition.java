package Q2;



public class FastCompetition<E> implements Competition<E> {

    public Node startStorage;
    public static int countStorage;
    public final int MAX_STORAGE;
    public FastCompetition() {
        startStorage = new Node(null);
        countStorage = 0;
        MAX_STORAGE = 1000;
    }
    public FastCompetition(int max){
        MAX_STORAGE=max;
        startStorage = new Node(null);
    }

    public String toString(){
        Node currentStorage = startStorage;
        String storageString ="";
        while(currentStorage.next!=null){
            currentStorage=currentStorage.nextElement();
            storageString = storageString + currentStorage.value+" ";
        }

        return storageString;
    }


    public boolean add(E e) {
        if(countStorage > MAX_STORAGE){
            return false;
        }
        else{
            Node tempStorage = new Node(e);
            Node currentStorage = startStorage;
            while(currentStorage.nextElement()!=null){

                currentStorage = currentStorage.nextElement();
            }
            currentStorage.setNextElement(tempStorage);
            countStorage++;
            return true;
        }
    }


    public boolean contains(Object o) {
        if (startStorage.nextElement() == null) {
            return false;
        }
        Node currentStorage = startStorage.nextElement();
        while(currentStorage.value!=null){
            if((currentStorage.value).equals(o)){
                return true;
            }
            currentStorage=currentStorage.nextElement();
            if (currentStorage == null) {
                return false;
            }
        }
        return false;
    }


    public boolean remove(Object o) {
        Node tempStorage = startStorage;
        Node currentStorage = startStorage.nextElement();
        while(tempStorage.next!=null){
            if((currentStorage.value).equals(o)){
                tempStorage.next=currentStorage.next;
                countStorage--;
                return true;
            }
            currentStorage=currentStorage.nextElement();
            tempStorage=tempStorage.nextElement();
        }
        return false;
    }


    public E elementAt(int index) {
        int storageCounter = 0 ;
        Node currentStorage = startStorage;
        while(storageCounter <= index){
            currentStorage=currentStorage.nextElement();
            storageCounter++;
        }
        return currentStorage.value;
    }

    @SuppressWarnings("unchecked")
    public Competition<E> sort() {

        Node currentStorage = startStorage.nextElement();
        String[] unsorted = new String[countStorage];
        for(int counter=0;counter<countStorage;counter++){
            unsorted[counter]=currentStorage.value.toString();
            currentStorage=currentStorage.nextElement();
        }
//
//        for(int outer=0;outer<countStorage - 1;outer++){
//            for(int inner=outer + 1;inner<countStorage;inner++){
//                if(unsorted[inner].compareTo(unsorted[outer]) < 0){
//                    String tempString = unsorted[outer];
//                    unsorted[outer]=unsorted[inner];
//                    unsorted[inner]=tempString;
//                }
//            }
//        }


        mergeSort(unsorted,0,countStorage-1);

        int oldCount = countStorage;
        //FastCompetition<E> myStorageString = new FastCompetition<E>();
        this.startStorage = new Node(null);
        countStorage = 0;
        for(int counter=0; counter<oldCount;counter++){
            this.add((E) unsorted[counter]);
        }
        return this;
    }

    public void mergeSort(String[] unsorted, int leftStorage, int rightStorage){
        if(leftStorage<rightStorage){
            int centerStorage = (leftStorage+rightStorage)/2;
            mergeSort(unsorted, leftStorage, centerStorage);
            mergeSort(unsorted, centerStorage+1, rightStorage);
            merge(unsorted,leftStorage,centerStorage,rightStorage);
        }
    }

    public void merge(String[] unsorted,int left, int middle, int right){
        String[] tempString=new String[countStorage];
        for(int counter=0;counter<countStorage;counter++){
            tempString[counter]=unsorted[counter];
        }
        int min=left, min2=left, center=middle+1;
        while(min<=middle && center<=right){
            if(tempString[min].compareTo(tempString[center])<0){
                unsorted[min2]=tempString[min];
                min++;
            }
            else{
                unsorted[min2]=tempString[center];
                center++;
            }
            min2++;
        }

        while(min<=middle){
            unsorted[min2]=tempString[min];
            min++;
            min2++;
        }
    }

    public int size() {
        return countStorage;
    }

    public class Node {
        public E value;
        public Node next;

        public Node(E value, Node next){
            this.next=next;
            this.value=value;
        }
        public Node(E value){
            next=null;
            this.value=value;
        }
        public Node nextElement(){
            return next;
        }
        public void setNextElement(Node next){
            this.next=next;
        }
    }

    private void clear() {
        startStorage = null;
        countStorage = 0;
    }

    public static void main(String[] args){
        try{
            FastCompetition<String> aStorageString = new FastCompetition<String>();
            aStorageString.add("dapil");
            aStorageString.add("aratik");
            aStorageString.add("cshan");
            System.out.println(aStorageString);
            System.out.println(aStorageString.contains("kapil"));
            aStorageString.remove("aratik");
            //System.out.println(aStorageString);
            System.out.println(aStorageString.sort());
        }
        catch(NullPointerException e){
            System.out.println("Storage is empty.");
        }
    }
}

