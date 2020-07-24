package list;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache
{
    int capacity;
    Map<Integer,Integer> map;

    public LRUCache(int capacity)
    {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key)
    {
        if (! map.containsKey(key)) return -1;
        Integer val = map.remove(key);
        map.put(key, val);
        return val;
    }

    public void put(int key, int value)
    {
        if (map.containsKey(key)) {
            map.remove(key);
            map.put(key, value);
            return;
        }
        map.put(key, value);
        if ((map.size() > capacity)) {
            map.remove(map.entrySet().iterator().next().getKey());
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
