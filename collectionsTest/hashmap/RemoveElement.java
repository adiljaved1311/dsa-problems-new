package collectionsTest.hashmap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

// how we can remove the element from a hashmap while iterating over it
public class RemoveElement {
    public static void main(String[] args) {
        HashMap<String,String> phoneBook = new HashMap();
        phoneBook.put("Adil","8130768428");
        phoneBook.put("Kundan","8130146410");

        Iterator itr = phoneBook.entrySet().iterator();
        while (itr.hasNext()){
            Map.Entry current = (Map.Entry) itr.next();
            if(current.getKey().equals("Dubey")){
                itr.remove(); // this will remove the current entry
            }
        }
        System.out.println(phoneBook.toString());
    }
}
