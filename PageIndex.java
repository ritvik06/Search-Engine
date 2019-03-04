import java.util.*;

public class PageIndex{

	private MyLinkedList<WordEntry> WordList;

	 PageIndex(){
		WordList = new MyLinkedList<WordEntry>();
	}

	void addPositionForWord(String str,Position p){
		Node<WordEntry> node =  null;
		Node<WordEntry> tnode;

    		try{
            	node = (new WordEntry(str)).wordSearch(WordList);	
            	node.value.addPosition(p);
            }
            catch(NullPointerException exc){
            	WordEntry entry = new WordEntry(str);
	            tnode = new Node<WordEntry>(entry);
	            tnode.value.addPosition(p);
	           // System.out.println(tnode.value.getWord());
	            WordList.addRear(tnode.value);
	        }
	}

	MyLinkedList<WordEntry> getWordEntries(){
		return WordList;
	}
}