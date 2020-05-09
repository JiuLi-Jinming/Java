package tree;

public class MinK {

    public static int[] minK(int[] data, int k)
    {
        int[] mink = new int[k];

        for (int i = 0; i < k; i++) {
            mink[i] = data[i];
        }

        MaxHeap heap = new MaxHeap(mink);

        for (int i = k; i < data.length; i++) {
            int root = heap.getRoot();

            if(data[i] < root)
                heap.setRoot(data[i]);
        }
        return mink;
    }

    public static void main(String[] args)
    {
        // 源数据
        int[] data = {56,275,12,6,45,478,41,1236,456,12,546,45};

// 获取Min5

        int[] min5 = minK(data, 5);

        for (int i = 0; i < 5; i++) {
            System.out.println(min5[i]);
        }
    }
}
