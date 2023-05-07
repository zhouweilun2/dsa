package dsa.impl;

import dsa.iface.IEntry;
import dsa.iface.IIterator;
import dsa.iface.IMap;

/**
 * Implementation of a TreeMap, using an AVL Tree implementation strategy.
 *
 * The get(), put() and remove() methods should behave as they do in a normal Map ADT.
 *
 * All iterator methods should return items in ascending order of their keys.
 */
public class AVLTreeMap<K extends Comparable<K>,V> extends ProperLinkedBinaryTree<IEntry<K,V>> implements IMap<K,V> {
    @Override
    public V get(K k) {
        return null; // placeholder so that this class can compile - you will need to replace this.
    }

    @Override
    public V put(K k, V v) {
        return null; // placeholder so that this class can compile - you will need to replace this.
    }

    @Override
    public V remove(K k) {
        return null; // placeholder so that this class can compile - you will need to replace this.
    }

    @Override
    public IIterator<K> keys() {
        return null; // placeholder so that this class can compile - you will need to replace this.
    }

    @Override
    public IIterator<V> values() {
        return null; // placeholder so that this class can compile - you will need to replace this.
    }

    @Override
    public IIterator<IEntry<K, V>> entries() {
        return null; // placeholder so that this class can compile - you will need to replace this.
    }
}
