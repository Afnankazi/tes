public class DoublyLinkedList {

    private Node head;
    private Node tail;
    private int length;

    class Node {
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
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
        System.out.println("\nDoubly Linked List:");
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
    
    public void append (int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        if (index < length/2) {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        } else {
            temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
        }
        return temp;
    }
    public void reverse(){
        if(length<1) return;
        Node temp = head;
        Node n = head;
        head=head.next;
        n.next=null;
        n.prev = head;
        n=n.prev;
        while(n.prev!=null){
            Node t= n.next;
            n.next = n.prev;
            n.prev=t;
            if(n.prev!=null)n=n.prev;
        }
        head = n;
        tail = temp;
    }
    public boolean isPalindrome(){
        int c = 0;
        if(length ==0)return false;
        
        while(head.value==tail.value){
           
            c++;
            head=head.next;
            tail=tail.prev;
            if(head==null && tail==null){
                break;
            }
        }
        if(c==length)return true;
        return false;
    }
    public void swap(){
        Node d = new Node(0);
        d.next=head;
        Node pn = d;
        System.out.println();
        while (head!=null && head.next!=null) {
            Node fn =head;
            Node sn = head.next;
            pn.next=sn;
            fn.next=sn.next;
            sn.next=fn;
            sn.prev=pn;
            fn.prev=sn;
            if(fn.next!=null){
                fn.next.prev=fn;
            }
            head=fn.next;
            pn=fn;
            head=d.next;
            
        }
    }
	// WRITE ISPALINDROME METHOD HERE //
	//                                //
	//                                //
	//                                //
	//                                //
	////////////////////////////////////



  public static void main(String[] args) {
    DoublyLinkedList myDLL = new DoublyLinkedList(1);
    myDLL.append(2);
    myDLL.append(3);
    myDLL.append(4);
    myDLL.append(5);
 
    myDLL.swap();
    myDLL.printAll();
  }
	// WRITE REVERSE METHOD HERE //
	//                           //
	//                           //
	//                           //
	//                           //
	///////////////////////////////

}

