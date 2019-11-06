package Kata4_model;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Histogram <T> implements Iterable<T>{
    private final Map<T,Integer> counts = new TreeMap<>();
    
    public Histogram(){}
    
    public Histogram(T... values){
        for (T value : values) {
            counts.put(value, counts.getOrDefault(value, 0) + 1);
        }
    }
   
    @Override
    public Iterator<T> iterator() {
        return counts.keySet().iterator();
    }

    public int getCount(T value) {
        return counts.getOrDefault(value, 0);
    }
    
    public Set<T> keySet(){
        return counts.keySet();
    }
    
    public void increment(T value){
        counts.put(value, counts.getOrDefault(value, 0) + 1);
    }
    
}
