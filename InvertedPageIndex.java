import java.util.*;

public class InvertedPageIndex
{
    MyHashTable hashTable;

    public InvertedPageIndex(){
        hashTable = new MyHashTable();
    }

    public void addPage(PageEntry p)
    {
        MyLinkedList<WordEntry> wordList = p.getPageIndex().getWordEntries();
        Node<WordEntry> node = wordList.head;

        while(node != null)
        {
            hashTable.addPositionsForWord(node.value);
            node = node.next;
        }
    }


    public MySet<PageEntry> getPagesWhichContainWord(String str)
    {
        Hnode word = hashTable.getPosForWord(str);

       if(word==null){
        	return null;
        }

          	
            
        	
        	//System.out.println("word is not null");
	        MySet<PageEntry> entrySet = new MySet<PageEntry>();

	       // System.out.println(word.getWord());

	        Node<Position> node = word.getAllPositionsForThisWord().head;

	        if(node==null){
	        	System.out.println("Node is null");
	        }

	        while(node != null){
	        	//System.out.print(node.value.getPageEntry().pageName() + "--");
	            entrySet.addRear(node.value.getPageEntry());
	            node = node.next;
	        }
	       // System.out.println();
	       // System.out.println("Gone ahead of the loop");
	       	
	        if(entrySet.head==null)
	        	System.out.println("entrySet is null");
	        else
	       	 	//System.out.println(entrySet.head.value.pageName());
	        

	      /*  Node<PageEntry> pageNode = entrySet.head;

	        System.out.println("pageNode- " + pageNode.value.pageName());

	        while(pageNode!=null){
	        	System.out.print(pageNode.value.pageName() + " ");
	        	pageNode = pageNode.next;
	        }*/

	        return entrySet;
       
       

        return null;
    }


}