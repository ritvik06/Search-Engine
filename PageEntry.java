import java.util.*;

public class PageEntry{
	private String pageName;
	private PageIndex index;

	PageEntry(String pageName){
		this.pageName = pageName;
		this.index = new PageIndex();
	}

	PageIndex getPageIndex(){
		return index;
	}

	String pageName(){
		return pageName;
	}

	void setPageIndex(PageIndex index){
		this.index = index;
	}

   public Node<PageEntry> entrySearch(MyLinkedList<PageEntry> list){
    
    	if(list.head==null){
    	//	System.out.println("head is null");
    		return null;
    	}

    	Node<PageEntry> n = list.head;

    	while(n!=null && n.value.pageName().equals(this.pageName)!=true){
    		//System.out.println("Searching for " + this.word + " currently at " + n.value.getWord());    		
    		n = n.next;
    	}

    	return n;

    }

}
