package fastcode.api.util.generics;

import java.util.ArrayList;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
@Component @Lazy
public class Vector<T, U> {
     private ArrayList<T> inventory;
     public Vector() {inventory = new ArrayList<T>();}
     public void add(T t) {inventory.add(t);}
     public void clear() {inventory.clear();}
     public int size() {return inventory.size();}
     public T get(int i) {
    	 return inventory.get(i);
    }
     public ArrayList<T> get(){return inventory;}
     
}