package ex03;

class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException() {
        super("Transaction not found");
    }
}

public class TransactionsLinkedList implements TransactionsList {

    private static class Node {
        private final Transaction transaction;
        private Node next;
        private Node previous;

        private Node(Transaction transaction) {
            this.transaction = transaction;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    @Override
    public void add(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("transaction cannot be null");
        }

        Node newNode = new Node(transaction);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
        size++;
    }

    @Override
    public void remove(Transaction transaction) {
        if (transaction == null) {
            throw new IllegalArgumentException("transaction cannot be null");
        }

        Node current = head;
        while (current != null) {
            if (current.transaction.getId().equals(transaction.getId())) {
                unlink(current);
                return ;
            }
            current = current.next;
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        Node current = head;
        int index = 0;

        while (current != null) {
            transactions[index++] = current.transaction;
            current = current.next;
        }
        return transactions;
    }

    @Override
    public Transaction get(String id) {
        if (id == null) {
            return null;
        }

        Node current = head;
        while (current != null) {
            if (id.equals(current.transaction.getId())) {
                return current.transaction;
            }
            current = current.next;
        }
        return null;
    }

    private void unlink(Node node) {
        if (node.previous == null) {
            head = node.next;
        } else {
            node.previous.next = node.next;
        }

        if (node.next == null) {
            tail = node.previous;
        } else {
            node.next.previous = node.previous;
        }

        size--;
    }
}
