public class MyHashTable
{
    private int Size;

    private HashLinkedList[] hashArray;

    public MyHashTable()
    {
        Size = 5000;
        hashArray = new HashLinkedList[Size];
    }

    private int getHashIndex(String str)
    {
        int code = str.hashCode();
        if(code < 0)
        {
            return (Integer.MAX_VALUE + code)%Size;
        }
        else
        {
            return code%Size;
        }
    }

    public void addPositionsForWord(WordEntry w)
    {
        //System.out.println("entered hash table");
        int index = getHashIndex(w.getWord());
      //  System.out.println(index);
        Hnode word = new Hnode(w.getWord());
       // System.out.println(word.getWord());
        word.addPositions(w.getAllPositionsForThisWord());

        if (hashArray[index] == null)
        {

            hashArray[index] = new HashLinkedList();
            hashArray[index].addRear(word);
            
        }
        else
        {
            try
            {
                Hnode newWord = new Hnode(w.getWord());
                
                Hnode node = newWord.hashSearch(hashArray[index]);

                node.addPositions(w.getAllPositionsForThisWord());
            }
            catch(NullPointerException e)
            {

                hashArray[index].addRear(word);
                
            }
        }
    }

    public Hnode getPosForWord(String word)
    {
        int index = getHashIndex(word);
       // System.out.println(index);

        if(hashArray[index] != null)
        {
            try
            {
                Hnode node = (new Hnode(word)).hashSearch(hashArray[index]);
                return node;
            }
            catch(NullPointerException e)
            {
            }
        }
        return null;
    }
}