public class Node <T>{
    private Node<T> next;
    private T data;

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    public Node(T data){
        this(data, null);
    }

    public void setData(T data){
        this.data = data;
    }

    public void setNext(Node<T> nextptr){
        next = nextptr;
    }

    public Node<T> getNext(){
        return next;
    }

    public T getData(){
        return data;
    }

    @Override
    public String toString(){
        // Make sure we don't run into NullPointerException with 'data == null'
        return "[" + (data == null ? "null" : data.toString()) + "]";
    }
}