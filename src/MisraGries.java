import java.util.HashMap;

public class MisraGries {

    HashMap<Integer, Integer> map = new HashMap<>();

    public HashMap<Integer, Integer> misraGries(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i]))
                map.put(arr[i], map.get(arr[i]) + 1);
            else if (map.size() < k - 1)
                map.put(arr[i], 1);
            else {
                for (int key : map.keySet()) {
                    map.put(key, map.get(key) - 1);
                    if (map.get(key) == 0)
                        map.remove(key);
                }
            }
            System.out.println(map);
        }
        return map;
    }

    public static void main(String[] args) {
        MisraGries ms = new MisraGries();
        int[] arr = {8, 7, 3, 6, 5, 8, 9, 4, 2, 4, 3, 8, 6, 8, 3, 7, 5, 8, 7, 2, 3, 4, 6, 5, 9, 4, 3, 8, 4, 8, 3, 1, 7, 6, 4, 8, 9};
        HashMap<Integer, Integer> res = ms.misraGries(arr, 7);
        for (int key : res.keySet())
            System.out.println("Key: " + key + " val: " + res.get(key));

    }
}
