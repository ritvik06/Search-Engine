import java.util.*;

public class WordEntry{
	private String word;
	private float count;

	MyLinkedList<Position> listPos;	

	 WordEntry(String Word){
		this.word = Word;
		listPos = new MyLinkedList<Position>();	
	}

	 void addPosition(Position position){
		listPos.addRear(position);
		return;
	}

	 String getWord(){
		return word;
	}

	 void addPositions(MyLinkedList<Position> positions){
		positions.union(listPos);
	}

	MyLinkedList<Position> getAllPositionsForThisWord(){
		return listPos;
	}

	float getTermFrequency(String word){
		return count;
	}

   public Node<WordEntry> wordSearch(MyLinkedList<WordEntry> list){
    
    	if(list.head==null){
    	//	System.out.println("head is null");
    		return null;
    	}

    	Node<WordEntry> n = list.head;

    	while(n!=null && n.value.getWord().equals(this.word)!=true){
    	//	System.out.println("Searching for " + this.word + " currently at " + n.value.getWord());    		
    		n = n.next;
    	}

    	return n;

    }

}