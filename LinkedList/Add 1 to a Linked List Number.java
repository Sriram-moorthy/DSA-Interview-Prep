/*
class Node{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}
*/

class Solution {
    public Node addOne(Node head) {
        head = reverse(head);
        Node temp = head;
        int carry =1;
        while(temp != null){
            temp.data = temp.data + carry;
            if(temp.data < 10){
                carry = 0;
                break;
            }
            else{
                temp.data = 0;
                carry =1;
            }
            temp = temp.next;
        }
        head = reverse(head);
        if(carry == 1){
            Node newNode = new Node(1);
            newNode.next = head;
            return newNode;
        }
        return head;
        
    }
    public Node reverse(Node head){
        Node prev = null;
        while(head != null){
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
