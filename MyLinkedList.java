import java.util.*;

public class MyLinkedList<E>{
	public Node<E> head;
	p

	public MyLinkedList()
	{
		head = null;
	}

	MyLinkedList<E> union(MyLinkedList<E> otherSet){
		Node<E> n1 = head;
		Node<E> n2 = otherSet.head;

		if(n2==null){
			if(n1==null){
				return null;
			}
			else{
				MyLinkedList<E> newSet = new MyLinkedList<E>();
				while(n1!=null){
					newSet.addRear(n1.value);
					n1 = n1.next;
				}
				return newSet;
			}
		}

		while(n2.next!=null){
			n2 = n2.next;
		}
		n2.next = n1;

		return otherSet;
	}

	public Boolean isEmpty(){
		if(head==null){
			return true;
		}
		else{
			return false;
		}
	}

	public int size(){
		int count =0;
		Node<E> n1 = head;

		if(n1==null){
			return count;
		}
		count = 1;
		while(n1.next!=null){
			n1 = n1.next;
			count ++;

		}
		return count;
	}

	public void addRear(E a){ 
		Node<E> n = head;
		Node<E> n1 = new Node<E>(a);

		if(n==null){
			head = n1;
			return;
		}

		while(n.next!=null){
			if(n.value==a){
				return;
			}

			n = n.next;
		}

		n.next = n1;

	}
	public void delete(E a)// throws ElementDoesNotExist
	{
		Node<E> n = head;
		Node<E> prev = head;
		
		if(n==null){
			return;
		}

		while(n.value!=a && n!=null){
			prev = n;
			n = n.next;
		}

		if(n==null){
			return;
		}

		prev.next = n.next;

	}
	 public Node<E> readFront(){
	 	return head;
	 }

	 public Boolean isMember(E a){
	 	if(head==null){
	 		return false;
	 	}
	 	Node<E> n = head;

	 	while(n.value!=a && n.next!=null){
	 		n = n.next;
	 	}

	 	if(n.next==null){
	 		//throw error	 	
	 		return false;
	 	}
	 	else{
	 		return true;
	 	}

	 }	

   	public void printList() 
    { 
        Node<E> tnode = head; 
        while (tnode != null) 
        { 
            System.out.print(tnode.value+" "); 
            tnode = tnode.next; 

        } 
    }
    public  Node<E> search(E value)
    {
    	if(head==null){
    		//System.out.println("head is null");
    		return null;
    	}

        Node<E> n = head;
        
        while(n != null && value.equals(n.value)!=true)
        {
            n = n.next;
        }
        return n;
    }


}




        // System.out.println("Entered get Positions");
        
        // MyLinkedList<Position>.Node node = position.head();
        // while(node!=null && !position.isMember(node.data)){
            // System.out.print(node.data.getPageEntry().pageName() + " ");
            // node = node.next;