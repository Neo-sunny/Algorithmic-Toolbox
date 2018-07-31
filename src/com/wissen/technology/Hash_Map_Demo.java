package com.wissen.technology;

import java.util.HashMap;
import java.util.List;

public class Hash_Map_Demo {
    public static void main(String[] args)
    {
 
        // Creating an empty HashMap
        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
 
        // Mapping string values to int keys
        hash_map.put(10, "Geeks");
        hash_map.put(15, "4");
        hash_map.put(20, "Geeks");
        hash_map.put(25, "Welcomes");
        hash_map.put(30, "You");
 
        // Displaying the HashMap
        System.out.println("Initial Mappings are: " + hash_map);
 
        // Using values() to get the set view of values
        System.out.println("The collection is: " + hash_map.values());
        
        List<String> l1 = (List<String>) hash_map.values();
        
    }
}