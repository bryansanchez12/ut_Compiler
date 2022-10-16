package pp.FinalProject;

import java.util.*;


public class MySymbolTable {

    private Deque<List<String>> stack;

    public MySymbolTable() {
        this.stack = new ArrayDeque<> ();
        openScope();
    }
    public void openScope() {
        this.stack.addLast(new ArrayList <> ());
    }

    public void closeScope() {
        if (this.stack.size() ==1) {
            System.out.println("stack error");
        }
        this.stack.removeLast() ;
    }

    public void add(String id) {
        List<String> temporal = this.stack.removeLast();
        temporal.add(id);
        this.stack.addLast(temporal);
    }

    public int contains(String id){
        int counter=0;
        Iterator <List<String>> iterator = stack.iterator();
        while (iterator.hasNext()){
            List list_scope = iterator.next();
            for(int i=0; i<list_scope.size(); i++){
                counter ++;
            }
        }
        return counter;
    }

    public boolean contains2(String id) {
        Iterator<List<String>> it = stack.iterator();
        while (it.hasNext()) {
            if (it.next().contains(id))
                return true;
        }
        return false;
    }
}


