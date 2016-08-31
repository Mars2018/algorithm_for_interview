import java.util.Arrays;

/**
 * Created by mars_wang on 2016/8/15.
 */
public class Sort {
    public static void main(String[] args) {

        int[] arrOrigin = {10, 3, 6, 7, 12, 15, 63, 100, 7, 8, 13, 56, 32, 74};
        int[] arrCopy  = Arrays.copyOf(arrOrigin, arrOrigin.length);


        bubbleSort(arrCopy);
        System.out.println("\n********Bubble Sort********");
        System.out.print(Arrays.toString(arrCopy));
        arrCopy  = Arrays.copyOf(arrOrigin, arrOrigin.length);

        insertionSort(arrCopy);
        System.out.println("\n\n********Insertion Sort********");
        System.out.println(Arrays.toString(arrCopy));
        arrCopy  = Arrays.copyOf(arrOrigin, arrOrigin.length);

        selectionSort(arrCopy);
        System.out.println("\n********Selection Sort********");
        System.out.println(Arrays.toString(arrCopy));
        arrCopy = Arrays.copyOf(arrOrigin, arrOrigin.length);

        mergeSort(arrCopy);
        System.out.println("\n********Merge Sort********");
        System.out.println(Arrays.toString(arrCopy));
        arrCopy = Arrays.copyOf(arrOrigin, arrOrigin.length);

        quickSort(arrCopy);
        System.out.println("\n********Quick Sort********");
        System.out.println(Arrays.toString(arrCopy));


    }

    private static void quickSort(int[] arrCopy) {
        recuriveQuickSort(arrCopy, 0, arrCopy.length-1);
    }

    private static void recuriveQuickSort(int[] arrCopy, int l, int r) {
        if(l < r){
            int m = partition2(arrCopy, l, r);
            recuriveQuickSort(arrCopy, l, m-1);
            recuriveQuickSort(arrCopy, m+1, r);
        }

    }

    private static int partition(int[] arrCopy, int l, int r) {
        int  i = l - 1;
        int pivot = arrCopy[r];
        for(int j = l; j < r; ++j){
            if(arrCopy[j] < pivot){
                ++i;
                swap(arrCopy, i, j);
            }

        }
        swap(arrCopy, i+1, r);
        return i+1;
    }

    private static int partition2(int[] arrCopy, int l, int r){
        int low = l, high = r;
        int x = arrCopy[low];
        while (low < high){
            while (low < high && arrCopy[high] >= x)
                high--;
            while (low < high && arrCopy[low] <= x)
                low++;
            if(low < high){
                swap(arrCopy, low, high);
            }
        }
        arrCopy[l] = arrCopy[low];
        arrCopy[low] = x;
        return low;
    }

    private static void mergeSort(int[] arrCopy) {
        mergeSort(arrCopy, 0, arrCopy.length-1);
    }

    private static void mergeSort(int[] arrCopy, int i, int j) {
        if(i < j){
            int mid = (i+j)>>1;
            mergeSort(arrCopy, i, mid);
            mergeSort(arrCopy, mid+1, j);
            merge(arrCopy,i,mid,j);
        }
    }

    private static void merge(int[] arrCopy, int l, int mid, int r) {
        int a = mid - l + 1;
        int b = r - mid;
        int[] L = new int[a];
        int[] R = new int[b];
        for(int i = 0; i < a; ++i)
            L[i] = arrCopy[l+i];
        for(int i = 0; i < b; ++i)
            R[i] = arrCopy[mid + i + 1];
        int i = 0, j = 0, k = l;
        while (i < a && j < b){
            if(L[i] <= R[j]){
                arrCopy[k++] = L[i];
                ++i;
            }else {
                arrCopy[k++] = R[j];
                ++j;
            }
        }
        while (i < a){
            arrCopy[k++] = L[i++];
        }
        while (j < b){
            arrCopy[k++] = R[j++];
        }

    }

    private static void selectionSort(int[] arrCopy) {
        for(int i = 0; i < arrCopy.length - 1; ++i){
            int min = i;
            for(int j = i+1; j < arrCopy.length; ++j){
                if(arrCopy[min] > arrCopy [j])
                    min = j;
            }
            swap(arrCopy, i, min);
        }
    }

    private static void swap(int[] arrCopy, int i, int j) {
        if(i == j)
            return;
        int temp = arrCopy[i];
        arrCopy[i] = arrCopy[j];
        arrCopy[j] = temp;
    }

    private static void insertionSort(int[] arrCopy) {
        for(int i = 1; i < arrCopy.length; ++i){
            int j = i - 1;
            int key = arrCopy[i];
            while(j >= 0 && key < arrCopy[j]){
                arrCopy[j+1] = arrCopy[j];
                j--;
            }
            arrCopy[j+1] = key;
        }
    }

    private static void bubbleSort(int[] arr) {
        for(int i = 0; i < arr.length; ++i)
            for(int j = 0; j < arr.length - i - 1; ++j){
                if(arr[j] > arr[j+1]){
                    swap(arr, i, j);
                }
            }
    }

    public static void heapSort(int[] arr){
        buildHeap(arr);
        int n = arr.length;
        for(int i = n - 1; i >=1; --i ){
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }
    }

    private static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = n/2-1; i >= 0 ; --i){
            heapify(arr, i, n);
        }
    }

    private static void heapify(int[] arr, int index, int max) {
        int left = 2*index + 1;//左孩子
        int right = 2 * index + 2;//右孩子
        int largest = 0;//三个值的最大值
        if (left < max && arr[left] > arr[index])
            largest = left;
        else
            largest = index;
        if (right > max && arr[right] > arr[largest])
            largest = right;
        if (largest != index){
            swap(arr, largest,index);
            heapify(arr, largest, max);
        }

    }


}
