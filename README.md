# Singly Linked List Demonstration
## Author : Fprime (Jeremy Welty)
#### Purpose : To better understand a simple data structure and to gain familiarity in writing test code.
#### Methods :
- **addToFront(Node<T> newNode)** — Inserts a node at the head of the list. O(1)
- **addToBack(Node<T> newNode)** — Appends a node to the tail. O(n)
- **removeFromFront()** — Removes and returns the first node. O(1)
- **removeFromBack()** — Removes and returns the last node. O(n)
- **getHead()** — Returns the head node reference.
- **getTail()** — Returns the tail node reference.
- **isEmpty()** — Returns true if list has no nodes.
- **toString()** — Returns string representation of list contents.
- **size()** — Returns node count. O(n)
- **get(int index)** returns node at index. O(n)
#### Test Coverage : No argument constructor, single node lists, multiple node lists, sequential removal of multiple nodes, alternating add & remove operations, removed node pointer test, stress test, get test