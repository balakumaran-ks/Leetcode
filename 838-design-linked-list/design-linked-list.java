class MyLinkedList {

    class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    private Node head, tail;
    private int size;

    public MyLinkedList() {
        head = new Node(0); // dummy head
        tail = new Node(0); // dummy tail
        head.next = tail;
        // tail.prev = head;
        size = 0;
    }

    private Node getNode(int index) {
        if (index < 0 || index >= size)
            return null;

        Node curr = head;
        while(index-- >= 0)
            curr = curr.next;
        return curr;
    }

    public int get(int index) {
        Node node = getNode(index);
        return node == null ? -1 : node.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void addAtIndex(int index, int val) {
        if (index < 0 || index > size)
            return;

        Node newNode = new Node(val);
        Node prev = head;
        for (int i = 0; i < index; i++)
            prev = prev.next;  
        newNode.next = prev.next;
        prev.next = newNode;

        size++;
    }

    public void deleteAtIndex(int index) {
        Node node = getNode(index);
        if (node == null)
            return;

        Node prev = head;
        for (int i = 0; i < index; i++)
            prev = prev.next;
        prev.next = node.next;
        size--;
    }
}