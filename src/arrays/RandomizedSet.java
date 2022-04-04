package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    private Random random;
    private HashMap<Integer, Integer> valueIndexMap;
    private List<Integer> values;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet() {
        valueIndexMap = new HashMap<>();
        values = new ArrayList<>();
        random = new Random();

    }

    public static void main(String[] args) {


        // Your RandomizedSet object will be instantiated and called as such:
        RandomizedSet obj = new RandomizedSet();
        obj.insert(1);
        obj.insert(2);
        obj.insert(3);
        obj.insert(4);
        obj.insert(5);
        obj.remove(3);
        System.out.println(obj.getRandom());
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (valueIndexMap.containsKey(val)) return false;
        else {
            valueIndexMap.put(val, values.size());
            values.add(val);
            return true;
        }
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!valueIndexMap.containsKey(val)) return false;

        Integer index = valueIndexMap.get(val);
        Integer lastValue = values.get(values.size() - 1);
        values.set(values.size() - 1, val);
        values.set(index, lastValue);
        valueIndexMap.put(lastValue, index);
        valueIndexMap.remove(val);
        values.remove(values.size() - 1);
        return true;


    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int i = random.nextInt(values.size());
        return values.get(i);

    }
}
