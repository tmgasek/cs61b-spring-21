package gitlet;

import java.io.Serializable;

public class Blob implements Serializable {
    private String filename;
    private byte[] content;

    public Blob(String filename, byte[] content) {
        this.filename = filename;
        this.content = content;
    }

    public String getFilename() {
        return filename;
    }

    public byte[] getContent() {
        return content;
    }
}
