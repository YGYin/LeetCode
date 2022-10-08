package array.traversal;

public class FindPoisonedDuration_495 {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int total = 0, poisoning = 0;
        for (int i = 0; i < timeSeries.length; ++i) {
            // if it is not in poisoning
            if (timeSeries[i] > poisoning)
                total += duration;
            else // it was in poisoning
                total += timeSeries[i] + duration - poisoning;
            poisoning = timeSeries[i] + duration;
        }
        return total;
    }
}
