public class MySet<E> extends MyLinkedList<E>{
	MyLinkedList<E> Set;

	public MySet(){
		Set = new MyLinkedList<E>();
	}

	public void addElement(E element){
		Set.addRear(element);
	}

	MySet<E> union(MySet<E> otherSet){
		 Node<E> n1 = head;
		 Node<E> n2 = otherSet.head;

		while(n2.next!=null){
			n2 = n2.next;
		}
		n2.next = n1;

		return otherSet;
	}

	MySet<E> intersection(MySet<E> otherSet){
		Node<E> n = head;

		MySet<E> inter = new MySet<E>();

		Node<E> n2 = inter.head;

		if(otherSet.head==null || n==null){

		}

		while(n.next!=null){
			if(otherSet.isMember(n.value)){
				n2.value = n.value;
				n2 = n2.next;				 
			}
			n = n.next;
		}
	return inter;		
	}
	

}