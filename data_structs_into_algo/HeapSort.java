public class HeapSort {


    public void sort(int arr[]) {
        buildMaxHeap(arr);

        for (int i = arr.length - 1; i >=0; i--) {
            swap(arr, i, 0);
            heapify(arr, i,0);
        }
    }


    private int left(int i) {
        return (2 * i) + 1;
    }

    private int right(int i) {
        return (2 * i) + 2;
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }
    public void buildMaxHeap(int arr[]) {
        int n = arr.length;
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * 
     * @param arr - array
     * @param i - index
     * @param n - size
     */
    public void heapify(int arr[], int i, int n) {
        int l = left(i);
        int r = right(i);
        int largest = i;

        if (l < n && arr[l] > arr[i])
            largest = l;

        if (r < n && arr[r] > arr[largest])
            largest = r;

        if (largest != i){
                swap(arr, largest, i);
                heapify(arr, largest, n);
        }
    }

    public void swap(int arr[], int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
