public class LinkList {
    public static class node {
        int data;
        node next;

        public node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static node head;
    public static node tail;
    public static int size;

    public void Addnode(int data) {
        // step 1 create a new node
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = newnode;
            return;
        }
        // step 2 newnode =head;
        newnode.next = head;// linking step
        // step 3 head=newnode
        head = newnode;
    }

    public void addLast(int data) {
        node newnode = new node(data);
        size++;
        if (head == null) {
            head = tail = null;
            return;
        }
        tail.next = newnode;
        tail = newnode;
    }

    public void add(int ind, int data) {
        if (ind == 0) {
            Addnode(data);
            return;
        }
        node newnode = new node(data);
        size++;
        node temp = head;
        int i = 0;
        while (i < ind - 1) {
            temp = temp.next;
            i++;
        }
        newnode.next = temp.next;
        temp.next = newnode;
    }

    public void print() {
        node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public int RemoveFirst() {
        if (size == 0) {
            System.out.println("link list is empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int RemoveLast() {
        if (size == 0) {
            System.out.println("list is already empty");
            return -1;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        node prev = head;
        for (int i = 0; i < size - 2; i++) {
            prev = prev.next;
        }
        int val = prev.next.data;
        prev.next = null;
        tail = prev;
        size--;
        return val;
    }

    public int ItrSearch(int key) {
        node temp = head;
        int i = 0;
        while (temp != null) {
            if (temp.data == key) {
                return i;
            }
            temp = temp.next;
            i++;
        }
        return -1;
    }

    public int Helper(node head, int key) {
        if (head == null) {
            return -1;
        } else if (head.data == key) {
            return 0;
        }
        int idx = Helper(head.next, key);
        if (idx == -1) {
            return -1;
        }
        return idx + 1;
    }

    public int RecursiveSerch(int key) {
        return Helper(head, key);
    }

    public node FindMid(node head) {
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean Ispalindrome() {
        if (head == null || head.next == null) {
            return true;
        }
        // step1=find mid
        node midnode = FindMid(head);
        node prev = null;
        node curr = midnode;
        node next;
        while (curr != null) { // step2=reverse 2nd part same code to reverse a list as curr=head only chanege
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        node right = prev;
        node left = head;
        // compare
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public void DeleteFromlast(int n) {
        int sz = 0;
        node temp = head;
        while (temp != null) {
            temp = temp.next;
            sz++;
        }
        if (n == sz) {
            head = head.next;
            return;
        }
        int i = 1;
        node prev = head;
        int toindex = sz - n;
        while (i < toindex) {
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
        return;
    }

    public static boolean Iscycle() {
        node slow = head;
        node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void removeCycle() {
        node slow = head;
        node fast = head;
        boolean iscycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                iscycle = true;
                break;
            }
        }
        if (iscycle == false) {
            return;
        }
        slow = head;
        node prev = null;
        while (slow != fast) {
            slow = slow.next;
            prev = fast;
            fast = fast.next;
        }
        prev.next = null;
    }
    private node getmid( node head){
        node slow=head;
        node fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    private node merge(node head2,node head1){
         node mergell=new node(-1);
         node temp=mergell;
         while(head1!=null&&head2!=null){
            if(head1.data<=head2.data){
                temp.next=head1;
                head1=head.next;
                temp=temp.next;
            }
            else {
                temp.next=head2;
                head2=head.next;
                temp=temp.next;
            }
         }
         while(head1!=null){
            temp.next=head1;
                head1=head.next;
                temp=temp.next;
        }
        while(head2!=null){
            temp.next=head2;
            head2=head.next;
            temp=temp.next;
        }
        return mergell.next;
    }

    public node mergeShort(node head) {
        // step 1 to find mid
        if (head==null||head.next==null){
            return head;
        }
        node mid = getmid(head);
        node righthead = mid.next;
        mid.next = null;   // step2 left & right ms
        node newLeft = mergeShort(head);
        node newright = mergeShort(righthead);

      
        // to merge the parts
        return merge(newright,newLeft);
    }
    public void ZigZag(){
        // find mid 
        node slow =head;
        node fast =head.next;
        while (fast!=null&&fast.next!=null) {
            slow=slow.next;
            fast=fast.next.next;
        }
        node mid =slow;
        node curr=mid.next;
        mid.next=null;
        node prev=null;
        node Next;
        while(curr!=null){
            Next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=Next;
        }
        node right=prev;
        node left=head;
        node nxtl,nxtr;
        while(right!=null&&left!=null){
            nxtl=left.next;
            left.next=right;
            nxtr=right.next;
            right.next=nxtl;

            left=nxtl;
            right=nxtr;
        }

        //reverse 2nd half

        //alt mergeing
    }

    public static void main(String[] args) {
       LinkList l2=new LinkList();
      
       l2.Addnode(1);
       l2.addLast(2);
       l2.addLast(3);
       l2.addLast(4);
       l2.addLast(5);
       l2.addLast(6);
       l2.print();
       l2.ZigZag();
    //    l1.head=l1.mergeShort(l1.head); in Review ****
       l2.print();
    }
}
