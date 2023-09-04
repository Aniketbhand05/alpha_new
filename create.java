package linked_list;

public class create {
    public class node{
        int data;
        node next;
        public node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static node head;
    public static node tail;
    public void add_first(int data){
        node newnode = new node(data);
        if(head == null){
            head = tail = newnode;
            return;
        }
        newnode.next = head;
        head = newnode;

    }
    public void addlast(int data){
        node newnode = new node(data);
        if(head == null){
            head = tail = newnode;
            return;
        }
        tail.next = newnode;
        tail = newnode;

    }
    public void print(){
        node temp = head;
        while(temp != null){
            System.out.println(temp.data + " ");
            temp = temp.next;

        }
    }
    public static void main(String argrs[]){
        create ll = new create();
        ll.add_first(2);
        ll.add_first(1);
        ll.addlast(4);
        ll.addlast(5);
        ll.print();

    }
    
}
