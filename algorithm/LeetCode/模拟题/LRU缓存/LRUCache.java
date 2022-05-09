package LeetCode.模拟题.LRU缓存;

import java.util.HashMap;
import java.util.Map;

// 用双向链表+哈希表实现
// 3.25 终于写出来了，不容易不容易
public class LRUCache {
    class DLinkedNode {
        int key;//存放hash的key
        int value;//存放hash的value
        DLinkedNode pre;//双向链表指针
        DLinkedNode next;
        public DLinkedNode(){}
        public DLinkedNode(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer,DLinkedNode> map = new HashMap<Integer,DLinkedNode>();
    private int size;
    private int capacity;
    private DLinkedNode head,tail;


    public LRUCache(int capacity) {
        this.capacity = capacity;//容量
        this.size = 0;//当前大小
        head = new DLinkedNode();//这里我又忘了加 4.13 引用对象总得创一个吧，Node head就跑过分了
        tail = new DLinkedNode();//使用伪头、尾节点 方便处理
        head.next = tail;
        tail.pre = head;
    }

    private void deleteNode(DLinkedNode node){//通过哈希表来删会快一点
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }

    private DLinkedNode deleteTail() {
        DLinkedNode node = tail.pre;
        deleteNode(node);
        map.remove(node.key);
        return node;
    }

    private void addToHead(DLinkedNode node) {//不插入map吗？
        node.next = head.next;
        node.pre = head;
        head.next.pre = node;
        head.next = node;

    }

    private void moveToHead(DLinkedNode node) {
        deleteNode(node);
        addToHead(node);
    }

    public int get(int key) {
        DLinkedNode node = map.get(key) ;
        if(node == null) return -1;//not exist
        moveToHead(node);//exist
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedNode node = map.get(key);
        if(node == null) {
            node = new DLinkedNode(key,value);
            map.put(key,node);
            addToHead(node);
            size++;
            if(size > capacity) {
                deleteTail();
                size--;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
/*
["LFUCache","put","put","get","put","get","get","put","get","get","get"]
[[2],        [1,1],[2,2],[1], [3,3], [2],   [3], [4,4], [1], [3],   [4]]
[null,        null,  null,1,   null,  2,     3,   null,   1,   3,    4]
[null,        null,  null,1,   null,  -1,    3,    null,  -1,  3,    4]
1,3
        */