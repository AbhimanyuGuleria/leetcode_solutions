# 853. [Car Fleet](https://leetcode.com/problems/car-fleet/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/car-fleet/](https://leetcode.com/problems/car-fleet/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `87 ms`
- **Memory:** `95.4 MB`
- **Solved Date:** June 30, 2026 (06:07 UTC)

---

## 💻 Solution
```java
class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];

        for(int i = 0; i <position.length; i++){
            cars[i][0] = position[i];
            cars[i][1] = (double)(target - position[i])/speed[i];
        }

        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));

        int fleet = 0;
        double fleetTime = 0;

        for(int i= position.length-1; i>=0;i--){
            double currentTime = cars[i][1];

            if(currentTime > fleetTime){
                fleet++;
                fleetTime = currentTime;
            }
        }
        return fleet;

    }
}
```
