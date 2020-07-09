package pratics.tree;

import java.util.PriorityQueue;
import java.util.Queue;

public class getLeastNumbers
{
    public int[] getLeastNumbers(int[] arr, int k)
    {
        if (arr.length == 0 || arr == null) return null;

        int[] res = new int[k];

        Queue<Integer> pq = new PriorityQueue<>((v1,v2) -> v2-v1);

        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        int i = 0;
        for (int num :
                pq) {
            res[i++] = num;
        }

        return res;
    }
}
