public class BTreeNode
{
    //max keys in btree
    public static final int MAX_DATA= 5; 
    //no of data in node
    public static final int NODELEN = 3 * MAX_DATA - 1; 
    //points at 1st key
    public static final int START = 2; 
    //incrementer to skip to the next key
    public static final int INC = 3; 
    //placeholder for empty data
    public static final long NULLONG = -1L; 
    //contains node data
    private long[] data; 

    //constructor for the node. 
    BTreeNode(long[] d)
    {
        data = d; 
    }

    //returns the offset value of given key
    //return NULLONG if key does not exist
    public long getOffsetValue(long l)
    {
        for(int i = START; i < NODELEN; i += INC) if(l == data[i]) return data[i + 1]; 
        return NULLONG; 
    }

    //checks if node is full
    public boolean isFull()
    {
        return data[NODELEN - 2] != NULLONG; 
    }

    //inserts key and offset into node
    public void insert(long key, long offset)
    {
        for(int i = START; i < NODELEN; i += INC)
        {
            long temp = data[i]; 

            //if an empty entry exists, overwrite it
            if(data[i + 1] == NULLONG)
            {
                data[i] = key; 
                data[i + 1] = offset; 
                break; 
            }

            //if the key in the current iteration is greater than the key to be inserted
            //make a vacant data slot for the key to be inserted
            //move the stored data's key, offset, and children
            if(temp > key)
            {
                long k = data[i]; 
                long o = data[i + 1]; 
                long c = data[i + 2];
                i += INC; 

                while(i < NODELEN && data[i + 1] != NULLONG)
                {
                    long tempK = data[i]; 
                    long tempO = data[i + 1]; 
                    long tempC = data[i + 2]; 

                    data[i] = k; 
                    data[i + 1] = o; 
                    data[i + 2] = c; 

                    k = tempK; 
                    o = tempO; 
                    c = tempC; 

                    i += INC; 
                }

                if(i >= NODELEN) break; 
                data[i] = k; 
                data[i + 1] = o; 
                data[i + 2] = c; 
                break; 
            }

        }
    }

    //return data in node
    public long[] getData()
    {
        return data; 
    }
}