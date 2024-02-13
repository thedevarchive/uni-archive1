import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class BTreeManager
{
    //declare necessary variables
    private RandomAccessFile raf; 
    private long numRecords;
    private long root; 

    //declare finals
    private static final long START = 0L; 
    private static final long REC_START = 8L; 
    private static final String MODE = "rwd"; 
    private static final int DATA = 5; 
    private static final int NODELEN = 14; 
    public static final long NULLONG = -1L;
    private static final String ERR = "ERROR: ";

    public BTreeManager(String filename) throws IOException
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
            root = raf.readLong(); 
        }
        else 
        {
            numRecords = 1L; 
            root = START; 

            raf.writeLong(numRecords); 
            raf.writeLong(root);
            for(int i = 0; i < BTreeNode.NODELEN; i++) raf.writeLong(NULLONG); 
        }
    }

    //insert key and value into the node
    //if the given key exists, an error message is printed out instead. 
    public void insert(long key, long value) throws IOException
    {
        BTreeNode btn = getNode(); 

        if(btn.getOffsetValue(key) != btn.NULLONG)
        {
            System.out.println(ERR + key + " already exists."); 
        }
        else
        {
            btn.insert(key, value); 
            writeNode(btn, 0L); 
            System.out.println(key + " inserted."); 
        }
    }

    //makes a new instance of BTreeNode
    public BTreeNode getNode() throws IOException
    {
        raf.seek(REC_START); 
        long l = raf.readLong(); 

        int len = BTreeNode.NODELEN; 
        long[] arr = new long[len]; 
        for(int i = 0; i < arr.length; i++) arr[i] = raf.readLong(); 

        return new BTreeNode(arr); 
    }

    //get offset value of node (position of node in data.val/specified args[1] filename)
    public long getOffsetValue(long l) throws IOException
    {
        BTreeNode b = getNode(); 
        return b.getOffsetValue(l); 
    }

    //write additional data into node
    public void writeNode(BTreeNode b, long l) throws IOException
    {
        long[] arr = b.getData(); 
        l = 16L + l * 14L * 8L; 
        raf.seek(l); 

        for(int i = 0; i < NODELEN; i++) raf.writeLong(arr[i]); 
    }

    //returns true if the specified key exists in a node
    public boolean hasKey(long l) throws IOException
    {
        BTreeNode btn = getNode();
        return btn.getOffsetValue(l) != BTreeNode.NULLONG; 
    }

    //close random access file
    public void close() throws IOException
    {
        raf.seek(START); 
        raf.writeLong(numRecords); 
        raf.writeLong(root); 
        raf.close(); 
    }
}