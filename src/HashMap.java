public class HashMap<K,V> implements Map<K,V> {
    private Node<K,V>[] map;
    private int capacity; // max capacity of map
    private int size; // how many mappings

    @Override
    public void clear() {

    }

    @Override
    public boolean containsKey(K key) {
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        return false;
    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public V replace(K key, V value) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
