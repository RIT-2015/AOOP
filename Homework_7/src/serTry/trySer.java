package serTry;

import java.io.Serializable;

/**
 * Created by Pratik on 10/8/2015.
 */
class trySer implements Serializable {
    private String a;
    private int b;

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public String toString() {
        return this.getA();
    }
}
