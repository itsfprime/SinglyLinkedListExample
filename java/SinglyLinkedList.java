import java.awt.*;
import java.util.ListIterator;

public class SinglyLinkedList<T> {
    private Node<T> head;

    public SinglyLinkedList(Node<T> head){
        this.head = head;
    }

    public SinglyLinkedList(){
        this(null);
    }

    public Node<T> removeFromFront(){
        if(isEmpty()) return null;
        Node<T> front = head;
        System.out.println("Removed from front: " + front.toString());
        head = head.getNext();
        front.setNext(null); // Ensures that there are no pointers to the new list
        return front;
    }

    public Node<T> removeFromBack(){
        // Empty List Case
        if(isEmpty()) return null;

        // Single-Node List Case
        if(head.getNext() == null){
            Node<T> only = head;
            head = null;
            System.out.println("Removed from back: " + only.toString());
            only.setNext(null); // Detach, probably not necessary here, general practice
            return only;
        }

        Node<T> current = head;
        while(current.getNext().getNext() != null){
            current = current.getNext();
        }
        Node<T> lastNode = current.getNext();
        System.out.println("Removed from back: " + lastNode.toString());
        current.setNext(null);
        return lastNode;
    }

    public void addToFront(Node<T> newNode){
        System.out.println("Added to front: " + newNode.toString());
        newNode.setNext(head);
        this.head = newNode;
    }

    public void addToBack(Node<T> newNode){
        System.out.println("Added to back: " + newNode.toString());
        if (head == null) {
            head = newNode;
            return;
        }
        Node<T> current = head;
        while(current.getNext() != null){
            current = current.getNext();
        }
        current.setNext(newNode);
    }

    public Node<T> getHead(){
        return head;
    }

    public Node<T> getTail(){
        if (head == null) return null;
        Node<T> placeholder = head;
        while(placeholder.getNext() != null){
            placeholder = placeholder.getNext();
        }
        return placeholder;
    }

    @Override
    public String toString(){
        if(head == null) return "Full List: []";
        StringBuilder sb = new StringBuilder();
        sb.append("Full List: ");
        Node<T> current = head;
        while(current != null){
            sb.append(current.toString());
            if(current.getNext() != null) sb.append(", ");
            current = current.getNext();
        }
        return sb.toString();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        if(isEmpty()) return 0;
        int count = 0;
        Node<T> current = head;
        while(current != null){
            count++;
            current = current.getNext();
        }
        return count;
    }

    public Node<T> get(int index){
        Node<T> current = head;
        for(int i = 0; i < index; i++){
            if(current.getNext() != null){
                current = current.getNext();
            }
        }
        return current;
    }
}