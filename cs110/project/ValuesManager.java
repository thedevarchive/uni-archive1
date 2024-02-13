import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ValuesManager
{
    //declare variables
    private RandomAccessFile raf; 
    private long numRecords; 

    //initialize finals 
    private static final String MODE = "rwd"; 
    private static final long REC_START = 8L; 
    private static final long START = 0L; 
    private static final long SIZE = 256L; 

    //constructor for valuesmanager
    public ValuesManager(String filename) throws IOException
    {
        //check if file exists
        File f = new File(filename); 
        boolean check = f.exists(); 

        //create random access file
        raf = new RandomAccessFile(filename, MODE); 

        //if the given filename exists, read the number of records in that file
        //if not, give the file the starting number of records
        if (check)
        {
            raf.seek(START); 
            numRecords = raf.readLong(); 
        }
        else numRecords = START; 
    }

    //write string and its length in bytes
    //update number of records
    //return number of records - 1
    public long insert(String s) throws IOException
    {
        int i = s.length(); 
        raf.seek(numRecords * SIZE + REC_START); 
        raf.writeByte(i);
        raf.writeBytes(s);  

        numRecords = 1L; 
        raf.seek(START); 
        raf.writeLong(numRecords); 

        return numRecords - 1L;
    }

    //close file
    public void close() throws IOException
    {
        raf.seek(START); 
        raf.writeLong(numRecords); 
        raf.close(); 
    }


    public void update(long l, String s) throws IOException
    {
        int i = (byte) s.length(); 
        raf.seek(l * 256L + 8L); 
        raf.writeByte(i);
        raf.write(s.getBytes("UTF8")); 
    }

    public String getVal(long l) throws IOException
    {
        if(l >= numRecords) return null; 
        raf.seek(l * 256L + 8L); 
        int i = raf.readByte(); 
        byte[] arr = new byte[i]; 
        raf.read(arr); 
        return new String(arr, "UTF8"); 
    }
}