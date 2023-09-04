package linked_list;

import java.util.*;

public class whole_ll {
    public static class node{
        int data;
        node next;

        //constructor to create the first node

        public node(int data){
            this.data = data;
            this.next = null;

        }

    }
    public static node head;
    public static node tail;
    public static int size;

    //add elements first
    public void add_first(int data){
        //step 1 create new node
        node newnode = new node(data);
        //increment size
        size++;

        //if there is only a single node
        if(head == null ){
            head = tail = newnode;
            return;
        }

        //step 2 point new node to head
        newnode.next = head;

        //step 3 make the newnode as head
        head = newnode;


    }
    public void add_last(int data){
        //step1 create a new node
        node newnode = new node(data);
        size ++;
        
        //if there is no node then
        if(head == null){
            head = tail = newnode;
            return;
        }

        //step 2 point tail ka next to new node
        tail.next = newnode;

        //step 3 update tail to new node
        //newnode = tail;
        tail = newnode;
    }

    //print a linked list
    public void print(){
        node temp = head;
        if(head == null){
            System.out.println("linked list is empty");
            return;
        }
        while(temp != null){
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //add the element in the middle
    public void add_middle(int index ,int data){
        //if index ==0 the directly call add_first
        if(index == 0){
            add_first(data);
            return;
        }
        //create node
        node newnode = new node(data);
        size++;
        

        node temp = head;
        int i = 0 ;
        while(i<index-1){
            temp = temp.next;
            i++;
        }
        //point the pervious node next to new node
        newnode.next = temp.next;

        //point the next of new node to the previous node where the node was linked 
        temp.next = newnode;
    }
    public int del_first(){
        if(size == 0){
            System.out.println("linked list is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int val = head.data;
            head = tail = null;
            size --;
            return val;
        }
        int val = head.data;
        head = head.next;
        size --;
        return val;
    }

    //delete the last node i.e tail
    public int del_last(){
        if(size == 0){
            System.out.println("linked list is empty");
            return Integer.MAX_VALUE;
        }
        else if(size == 1){
            int val = tail.data;
            head = tail = null;
            size --;
            return val;
        }
        node temp = head;
        int i = 0;
        while ( i < size -2){
            temp = temp.next;
            i++;
        }
        int val = temp.next.data; //tail ka data 
        temp.next = null;
        tail = temp;
        size--;
        return val;
    }
    //iterative search
    public static int itr_search(int key){
        node temp = head;
        int i = 0;
        while(temp!= null){
            if(temp.data == key){

                return i;  
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    //recursive search approach
    public static int helper(node head, int key){
        if(head == null){
            return -1;
        }
        if(head.data == key){
            return 0;
        }
        int idx = helper(head.next , key);
        if(idx == -1){
            return -1;
        }
        return idx+1;
    }

    public static int rec_search(int key){
        return helper(head , key);

    }

    // reverse a linked list

    public void reverse_ll(){
        node prev = null;
        node curr = tail = head;
        node next;
        while (curr!= null){
            next = curr.next;
            curr.next = prev ;
            prev = curr;
            curr = next;
        }
        head = prev;
    
    }

    //revmove nth node from the ll
    public void remove_n_th_node_from_end(int idx){
        int sz = 0;
        node temp = head;
        while(temp!= null){
            sz++;
            temp = temp.next;
            
        }
        node prev = head;
        if(idx == sz){
            head = head.next;
            return;
        }
        int i = 1;
        while(i < sz-idx){
            prev = prev.next;
            i++;
        }
        prev.next = prev.next.next;
    }

    //check the linked list is palindrome or not
    // find the mid node 
    public node mid(node head){
        node slow = head ;
        node fast = head ;
        while(fast != null && fast.next != null ){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow; //it is myy mid node
    }
    public boolean palindrome(){
        if(head == null || head.next == null){
            return true;
        }

        //step 1 - find the mid
        node midnode = mid(head);

        //step 2 - reverse the linked list from the mid
        node prev = null;
        node curr = midnode;
        node next ;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } 
        node right_head = prev;
        node left_head = head;
         

        //step 3 - check the first half and the second half if they are palindrome or not
        while(right_head != null){
            if(left_head.data != right_head.data){
                return false;
            }
            left_head = left_head.next;
            right_head = right_head.next;

            
        }
        return true;
    }



    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        whole_ll ll = new whole_ll();
        //node main_head = new node(1);
        //ll.head = main_head;
        //ll.head = new node(1);
        //ll.head.next = new node(2);


        ll.add_first(2);
        ll.add_first(1);
        ll.add_last(3);
        ll.add_last(4);
        ll.add_last(5);
        ll.add_last(7);
        ll.add_last(8);
        ll.add_last(9);
        ll.add_last(10);
        // ll.add_first(1);
        // ll.add_last(2);
        // ll.add_last(2);
        // ll.add_last(1);


        ll.print();

        ll.add_middle(5, 6);
        System.out.print("linked list as follows -- ");
        ll.print();
        System.out.println();
        System.out.println( "size before deleting first node --> " + ll.size );
        System.out.println();
        System.out.println("element deleted --> " + ll.del_first());
        System.out.println();
        System.out.print("linked list as follows -- ");
        ll.print();
        System.out.println();
        System.out.println("size of liked list after deleting first node --> " + ll.size);
        System.out.println();
        System.out.println("element deleted from last --> " + ll.del_last());
        System.out.println();
        System.out.println("the size of the linked list after deleting last node -->" + ll.size);
        System.out.println();
        System.out.print("the linked list as follows -- ");
        ll.print();
        System.out.println();
        System.out.print("enter the element to be searched --> ");
        int search = sc.nextInt();
        System.out.println();
        System.out.println("the element is present at index(by iterative search) --> " + itr_search(search));
        System.out.println();
        System.out.println("the element is present at index(by recursive search) --> " + rec_search(search));
        System.out.println();
        ll.reverse_ll();
        System.out.print("the reversed linked list is  --> "  );
        ll.print();
       // System.out.println(ll.tail.data);
        System.out.println();
        //ll.remove_n_th_node_from_end(4);
        ll.print();
        //System.out.println(ll.palindrome());



        
    }
}
