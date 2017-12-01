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
  * */
 public void put(String key, String value){
	 Long hcode = hashCode(key);
	 Map m = new Map(key,value);
	 add(m,hcode);
	 }
 
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
	lhmap.put("12", "Neo");
	lhmap.put("ps", "npm");
	lhmap.put("Angular", "node");
	lhmap.put("Javascript", "Async");
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