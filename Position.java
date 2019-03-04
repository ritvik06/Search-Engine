import java.util.*;

public class Position{
	PageEntry p;
	private int wordIndex;
	private int count;

	 Position(PageEntry p,int wordIndex,int count){
		this.p = p;
		this.wordIndex = wordIndex;
		this.count = count;
	}

	 PageEntry getPageEntry(){
		return p;
	}

	public int wordIndex(){
		return wordIndex;
	}

	public int getCount(){
		return count;
	}
	MyLinkedList<Position> union(MyLinkedList<Position> firstSet, MyLinkedList<Position> otherSet){
		Node<Position> n1 = firstSet.head;
		Node<Position> n2 = otherSet.head;

		if(n2==null){
			if(n1==null){
				return null;
			}
			else{
				//System.out.println("*");
				MyLinkedList<Position> newSet = new MyLinkedList<Position>();
				while(n1!=null){
					newSet.addRear(n1.value);
					n1 = n1.next;
				}
				//System.out.println(newSet.head.value.wordIndex());

				return newSet;
			}
		}

		while(n2.next!=null){
			n2 = n2.next;
		}
		n2.next = n1;

		return otherSet;
	}


}
