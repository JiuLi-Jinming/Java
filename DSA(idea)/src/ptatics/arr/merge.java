package ptatics.arr;

public class merge
{
    /*
    合并有序数组
    双指针逆向查找
     */
    public void merge(int[] A, int m, int[] B, int n)
    {
        //p1 为 listA 前m个数组的指针， p2 为 listB 的指针，tail 为要直接修改的listA的指针
        int p1 = m-1, p2 = n-1;
        int tail = m + n - 1;

        //任意指针为零则修改完毕
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1)
                A[tail] = B[p2--];
            else if (p2 == -1)
                A[tail] = A[p1--];
            else if (A[p1] > B[p2])
                A[tail] = A[p1--];
            else
                A[tail] = B[p2--];
            tail--;
        }
    }
}
