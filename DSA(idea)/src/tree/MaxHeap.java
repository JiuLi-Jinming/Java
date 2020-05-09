package tree;

public class MaxHeap
{

    private int[] data;

    public MaxHeap(int[] data)
    {
        this.data = data;
        buildHeap();
    }

    private void buildHeap()
    {
        // 完全二叉树只有数组下标小于或等于 (data.length) / 2 - 1 的元素有孩子结点，遍历这些结点。
        // *比如上面的图中，数组有10个元素， (data.length) / 2 - 1的值为4，a[4]有孩子结点，但a[5]没有*
        for (int i = data.length/2-1; i >=0; i--) {
            heapify(i);
        }
    }

    private void heapify(int i)
    {
        int l = left(i);
        int r = right(i);

        int biggest = i;

        if (l < data.length && data[l] > data[i]) biggest = l;

        if (r < data.length && data[r] > data[i]) biggest = r;

        if (i == biggest) return;

        swap(i,biggest);
        heapify(biggest);
    }

    private int right(int i)
    {
        return (i + 1) << 1;
    }

    private int left(int i)
    {
        return ((i + 1) << 1) - 1;
    }

    private void swap(int i, int j)
    {
        int tmp = data[i];
        data[i] = data[j];
        data[j] = tmp;
    }

    public int getRoot()
    {
        return data[0];
    }

    public void setRoot(int root)
    {
        data[0] = root;
        heapify(0);
    }
}
