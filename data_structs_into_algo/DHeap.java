public class DHeap {

    private int _d;

    // Counters for comparisons and assignments
    int compare_cnt = 0;
    int assign_cnt = 0;


    /**
     * Constructs and initializes d-heap object with a given d (number of children per node)
     * @param d
     */
    public DHeap(int d) {
        if (d <= 1) {
            throw new IllegalArgumentException("d must be greater than 1");
        }
        _d = d;
    }

    private void initCounters() {
        compare_cnt = 0;
        assign_cnt = 0;
    }
    /**
     * given an array, sort it in ascending order
     * @param arr
     */
    public void sort(int arr[]) {

        if (arr == null || arr.length == 0) {
            return; // Handle null or empty array
        }
        initCounters();

        buildDMaxHeap(arr);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapify(arr, 0, i);
        }        

    }


    /**
     * get the k^th child index
     * @param i - node index
     * @param k - k^th child
     * @return the index of the left child
     */
    private int child(int k, int i) {
        return _d * i + k + 1;
    }

    /**
     * build a max d-heap
     */
    public void buildDMaxHeap(int arr[]) {
        int n = arr.length;
        for (int i = (n - 2)/ _d; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * d-heapify the array
     * @param arr - array
     * @param i - index
     * @param n - size
     */
    public void heapify(int arr[], int i, int n) {
        
        int largest_idx = i;
        for (int k = 0; k < _d; k++) {
            int ch_idx = child(k, i);
            if (ch_idx < n && arr[ch_idx] > arr[largest_idx]) {
                compare_cnt++;
                largest_idx = ch_idx;
            }
        }
        if (largest_idx != i){
                swap(arr, largest_idx, i);
                heapify(arr, largest_idx, n);
        }
    }

    /**
     * swap two elements in an array
     * @param arr - array
     * @param i - index
     * @param j - index
     */
    public void swap(int arr[], int i, int j){
        assign_cnt += 3;
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * check if the array is a valid d-heap
     * @param arr - array
     * @return true if the array is a valid d-heap
     */
    public boolean validHeap(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int k = 0; k < _d; k++) {
                int ch_idx = child(k, i);
                if (ch_idx < n && arr[ch_idx] > arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    
}
