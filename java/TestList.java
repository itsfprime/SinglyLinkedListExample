import java.util.Scanner;

public class TestList {
    public static void main(String[] args) {
        System.out.println("1.) No Arg Constructor Test" +
                "\n2.) Single Node List Test" +
                "\n3.) Multi Node List Test" +
                "\n4.) Sequential Removal Test" +
                "\n5.) Alternating Add Remove Test" +
                "\n6.) Reuse Removed Node Test" +
                "\n7.) Stress Test" +
                "\n8.) All tests");
        Scanner reader = new Scanner(System.in);
        int choice = reader.nextInt();
        switch (choice){
            case 1:
                noArgConstructorTest();
                break;
            case 2:
                singleNodeListTest();
                break;
            case 3:
                multiNodeListTest();
                break;
            case 4:
                sequentialRemovalTest();
                break;
            case 5:
                alternatingAddRemoveTest();
                break;
            case 6:
                reuseRemovedNodeTest();
                break;
            case 7:
                stressTest();
                break;
            case 8:
                noArgConstructorTest();
                singleNodeListTest();
                multiNodeListTest();
                sequentialRemovalTest();
                alternatingAddRemoveTest();
                reuseRemovedNodeTest();
                stressTest();
                break;
            default:
                System.out.println("Invalid option");
        }
        reader.close();
    }
    private static void noArgConstructorTest(){
        SinglyLinkedList<Object> emptyList = new SinglyLinkedList<>();
        emptyList.removeFromBack();
        emptyList.removeFromFront();
        assert emptyList.getHead() == null : "Head should be null on empty list";
        assert emptyList.getTail() == null : "Tail should be null on empty list";
        assert emptyList.isEmpty() : "List should report empty";
    }
    private static void singleNodeListTest(){
        Node<Object> n1 = new Node<>("Cat");
        SinglyLinkedList<Object> sll = new SinglyLinkedList<>(n1);
        Node<Object> n2 = sll.removeFromFront();
        assert n2.getNext() == null : "Removed front node not detached"; // Check if popped element is detached
        System.out.println(sll.toString());
        System.out.println("Is list empty: " + (sll.isEmpty() ? "Yes" : "No"));
        sll.addToFront(n1);
        Node<Object> n3 = sll.removeFromBack();
        assert n3.getNext() == null : "Removed back node not detached"; // Check if popped element is detached
        System.out.println(sll.toString());
        System.out.println("Is list empty: " + (sll.isEmpty() ? "Yes" : "No"));
    }
    private static void multiNodeListTest(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addToBack(new Node<>(1));
        sll.addToBack(new Node<>(2));
        sll.addToBack(new Node<>(3));

        assert sll.size() == 3 : "List size should be 3";
        assert sll.getHead().getData() == 1 : "Head data should be 1";
        assert sll.getTail().getData() == 3 : "Tail data should be 3";
        System.out.println(sll);
    }
    private static void sequentialRemovalTest(){
        Node<Double> d1 = new Node<>(1.01);
        Node<Double> d2 = new Node<>(2.02);
        Node<Double> d3 = new Node<>(3.03);
        Node<Double> d4 = new Node<>(4.04);

        SinglyLinkedList<Double> sll = new SinglyLinkedList<>(d1);
        sll.addToBack(d2);
        sll.addToBack(d3);
        sll.addToBack(d4);

        System.out.println("Before removal: \n" + sll);
        System.out.println("After Removal:");

        sll.removeFromBack();
        sll.removeFromBack();
        sll.removeFromBack();
        sll.removeFromBack();

        System.out.println(sll);
        assert sll.isEmpty() : "List should be empty";
        System.out.println("Remove from back test complete...");

        sll.addToBack(d1);
        sll.addToBack(d2);
        sll.addToBack(d3);
        sll.addToBack(d4);

        System.out.println("Before removal: \n" + sll);
        System.out.println("After Removal:");

        sll.removeFromFront();
        sll.removeFromFront();
        sll.removeFromFront();
        sll.removeFromFront();

        System.out.println(sll);
        assert sll.isEmpty() : "List should be empty";
        System.out.println("Remove from front test complete...");
    }
    private static void alternatingAddRemoveTest() {
        SinglyLinkedList<String> sll = new SinglyLinkedList<>();
        sll.addToFront(new Node<>("A"));
        sll.addToBack(new Node<>("B"));
        assert sll.size() == 2 : "Size should be 2";
        sll.removeFromFront();
        sll.removeFromBack();
        assert sll.isEmpty() : "List should be empty";
    }
    private static void reuseRemovedNodeTest(){
        Node<Integer> n = new Node<>(10);
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        sll.addToFront(n);
        sll.removeFromFront();
        assert n.getNext() == null : "Removed node should not have access to old elements";
        sll.addToBack(n); // should not create loops or exceptions
    }
    private static void stressTest(){
        SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
        for (int i = 0; i < 1000; i++)
            sll.addToBack(new Node<>(i));
        for (int i = 0; i < 1000; i++)
            sll.removeFromFront();
        assert sll.isEmpty() : "List should be empty";
        assert sll.getHead() == null && sll.getTail() == null : "Head and tail should be null";
    }
}
