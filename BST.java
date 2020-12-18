import java.util.*;

public class BST<Key extends Comparable<Key>, Value> {
    private Node root;             

    private class Node {
        private Key key;          
        private Value val;        
        private Node left, right;  
        private int size;         
        public Node(Key key, Value val, int size) {
            this.key = key;
            this.val = val;
            this.size = size;
        }
    }

    public BST() {
        root = null;
    }

   
    public boolean isEmpty() {
        if (size()==0){
            return true;
        }
        return false;
       
    }

    //Return the size of element
    public int size() {
      return size(root);
       
    }

    private int size(Node x) {
        if (x == null){
            return 0;
        }
        return 1 + size(x.left) + size(x.right); 
    }


    
    public Value get(Key key) {
        if (key == null){
            throw new IllegalArgumentException("key is null");
        }
        else{
            return get(root, key);
        }
        
    }

    private Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.val;
        }
        return null; 
    }

    
    public void put(Key key, Value val) {
        
      Node newest = new Node(key,val,1);
        if (root == null) {
            root = newest;
            return;
        }
        Node parent = null, x = root;
        while (x != null) {
            parent = x;
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else {
                x.val = val;
                return;
            }   
        }
        int cmp = key.compareTo(parent.key);
        if (cmp < 0) parent.left  = newest;
        else         parent.right = newest;
    
    }

   
    public Key min() {
        if(size()== 0) throw new NoSuchElementException("symbol table is empty");
        return min (root).key;
    } 

    private Node min(Node x) { 
        if (x.left == null) return x;
       
        while(x.left != null){
            x = x.left;
        }
       
        return x;
    } 

   

    public Key floor(Key key) {
        
        if (key == null) throw new IllegalArgumentException("key is null");
        if (size()==0) throw new NoSuchElementException("there is no such key");
        Node x = floor(root, key);
        if (x == null) return null;
        else return x.key;
    } 
    private Node floor(Node x, Key key){
        
        Node z=null,floor = min(x);

        while(x != null){
            int com = key.compareTo(x.key);

            if(com < 0) x = x.left;

            else if (com > 0){
                int cmp = floor.key.compareTo(x.key);

                if(cmp<=0){
                    floor = x;
                    z = floor;
                }
                x = x.right; 
            }
            else return x;
        }
        //if there is no floor key then return null
        return z;
    }

  
        
    public Key select(int rank){

        if(rank<0 || rank>=size()) throw new NoSuchElementException("rank out of limit");

        Node temp = select(root, rank);
        if(temp!=null) return temp.key;
        return null;
    }

     //return the Node associated to given rank else null
    private Node select(Node x, int rank){
        while(x!=null){
            int size = size(x.left);
           
            if(size > rank) x = x.left;
           
            else if(size < rank){
                x = x.right;
                rank = rank - size - 1;
            }
          
            else return x;
        }
        return null;
    }
     
}

   

