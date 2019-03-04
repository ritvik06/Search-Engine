import java.util.*;

public class Hnode{
	private String word;
	private MyLinkedList<Position> position;
	Hnode next;

	public Hnode(String word){
		this.word = word;
		this.position = new MyLinkedList<Position>();
		this.next=null;
	}

	void addPosition(Position pos){
		position.addRear(pos);	
	}

	void addPositions(MyLinkedList<Position> positions){
		position = union(positions,position);
	}

	String getWord(){
		return word;
	}

	MyLinkedList<Position> getAllPositionsForThisWord(){
		//System.out.print("Printing position- ");

		Node<Position> n = position.head;

	//	while(n!=null){
		//	System.out.print(n.value.getPageEntry().pageName() + " ");
		//	n = n.next;
		//}
		//System.out.println();

		return position;
	}
   public Hnode hashSearch(HashLinkedList list){
    
    	if(list.head==null){
    	//	System.out.println("head is null");
    		return null;
    	}

    	Hnode n = list.head;

    	while(n!=null && n.word.equals(this.word)!=true){
    		//System.out.println("Searching for " + this.word + " currently at " + n.value.getWord());    		
    		n = n.next;
    	}

    	return n;

    }

	MyLinkedList<Position> union(MyLinkedList<Position> firstSet, MyLinkedList<Position> otherSet){
		Node<Position> n1 = firstSet.head;
		Node<Position> n2 = otherSet.head;

		if(n2==null){
			if(n1==null){
				return null;
			}
			else{
				//System.out.print("1 ");
				MyLinkedList<Position> newSet = new MyLinkedList<Position>();
				while(n1!=null){
					newSet.addRear(n1.value);
					n1 = n1.next;
				}
			//	System.out.println(newSet.head.value.getPageEntry().pageName());

				return newSet;
			}
		}

		while(n2!=null){
			//System.out.print("2 ");
			if(firstSet.isMember(n2.value)){
				System.out.println("Is Member invoked");
				otherSet.delete(n2.value);
				n2 = n2.next;
			}	
			n2 = n2.next;
		}
		
		n2 = n1;

		return otherSet;
	}


}