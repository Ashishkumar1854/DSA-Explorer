public class mergeSort {

  // Merge function: combines two sorted sub-arrays into one
  public static void merge(int[] arr, int start, int mid, int end) {
    // Create temp array to store merged result
    int left = start; // Pointer for left subarray
    int right = mid + 1; // Pointer for right subarray
    int[] temp = new int[end - start + 1];
    int index = 0; // Pointer for temp array

    // Compare elements from both halves and store in temp[]
    while (left <= mid && right <= end) {
      if (arr[left] <= arr[right]) {
        temp[index] = arr[left];
        index++;
        left++;
      } else {
        temp[index] = arr[right];
        index++;
        right++;
      }
    }

    // Left part not empty
    while (left <= mid) {
      temp[index] = arr[left];
      index++;
      left++;
    }

    // Right part not empty
    while (right <= end) {
      temp[index] = arr[right];
      index++;
      right++;
    }

    // Put temp array back into original array
    index = 0;
    while (start <= end) {
      arr[start] = temp[index];
      index++;
      start++;
    }
  }

  // Recursive merge sort function
  public static void mergeSort(int[] arr, int start, int end) {
    // Base case
    if (start == end) {
      return;
    }

    int mid = start + (end - start) / 2;

    // Left side of the array
    mergeSort(arr, start, mid);

    // Right side of the array
    mergeSort(arr, mid + 1, end);

    // Merge the two halves
    merge(arr, start, mid, end);
  }

  public static void main(String[] args) {
    int[] arr = { 38, 27, 43, 3, 9, 82, 10 };

    // Call merge sort on full array
    mergeSort(arr, 0, arr.length - 1);

    // Print sorted array
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
  }
}
