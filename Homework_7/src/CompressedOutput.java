import java.io.Serializable;

/**
 * Created by Pratik on 10/11/2015.
 */
public class CompressedOutput implements Serializable {
    private String compressedString;

    public void append(String input) {
        this.compressedString += input;
    }

    public String getCompressedString() {
        return compressedString;
    }
}
