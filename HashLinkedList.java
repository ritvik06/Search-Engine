import java.util.*;

public class HashLinkedList{
	public Hnode head;

	public HashLinkedList()
	{
		head = null;
	}





	public void addRear(Hnode a){ 
		Hnode n = head;
		Hnode n1 = a;

		if(n==null){
			head = n1;
			return;
		}

		while(n.next!=null){
			if(n.getWord()==a.getWord()){
				return;
			}

			n = n.next;
		}

		n.next = n1;

	}



}
