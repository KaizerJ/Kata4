package Kata4_view;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;

public class IteratorReader implements Iterable<String>{
    private final BufferedReader breader;

    public IteratorReader(BufferedReader breader) {
        this.breader = breader;
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>(){

            String current = readLine();
            @Override
            public boolean hasNext() {
                return !(current == null);
            }

            @Override
            public String next() {
                String result = current;
                current = readLine();
                return result;
            }

            private String readLine() {
                try {
                    return breader.readLine();
                } catch(IOException e) {
                    return null;
                }
            }
        
        };
    }
}
