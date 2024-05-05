package IMS;

import java.io.*;

public class MyObjectOutputStream extends ObjectOutputStream implements Serializable {
    
    public MyObjectOutputStream() throws IOException{
        super();
    }
    public MyObjectOutputStream(OutputStream o) throws IOException{
        super(o);
    }
    public void writeStreamHeader(){}
    
}
