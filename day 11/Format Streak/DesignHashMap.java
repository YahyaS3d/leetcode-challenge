class MyHashMap {
    private static final int SIZE = 10000;
    private LinkedList<Entry>[] buckets;

    public MyHashMap() {
        buckets = new LinkedList[SIZE];
    }

    public void put(int key, int value) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            buckets[index] = new LinkedList<>();
        }

        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                entry.value = value;
                return;
            }
        }

        buckets[index].add(new Entry(key, value));
    }

    public int get(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return -1;
        }

        for (Entry entry : buckets[index]) {
            if (entry.key == key) {
                return entry.value;
            }
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);
        if (buckets[index] == null) {
            return;
        }

        Iterator<Entry> iterator = buckets[index].iterator();
        while (iterator.hasNext()) {
            if (iterator.next().key == key) {
                iterator.remove();
                return;
            }
        }
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    private static class Entry {
        int key;
        int value;

        public Entry(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
