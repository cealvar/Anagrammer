import java.util.Objects;

public class HashMap<K, V> implements Map<K, V> {
    private Node<K, V>[] map;
    private int cap; // max capacity of map
    private int size; // how many mappings

    @SuppressWarnings("unchecked")
    public HashMap() {
        map = (Node<K, V>[]) new Node[64];
        cap = 64;
    }

    @SuppressWarnings("unchecked")
    public HashMap(int buckets) {
        map = (Node<K, V>[]) new Node[buckets];
        cap = buckets;
    }

    private int hash(K key) {
        if (key != null) {
            int code = Math.abs(key.hashCode());
            return code % cap;
        }
        return 0;
    }

    private boolean check(K a, K b) {
        return (Objects.equals(b, a));
    }

    @Override
    @SuppressWarnings("unchecked")
    public void clear() {
        map = (Node<K, V>[]) new Node[cap];
        cap = 0;
    }

    @Override
    public boolean containsKey(K key) {
        Node ptr = map[hash(key)];
        while (ptr != null) {
            if (Objects.equals(ptr.getKey(), key))
                return true;
            ptr = ptr.getNext();
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (Node ptr: map) {
            if (ptr != null) {
                while (ptr != null) {
                    if (Objects.equals(ptr.getValue(), value))
                        return true;
                    ptr = ptr.getNext();
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        Node<K, V> ptr = map[hash(key)];
        while (ptr != null) {
            if (Objects.equals(ptr.getKey(), key))
                return ptr.getValue();
            ptr = ptr.getNext();
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        int hash = hash(key);
        Node<K, V> ptr = map[hash];
        if (ptr == null) {
            map[hash] = new Node<>(key, value, null);
            size++;
            return map[hash].getValue();
        }
        while (ptr != null) {
            if (Objects.equals(ptr.getKey(), key))
                return ptr.getValue(); // no duplicates
            if (ptr.getNext() == null) {
                ptr.setNext(new Node<>(key, value, null));
                ptr = ptr.getNext();
                size++;
                return ptr.getValue();
            }
            ptr = ptr.getNext();
        }
        return null;
    }

    @Override
    public V remove(K key) {
        int hash = hash(key);
        Node<K, V> trailer = map[hash];
        if (trailer == null)
            return null;
        Node<K, V> ptr = map[hash].getNext();
        if (Objects.equals(trailer.getKey(), key)) {
            V val = trailer.getValue();
            map[hash] = ptr;
            size--;
            return val;
        }
        while (ptr != null) {
            if (Objects.equals(ptr.getKey(), key)) {
                V val = ptr.getValue();
                trailer.setNext(ptr.getNext());
                size--;
                return val;
            }
            ptr = ptr.getNext();
            trailer = trailer.getNext();
        }
        return null;
    }

    @Override
    public V replace(K key, V value) {
        Node<K, V> ptr = map[hash(key)];
        if (ptr == null)
            return null;
        while (ptr != null) {
            if (Objects.equals(ptr.getKey(), key)) {
                V old_value = ptr.getValue();
                ptr.setValue(value);
                return old_value;
            }
            ptr = ptr.getNext();
        }
        return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    public String toString() {
        if (isEmpty())
            return "{}";
        StringBuilder map_str = new StringBuilder();
        for (Node<K,V> ptr : map) {
            if (ptr != null) {
                while (ptr != null) {
                    map_str.append(ptr.getKey()).append(":").append(ptr.getValue());
                    if (ptr.getNext() != null) {
                        map_str.append(" -> ");
                    }
                    ptr = ptr.getNext();
                }
                map_str.append("\n");
            }
        }
        return map_str.toString();
    }

    public static void main(String[] args) {
        HashMap<String, Integer> m = new HashMap<>();

        m.put("AaAa", 10);
        m.put("BBBB", 30);
        m.put("b", 20);
        m.put("AaBB", 50);
        System.out.println(m);

        System.out.println(m.remove("c"));

        System.out.println(m);
    }
}
