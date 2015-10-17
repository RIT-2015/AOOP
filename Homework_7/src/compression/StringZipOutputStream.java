package compression;

import java.io.IOException;
import java.io.OutputStream;

public class StringZipOutputStream	{

    private OutputStream writer;
    private String compressedString;
    // Creates a new output stream with a default buffer size.
    public StringZipOutputStream(OutputStream out)	{
        this.writer = out;
    }
    // Writes aStrign compressed output stream. This method will block until all data is written.
    public void write(String aString) throws IOException {
        compressedString = compress(aString);
        this.writer.write(compressedString.getBytes());
    }
    // Writes remaining data to the output stream and closes the underlying stream.
    public void close() throws IOException {
        writer.close();
    }
}
