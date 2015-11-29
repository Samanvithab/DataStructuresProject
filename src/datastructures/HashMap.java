package datastructures;
import java.util.ArrayList;

/**
 * Implementation of a hashmap mapping a key to a value.
 * @author Samanvitha Basole
 */
public class HashMap<K, V> {
      
    private Entry<K,V>[] table;   //Array of Entry.
    private int capacity= 4;  //Initial capacity of HashMap
    
    /**
     * Inner class for maintaining the HashMap class
     * An entry holds a key and a value.
     */
    public static class Entry<K, V> {
        K key;
        V value;
        Entry<K,V> next;

        public Entry(K key, V value, Entry<K,V> next){
            this.key = key;
            this.value = value;
            this.next = next;
        }
            
        public V getValue() {
            return value;
        }
        
        public K getKey() {
            return key;
        }     
    }
    
    /**
     * Creates a hash map of size capacity.
     */
    public HashMap(){
        table = new Entry[capacity];
    }
    
    /**
     * Returns a list of all the entries.
     * @return list of entries
     */
    public ArrayList<Entry<K, V>> getItems() {
        ArrayList<Entry<K, V>> itemList = new ArrayList<>();
        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                Entry<K, V> entry=table[i];
                while(entry!=null){
                      itemList.add(entry);
                      entry=entry.next;
               }
            }
        }
        return itemList;
    } 
 
     /**
      * Method allows to insert key-value pair in MyHashMap.
      * If the map already contains a mapping for the key, the old value is replaced.
      * @param newKey key
      * @param data value
      */
     public void put(K newKey, V data){
         if(newKey==null)
              return;    //does not allow to store null.
        
         //calculate hash of key.
         int hash=hash(newKey);
         //create new entry.
         Entry<K,V> newEntry = new Entry<K,V>(newKey, data, null);
        
         //if table location does not contain any entry, store entry there.
          if(table[hash] == null){
            table[hash] = newEntry;
          }else{
              Entry<K,V> previous = null;
              Entry<K,V> current = table[hash];
              
              while(current != null){ //we have reached last entry of bucket.
              if(current.key.equals(newKey)){           
                    if(previous==null){  //node has to be insert on first of bucket.
                            newEntry.next=current.next;
                            table[hash]=newEntry;
                            return;
                    }
                    else{
                         newEntry.next=current.next;
                         previous.next=newEntry;
                         return;
                    }
              }
              previous=current;
                 current = current.next;
            }
            previous.next = newEntry;
          }
     }
 
    /**
     * Method returns value corresponding to key.
     * @param key key to check
     */
    public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
            return null;
        }else{
            Entry<K,V> temp = table[hash];
            while(temp!= null){
                if(temp.key.equals(key))
                    return temp.value;
                temp = temp.next; //return value corresponding to key.
            }         
            return null;   //returns null if key is not found.
        }
    }
 
 
    /**
     * Method removes key-value pair from MyHashMap.
     * @param key key to remove
     */
    public boolean remove(K deleteKey){

        int hash=hash(deleteKey);

        if(table[hash] == null){
               return false;
        }else{
         Entry<K,V> previous = null;
         Entry<K,V> current = table[hash];

         while(current != null){ //we have reached last entry node of bucket.
            if(current.key.equals(deleteKey)){               
                if(previous==null){  //delete first entry node.
                    table[hash]=table[hash].next;
                    return true;
                }
                else{
                    previous.next=current.next;
                    return true;
                }
            }
            previous=current;
               current = current.next;
            }
        return false;
        }
    }
    
 
     /**
      * Method displays all key-value pairs present in MyHashMap
      * insertion order is not guaranteed
      */
    public void display(){
        for(int i=0;i<capacity;i++){
            if(table[i]!=null){
                Entry<K, V> entry=table[i];
                while(entry!=null){
                    System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                    entry=entry.next;
                }
            }
        }             
    }
    
     /**
      * Method implements hashing functionality, which helps in finding the appropriate
      * bucket location to store our data.
      * @param key key to hash
      */
     private int hash(K key){
          return Math.abs(key.hashCode()) % capacity;
     }
 
}
