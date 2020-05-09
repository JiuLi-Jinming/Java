package tree;

import static tree.MinK.minK;

public class TopK {

    // 从data数组中获取最大的k个数
    private static int[] topK(int[] data,int k)
    {
        // 先取K个元素放入一个数组topk中
        int[] topk = new int[k];
        for(int i = 0;i< k;i++)
        {
            topk[i] = data[i];
        }

        // 转换成最小堆
        MinHeap heap = new MinHeap(topk);

        heap.add(10000);

        // 从k开始，遍历data
        for(int i= k;i<data.length;i++)
        {
            int root = heap.getRoot();

            // 当数据大于堆中最小的数（根节点）时，替换堆中的根节点，再转换成堆
            if(data[i] > root)
            {
                heap.setRoot(data[i]);
            }
        }
        heap.delete(1236);

        return topk;
    }

    public static void main(String[] args)
    {
        // 源数据
        int[] data = {56,275,12,6,45,478,41,1236,456,12,546,45};

// 获取Top5
        int[] top5 = topK(data, 5);

        for(int i=0;i<5;i++)
        {
            System.out.println(top5[i]);
        }

    }

}
