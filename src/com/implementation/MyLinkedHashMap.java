package com.implementation;

/** A class that gives basic implementataion of LinkedHashMap
 * 
 * @author Neo
 *
 */
public class MyLinkedHashMap {
	
 private DLinkedList head;
 private DLinkedList tail;

 /*Constructor to initialize head and tail of Linked list
  * My Head and Tail are always fixed (Sentinel Nodes: One way of implementing Doubly Linked List)
  *  Another way is Head and tail are always changing as per insertion and deletion 
  * */
 public MyLinkedHashMap(){
	 head = new DLinkedList(null,null);
	 tail = new DLinkedList(null,null);
	 head.next=tail;
	 tail.prev=head;	 
 }

 /*
  * Calculating the Hashcode of the key
  * though not optimised
  * */
 public  Long hashCode(String key) {
	final int prime = 31;
	Long result = (long) 1;
	for(char c: key.toCharArray()){
		result= result +(int)c;
	}
	result = (result )/key.length();
	return result;
}

 /*
  * Put method of the LinkedHashMap
  * To store the key value pair
  * */
 public boolean put(String key, String value){
	 Long hcode = hashCode(key);
	// System.out.println("HashCode value during put: "+key+" "+hcode);
	 Map m = new Map(key,value);
	 if(add(m,hcode))
		 return true;
	 else
		 return false;
}
 /* Method to return the value to which the key is associated 
  * 
  * */
 public String get(String key){
	 String value= search(key);
	 System.out.println("returned value from search: "+ value);
	 return value;
	 
 }
 /* Searching the key in LinkedList
  * 
  * */
 public String search(String key){
	 String value="";
	 Long hcode = hashCode(key);
//	 System.out.println("HashCode value during get: "+key+" "+hcode);
	 DLinkedList temp= head.next;
	 while(temp.next != null){
		 if(temp.hCodeVal.equals(hcode)){
			 Map m= temp.map;
			 if(key.equals(m.getKey())){
				 value = m.getValue();	
				 break;
			 }else{
				 value="Key not found";
			 }
		 	}else{
		 		value= "key not available";
		 	}
		 temp=temp.next;
	 }
	 return value;
 }
 /*
  * Bug is that it removes all the elements 
  * available before the key which is being removed
  * 
 public String remove(String key){
	 String value= "";
	 Long hcode = hashCode(key);
	 DLinkedList temp= head.next;
	 while(temp.next != null){
		 if(temp.hCodeVal.equals(hcode)){
			 Map m= temp.map;
			 if(key.equals(m.getKey())){
				 value=m.getValue();
				 temp.prev.next=temp.next;
				 temp.next.prev=temp.prev;
				 break;
			 }
		 }else{
			 value= "key not available";
		 }
		 temp=temp.next;
	 }
	 System.out.println("Removed key is "+key+" and value is "+value);
	 return value;
}
 */
 // In what situation it will return false
 public boolean add (Map m, Long hcode ) {
	 DLinkedList dll = new DLinkedList(m,hcode);
	if(head.next==tail){
		head.next=dll;
		dll.next=tail;
		tail.prev=dll;
		dll.prev=head;
		
		return true;
	}else{
		DLinkedList temp= head;
		while(temp.next!=tail){
			temp=temp.next;
		}
		temp.next=dll;
		dll.next=tail;
		tail.prev= dll;
		dll.prev = head;
		
		return true;
	}	
		
	}

 /* printing the Doubly linked List
  * 
  * */
	public void printDlls(){
		DLinkedList temp= head;
		while(temp.next!=tail){
			temp=temp.next;
			Map m= temp.map;
			String k= m.getKey();
			String val= m.getValue();
			System.out.println(" Key "+k +" Value "+val);
			
		}
	}
public static void main(String[] args) {
	MyLinkedHashMap lhmap = new MyLinkedHashMap();
	lhmap.put("Neo", "ps");
	lhmap.put("ps", "npm");
	lhmap.put("Angular", "node");
	lhmap.put("Javascript", "Async");
	lhmap.put("12", "Neo");
	lhmap.printDlls();
	lhmap.get("Neo");
	lhmap.get("NEO");
	lhmap.get("12");
	lhmap.get("21");
	lhmap.get("Pya");
//  lhmap.remove("12");
//	lhmap.remove("Pya");
	lhmap.printDlls();
}	
}

/*A class to store Map objects
 * */
class Map{
	String key;
	String value;
	
	public Map(String key, String val){
		this.key=key;
		this.value=val;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
/*
 * Doubly LinkedList to store Map objects in insertion order
 * */
class DLinkedList{
	
	Map map;
	Long hCodeVal;
	DLinkedList next;
	DLinkedList prev;
	
	public DLinkedList(Map m, Long hcode){
		this.map=m;
		this.hCodeVal=hcode;
	}
}