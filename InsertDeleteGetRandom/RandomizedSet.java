/*
Implement the RandomizedSet class:
RandomizedSet() Initializes the RandomizedSet object.
bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present,
false otherwise.
bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one
element exists when this method is called). Each element must have the same probability of being returned.
You must implement the functions of the class such that each function works in average O(1) time complexity.
 */


package InsertDeleteGetRandom;

import java.util.*;

class RandomizedSet {

    private Map<Integer,Integer> map;
    private Random random;
    private List<Integer> list;

    public RandomizedSet() {
        map=new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            list.add(val);
            map.put(val, list.size()-1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        int lastIndex = map.getOrDefault(val, -1);
        if (lastIndex == -1){
            return false;
        }
        Collections.swap(list, lastIndex, list.size() - 1);
        int otherSwappedValue = list.get(lastIndex);
        map.put(otherSwappedValue, lastIndex);
        list.remove(list.size() - 1);
        map.remove(val);
        return true;
    }

    public int getRandom() {
        int randomIndex = random.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
