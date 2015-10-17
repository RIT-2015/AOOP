package compression;

import java.io.*;

public class StringZipInputStream	{

    private InputStream reader;
    private String uncompressedString;
    private String compressedString;
    private String mystirng;
    private int lineSeparator;
    private byte[] buffer = new byte[1024];

    // Creates a new input stream with a default buffer size.
    public StringZipInputStream(InputStream out) throws FileNotFoundException {
        this.reader = out;
    }
    // Reads data into a string. the method will block until some input can be read; otherwise, no bytes are read and null is returned.
    public String read() throws IOException {
        int a = reader.read(buffer, 0, 1024);
        compressedString += String.valueOf(buffer);
//        lineSeparator = compressedString.indexOf("\n");
//        mystirng = compressedString.substring(lineSeparator);
//        compressedString = compressedString.substring(0, lineSeparator);
        uncompressedString = uncompress(compressedString);
//        uncompressedString += "\n";
//
//        compressedString = mystirng;
        return uncompressedString;
    }
    // Closes this input stream and releases any system resources associated with the stream.
    public void close() throws IOException {
        reader.close();
    }
}
