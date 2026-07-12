# 981. [Time Based Key-Value Store](https://leetcode.com/problems/time-based-key-value-store/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/time-based-key-value-store/](https://leetcode.com/problems/time-based-key-value-store/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `142 ms`
- **Memory:** `108.2 MB`
- **Solved Date:** July 12, 2026 (05:37 UTC)

---

## 💻 Solution
```java
class Pair{
    int timestamp;
    String value;

    Pair(int timestamp, String value){
        this.timestamp = timestamp;
        this.value = value;
    }
}

class TimeMap {

    HashMap<String, List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {

        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(timestamp, value));
    }

    public String get(String key, int timestamp) {

        if(!map.containsKey(key)){
            return "";
        }

        List<Pair> list = map.get(key);

        int left = 0;
        int right = list.size() - 1;

        String ans = "";

        while(left <= right){

            int mid = left + (right-left)/2;

            if(list.get(mid).timestamp == timestamp){
                return list.get(mid).value;
            }

            if(list.get(mid).timestamp < timestamp){
                ans = list.get(mid).value;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
```
