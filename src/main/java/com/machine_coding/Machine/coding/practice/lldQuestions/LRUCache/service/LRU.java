package com.machine_coding.Machine.coding.practice.lldQuestions.LRUCache.service;

import com.machine_coding.Machine.coding.practice.lldQuestions.LRUCache.models.Node;

import java.util.HashMap;
import java.util.Map;

public class LRU<K, V> {
    private Integer capacity;
    private Map<K, Node<K, V>> cache;
    private Node<K, V> head;
    private Node<K, V> tail;

    public LRU(Integer capacity){
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node<>(null, null);
        this.tail = new Node<>(null, null);
        head.setNext(tail);
        tail.setPrev(head);
    }


    public synchronized V get(K key){
        Node<K, V> node = cache.get(key);
        if(node != null){
            moveToHead(node);
            return cache.get(key).getValue();
        }
        return null;
    }

    public synchronized void put(K key, V value){
        Node<K, V> node = cache.get(key);
        if(node != null){
            cache.get(key).setValue(value);
            addToHead(cache.get(key));
            return;
        }
        node = new Node<>(key, value);
        cache.put(key, node);
        addToHead(cache.get(key));
        if(cache.size() > capacity){
            Node<K, V> nodeToBeRemove = tail.getPrev();
            removeNode(nodeToBeRemove);
            cache.remove(nodeToBeRemove.getKey());
        }
        return;
    }

    private void moveToHead(Node<K, V> node) {
        removeNode(node);
        addToHead(node);
    }

    //1 2 3 4

    private void removeNode(Node<K, V> node) {
        node.getPrev().setNext(node.getNext());
        node.getNext().setPrev(node.getPrev());
    }

    private void addToHead(Node<K, V> node) {
        node.setPrev(head);
        node.setNext(head.getNext());
        head.getNext().setPrev(node);
        head.setNext(node);
    }
}
