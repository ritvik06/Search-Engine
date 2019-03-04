import java.util.*;
import java.io.*;

public class SearchEngine{
	private InvertedPageIndex wordList;
	private MyLinkedList<PageEntry> pageList;

	public SearchEngine(){
		wordList = new InvertedPageIndex();
		pageList = new MyLinkedList<PageEntry>();

	}

	public String fixWord(String word){
		String final_word = word.toLowerCase();
        if(word.equals("stacks"))
        {
            final_word = "stack";
        }
        else if(word.equals("structures"))
        {
            final_word = "structure";
        }
        else if(word.equals("applications"))
        {
            final_word = "application";
        }

        return final_word;
	}

	public PageEntry fixPage(String file_name){	
        PageEntry page = new PageEntry(file_name);
        PageIndex index = page.getPageIndex();
        BufferedReader br = null;
        String input;
        String word;
        Scanner line;
        try{
            br = new BufferedReader( new FileReader("./webpages/"+file_name));
            int counter = 1;
            int fakeCounter = 1;
            while((input = br.readLine())!=null)
            {
                input = input.toLowerCase();
                String[] words = input.split("\\s++|\\{|}|<|>|\\(|\\)|\\.|,|;|'|\"|\\?|#|!|-|:");
                int size = words.length;
                for(int i=0;i<size;i++)
                {
                    if(!words[i].equals(""))
                    {
                        words[i] = fixWord(words[i]);

                            index.addPositionForWord(words[i], new Position(page,counter,fakeCounter));
                            fakeCounter++;
                        
                        counter++;
                    }
                }
            }
        }
		catch (IOException e) {
			e.printStackTrace();
		}
        
        finally
        {
            try
            {
                if(br != null)
                {
                    br.close();
                }
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
        }

        return page;



	}


	public void performAction(String actionMessage){
		Scanner input = new Scanner(actionMessage);

		String Action = input.next();
		String pageName;
		String word;
		String pageInput;
		PageEntry page;

		if(Action.equals("addPage")){
			pageName = input.next();
			page = fixPage(pageName);

            System.out.println("Page added is " + pageName );

			pageList.addRear(page);
     /*       Node<PageEntry> node = pageList.head;
            while(node!=null){
                System.out.print(node.value.pageName()+ " ");
                node = node.next;
            }
            System.out.println("");
*/

			wordList.addPage(page);
		}

		else if(Action.equals("queryFindPagesWhichContainWord")){
			word = fixWord(input.next());
			MySet<PageEntry> SetWithWord = wordList.getPagesWhichContainWord(word);

			if(SetWithWord == null){
				System.out.println("No webpage contains  word " + word);
			}
			else{
                int i =0;
                Node<PageEntry> node = SetWithWord.head;
              //  System.out.println("iteration no " + i + "- " + node.value.pageName());
                
                while(node!=null){
                    System.out.println(i);
                    i++;
                    node = node.next;
                }

                //System.out.println("*");
			}

		}

		else if(Action.equals("queryFindPositionsOfWordInAPage")){
			word = fixWord(input.next());
			pageName = input.next();

			PageEntry Name = new PageEntry(pageName);

			page = Name.entrySearch(pageList).value;

           // System.out.println(page.pageName());

			if(page==null){
				System.out.println("No Webpage " + pageName + " found");
			}



			else{
            //    System.out.println("*");
                try{
    				MyLinkedList<WordEntry> wordEntries =  page.getPageIndex().getWordEntries();

                   /* Node<WordEntry> n = wordEntries.head;
                    while(n!=null){
                        System.out.print(n.value.getWord() + " ");
                        n = n.next;
                    }*/


    				Node<WordEntry> Wnode = (new WordEntry(word)).wordSearch(wordEntries);

                    if(Wnode==null){
                        System.out.println("Webpage " + pageName + " does not contain word " + word);
                    }

                    WordEntry findWord = Wnode.value;                    

    				Node<Position> node = findWord.getAllPositionsForThisWord().head;

    				int count = 0;

    				System.out.print("queryFindPositionsOfWordInAPage: ");

    				while(node!=null){
    					if(node.value.getPageEntry().equals(page)){
    						count ++;
    						System.out.print(node.value.wordIndex() + ", ");
    					}
    				}


				if(count==0){
					System.out.println("The word " + word + " does not exist in the page " + pageName);
				}
				else{
					System.out.println("");
				}
            }
            catch(Exception exc){}

			}



		}

	}


}