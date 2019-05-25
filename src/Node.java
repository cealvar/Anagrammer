public class Node<K,V> {
    private K key;
    private V value;
    private Node<K,V> next;

    public Node (K initKey, V initValue, Node<K,V> initNext) {
        key = initKey;
        value = initValue;
        next = initNext;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void setNext(Node <K,V> link) {
        next = link;
    }

    public Node<K, V> getNext() {
        return next;
    }
}