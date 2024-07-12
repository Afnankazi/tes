import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class LinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public void printAll() {
        if (length == 0) {
            System.out.println("Head: null");
            System.out.println("Tail: null");
        } else {
            System.out.println("Head: " + head.value);
            System.out.println("Tail: " + tail.value);
        }
        System.out.println("Length:" + length);
        System.out.println("\nLinked List:");
        if (length == 0) {
            System.out.println("empty");
        } else {
            printList();
        }
    }
    
    public void makeEmpty() {
        head = null;
        tail = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }
    public Node removeLast(){
        if(length==0){
            return null;
        }
        Node temp = head;
        Node pre=head;
        while(temp.next!=null){
            pre = temp;
            temp=temp.next;
        }
        tail=pre;
        tail.next=null;
        
        length--;
        if(length==0){
            head=null;
            tail=null;
        }
        return temp;
    }
    public Node reveink(Node head,int k){
        Node knode = head;
       Node closer=head;
       Node temp = head;
           
       Node after = temp.next;
       Node before = null;
        while(after!=null){
         
            for (int i = 0; i < k; i++) {
            
                after = temp.next;
                temp.next = before;
                before = temp;
                temp = after;
            }
            Node btail=before;
            while (btail.next!=null) {
                btail=btail.next;
                
            }
            btail.next=after;
            head = before;
          after=after.next;
          before=before.next;
           
        
    }
        return closer;
    }

     public boolean isPalindrome(Node head) {
        if(head==null) return false;
        Node tail = head;
        int l=0;
        ArrayList a = new ArrayList();
        while(tail!=null){
            if(tail!=null)a.add(tail.value);
            tail=tail.next;
            l++;
        }
        for(int i =0;i<l;i++){
            if(a.get(i)!=a.get(l-i-1)) return false;
        }return true;
    } 
    public Node deleteDuplicates(Node head) {
        int length=0;
        Node tail =head;
        while(tail!=null){
            length++;
            tail=tail.next;
        }
        Set<Integer> values = new HashSet<>();
       Node previous = null;
        Node current = head;
        Node p = head;
        Node p2 = p;
        int  t = 0;
        while (current != null) {
            if (values.contains(current.value)) {
               if(p!=null){
                p.next = current.next;
                
               }
               t++;
                length -= 1;
            } else {
                values.add(current.value);
                p=previous;
                previous = current;
            }
            previous=previous.next;
            current = current.next;
        } 
        for(int i=0;i<t;i++){
            p2=p2.next;
        }
        head.next=p2.next;
        return head; 
    }
    public Node reorder(Node head){
        boolean t = false;
        if(head==null) return null;
        Node h =head;
        Node s = head;
        Node f =head;
        while( f!=null && f.next!=null){
            s=s.next;
            f=f.next.next;

        }
        Node nh = head;
        while(nh.next!=s){
            nh=nh.next;
            t=true;
        }
        if(t)nh.next=null;
        Stack<Node> v = new Stack<>();
        while(s!=null){
        
            v.push(new Node(s.value));
            if(s.next==null)break;
            s=s.next;
        }
        if(!t){
            while (!v.isEmpty()) {
                h.next=v.pop();
                h=h.next;
                
            }
            return h;
        }
        s=head;
        f=head.next;
        while (!v.isEmpty()) {
          s.next=null;
          s.next =v.pop();
          s=s.next;
          s.next=f;
          s=s.next;
          if(f.next!=null){
            f=f.next;
          }else{
            f.next=v.pop();
            while(!v.isEmpty()){
                f=f.next;
                f.next=v.pop();
            }
          }
          

        }
        return h;
      
        

    }
    public Node bou(Node head){
        int[] a = {2,4,5};
        
        String s ="";
        Node t = head;
        while(t!=null){
            s+=t.value;
            t=t.next;
        }
       BigInteger ab = new BigInteger(s);

       BigInteger b = new BigInteger("2");
      ab= ab.multiply(b);
       String v = String.valueOf(a);
       Node h = new Node(v.charAt(0)-'0');
       t=h;
       for(int i=1;i<v.length();i++){
        h.next= new Node(v.charAt(i)-'0');
        h=h.next;
       }
       return h;
    }
    public int[] dis(Node head){
        ArrayList<Integer> h = new ArrayList<>();
        Node o = head;
        Node t = head.next;
        Node th = head.next.next;
        int i =1;
        while(th!=null){
            if(t.value>th.value && t.value>o.value || t.value<th.value && t.value<o.value){
                h.add(i);
               
            }
            o=o.next;
            t=t.next;
            th=th.next;
            i++;
        }
        int max_dis =h.get(h.size()-1)-h.get(0);
        int min_dis=h.get(1)-h.get(0);
        int temp=h.get(1)-h.get(0);
        h.sort(null);
        for (int j = 0; j < h.size()-1; j++) {
            temp= Math.min(h.get(j+1)-h.get(j),temp);
            if(temp<min_dis){
                min_dis=temp;
            }
            
        }
        return new int[]{min_dis,max_dis};
    }
     public static void main(String[] args) {
   
       LinkedList a = new LinkedList(2);
       a.append(2);
       a.append(1);
       a.append(3);
      
     
       a.dis(a.getHead());

      
  }
      
	// WRITE REMOVELAST METHOD HERE //
	//                              //
	//                              //
	//                              //
	//                              //
	//////////////////////////////////

}


