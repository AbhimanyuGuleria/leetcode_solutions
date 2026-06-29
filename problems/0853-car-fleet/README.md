# 853. [Car Fleet](https://leetcode.com/problems/car-fleet/)

## 📌 Problem Information
- **Difficulty:** 🟡 Medium
- **LeetCode Link:** [https://leetcode.com/problems/car-fleet/](https://leetcode.com/problems/car-fleet/)

## ⚡ Submission Stats
- **Language:** `Java`
- **Runtime:** `88 ms`
- **Memory:** `95.3 MB`
- **Solved Date:** June 29, 2026 (10:37 UTC)

---

## 💻 Solution
```java
class Solution {

    public int carFleet(int target, int[] position, int[] speed) {

        double[][] cars = new double[position.length][2];

        for(int i = 0; i < position.length; i++){

            cars[i][0] = position[i];

            cars[i][1] = (double)(target - position[i]) / speed[i];

        }

        Arrays.sort(cars, (a,b) -> Double.compare(a[0], b[0]));

        int fleets = 0;

        double fleetTime = 0;

        for(int i = cars.length-1; i>=0; i--){

            double currentTime = cars[i][1];

            if(currentTime > fleetTime){

                fleets++;

                fleetTime = currentTime;

            }

        }

        return fleets;
    }
}
```
