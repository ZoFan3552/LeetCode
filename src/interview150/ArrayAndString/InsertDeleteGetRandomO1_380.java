package interview150.ArrayAndString;

import java.util.*;

public class InsertDeleteGetRandomO1_380 {
    static class RandomizedSet {
        private final Set<Integer> set;
        private final Map<Integer, Integer> indexMap;
        private final List<Integer> valList;
        private final Random random;

        public RandomizedSet() {
            set = new HashSet<>();
            valList = new ArrayList<>();
            indexMap = new HashMap<>();
            random = new Random();
        }

        public boolean insert(int val) {
            if (set.contains(val)) {
                return false;
            } else {
                int index = valList.size();
                indexMap.put(val, index);
                valList.add(val);
                set.add(val);
                return true;
            }
        }

        public boolean remove(int val) {
            if (!set.contains(val)) {
                return false;
            } else {
                set.remove(val);
                int index = indexMap.get(val);
                if (index != valList.size() - 1) {
                    int newVal = valList.get(valList.size() - 1);
                    valList.set(index, newVal);
                    valList.remove(valList.size() - 1);
                    indexMap.remove(val);
                    indexMap.put(newVal, index);
                } else {
                    valList.remove(valList.size() - 1);
                    indexMap.remove(val);
                }
                return true;
            }
        }

        public int getRandom() {
            int index = random.nextInt(valList.size());
            return valList.get(index);
        }

    }
}
