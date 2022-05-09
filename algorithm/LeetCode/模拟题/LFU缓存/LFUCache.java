package LeetCode.模拟题.LFU缓存;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    private int capacity,minfreq;
    HashMap<Integer, Integer> keyToValue = new HashMap<>();
    HashMap<Integer, Integer> keyToFreq = new HashMap<>();
    LinkedHashMap<Integer, LinkedHashSet> freqToKey = new LinkedHashMap<>();

    LFUCache(int capacity) {
        this.capacity = capacity;
        this.minfreq = 0;
    }

    public int get(int key) {
        if (keyToValue.containsKey(key)) {
            increaseFreq(key);
            return keyToValue.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key,int value) {
        if(capacity<=0) return;
        if(keyToValue.containsKey(key)){
            increaseFreq(key);
            keyToValue.put(key,value);
        } else {
            if(keyToValue.size() == capacity) {
                LinkedHashSet<Integer> list = freqToKey.get(minfreq);
                int deleteKey = list.iterator().next();
                list.remove(deleteKey);
                if(list.isEmpty()) freqToKey.remove(minfreq);
                keyToValue.remove(deleteKey);
                keyToFreq.remove(deleteKey);
            }
            keyToValue.put(key,value);
            keyToFreq.put(key,1);
            freqToKey.putIfAbsent(1,new LinkedHashSet<>());
            freqToKey.get(1).add(key);
            minfreq = 1;
        }
    }

    public void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqToKey.get(freq).remove(key);
        freqToKey.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqToKey.get(freq + 1).add(key);
        if (freqToKey.get(freq).isEmpty()) {
            freqToKey.remove(freq);
            if(freq == minfreq) minfreq++;//忘了
        }
    }
}
