public class DLL {
    public class Node {
        int data;
        Node next;
        Node prev;
        public Node (int data){
            this.data=data;
            this.next=null;
            this.prev=null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size; 
    public void addFirst(int data){
        Node newnode = new Node(data);
        size++;
        if(head==null){
            head=tail=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    public void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"<->");
            temp=temp.next;
        }
        System.out.println("Null");
    }
    public int removeFirst(){
        if(head==null){
            System.out.println("list is already empty");
            return -1;
        }
        if(size==1){
            int val=head.data;
            head=tail=null;
            size=0;
            return val;
        }
        int val =head.data;
        head=head.next;
        head.prev=null;
        size--;
        return val;
    }
    public void reverse (){
        Node curr=head;
        Node prev=null;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            curr.prev=next;
            prev=curr;
            curr=next;
        }
        head=prev;
    }
    public static void main(String[] args) {
        DLL dll= new DLL();
        dll.addFirst(4);
        dll.addFirst(3);
        dll.addFirst(2);
        dll.addFirst(1);
        dll.reverse();
        dll.print();
        System.out.println(dll.size); 
    }
}