package com.playground.DataStructure;

public class HashMap<K, V> {
    private static class HashNode<K, V>
    {
        private final K key;
        private V val;
        HashNode<K,V> next;
        HashNode(K key, V val)
        {
            this.key = key;
            this.val = val;
        }

        public K getKey()
        {
            return key;
        }

        public V getVal()
        {
            return val;
        }

        public void setVal(V val)
        {
            this.val = val;
        }
    }
    public static final double DEFAULT_LOAD_FACTOR = 0.75;
    public static final int DEFAULT_CAPACITY = 16;
    public static final int REHASH_FACTOR = 2; // double the size if do a rehash

    private HashNode<K, V>[] nodes;
    private int size;
    private double loadFactor;

    public HashMap(int cap, double loadFactor)
    {
        if (cap <= 0)
        {
            throw new IllegalArgumentException(" HASHMAP::HASHMAP :: Capacity should be larger than 0");
        }
        this.nodes = (HashNode<K, V>[]) new HashNode[cap];
        this.size = 0;
        this.loadFactor = loadFactor;
    }

    public HashMap()
    {
        this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    public HashMap(int cap)
    {
        this(cap, DEFAULT_LOAD_FACTOR);
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    private int getBucket(K key)
    {
        if (key == null) return 0;
        return key.hashCode() & 0x7FFFFFFF % nodes.length;
    }

    private boolean equalValue(V v1, V v2)
    {
        return v1 == v2 || (v1 != null && v1.equals(v2));
    }

    private boolean equalKey(K k1, K k2)
    {
        return k1 == k2 || (k1 != null && k1.equals(k2));
    }

    public V get(K key)
    {
        int bucket = getBucket(key);
        HashNode<K,V> node = nodes[bucket];
        while(node != null)
        {
            if(equalKey(node.getKey(), key)) return node.getVal();
            node = node.next;
        }
        return null;
    }

    public void put(K key, V val)
    {
        int bucket = getBucket(key);
        HashNode<K,V> node = nodes[bucket];
        while(node != null)
        {
            if (equalKey(node.getKey(), key))
            {
                node.setVal(val);
                return;
            }
            node = node.next;
        }
        HashNode<K,V> newNode = new HashNode<K, V>(key, val);
        newNode.next = nodes[bucket];
        nodes[bucket] = newNode;
        size++;
        if(needRehash())
        {
            rehash();
        }
    }

    public boolean containsValue(V val)
    {
        if (isEmpty()) return false;
        else
        {
            for (HashNode<K, V> node : nodes)
            {
                while (node != null)
                {
                    if (equalValue(node.getVal(), val))
                    {
                        return true;
                    }
                    node = node.next;
                }
            }
        }
        return false;
    }

    public boolean containsKey(K key)
    {
        if (isEmpty()) return false;
        else
        {
            int bucket = getBucket(key);
            HashNode<K, V> node = nodes[bucket];
            while (node != null)
            {
                if (equalKey(node.getKey(), key)) return true;
                node = node.next;
            }
            return false;
        }
    }

    public boolean needRehash()
    {
        return (double)size >= loadFactor * nodes.length;
    }

    public void rehash()
    {
        HashNode<K,V>[] newNodeArray = (HashNode<K,V>[])new HashNode[nodes.length * REHASH_FACTOR];
        HashNode<K, V>[] tmp = nodes;
        nodes = newNodeArray;
        for (HashNode<K, V> node : tmp)
        {
            while (node != null)
            {
                put(node.getKey(), node.getVal());
                node = node.next;
            }
        }
    }

}
