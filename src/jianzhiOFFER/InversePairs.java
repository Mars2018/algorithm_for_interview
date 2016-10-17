package jianzhiOFFER;

/**
 * Created by MarsWang on 2016/9/7.
 */
public class InversePairs {

   /* int inverses = 0;
    public void mergeSort(int[] array){
        mergeSort(array, 0, array.length-1);
    }

    private void mergeSort(int[] array, int left, int right) {
        if(left < right){
            int mid = (left+right) >> 1;
            mergeSort(array, left, mid);
            mergeSort(array, mid+1, right);
            merge(array, left, mid, right);
        }
    }

    private void merge(int[] array, int left, int mid, int right) {
        int leftSize = mid - left + 1;
        int rightSize = right - mid;
        int[] L = new int[leftSize];
        int[] R = new int[rightSize];
        int[] tmp = new int[right - left + 1];
        for (int i = left; i <= mid; ++i){
            L[i-left] = array[i];
        }
        for(int i = mid + 1; mid <= right; ++i)
            R[i-mid-1] = array[i];
        int l = 0, r = 0, k = 0;
        while(l < leftSize && r < rightSize){
            if(L[l] <= R[r])
                tmp[k++] = L[l++];
            else{
                tmp[k++] = R[r++];
                inverses += leftSize - l;
                if (inverses >= 1000000007)
                    inverses %= 1000000007;
            }
        }
        while (l < leftSize)
            tmp[k++] = L[l++];
        while (r < rightSize)
            tmp[k++] = R[r++];
        System.arraycopy(tmp,0,array,left,k);
    }*/
   public int InversePairs(int [] array) {
       if(array==null || array.length<=0){
           return 0;
       }
       int pairsNum=mergeSort(array,0,array.length-1);
       return pairsNum;
   }

    public int mergeSort(int[] array,int left,int right){
        if(left==right){
            return 0;
        }
        int mid=(left+right)/2;
        int leftNum=mergeSort(array,left,mid);
        int rightNum=mergeSort(array,mid+1,right);
        return (Sort(array,left,mid,right)+leftNum+rightNum)%1000000007;
    }

    public int Sort(int[] array,int left,int middle,int right){
        int current1=middle;
        int current2=right;
        int current3=right-left;
        int temp[]=new int[right-left+1];
        int pairsnum=0;
        while(current1>=left && current2>=middle+1){
            if(array[current1]>array[current2]){
                temp[current3--]=array[current1--];
                pairsnum+=(current2-middle);     //这个地方是current2-middle！！！！
                if(pairsnum>1000000007)//数值过大求余
                {
                    pairsnum%=1000000007;
                }
            }else{
                temp[current3--]=array[current2--];
            }
        }
        while(current1>=left){
            temp[current3--]=array[current1--];
        }
        while(current2>=middle+1){
            temp[current3--]=array[current2--];
        }
        //将临时数组赋值给原数组
        int i=0;
        while(left<=right){
            array[left++]=temp[i++];
        }
        return pairsnum;
    }
}
