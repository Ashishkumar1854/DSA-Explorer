package practices.array;

public class NextPermutation {

  void nextPermutation(int[] arr) {
    int n = arr.length;
    int pivot = -1;

    // Step 1: Find pivot
    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] < arr[i + 1]) {
        pivot = i;
        break;
      }
    }

    // Step 2: If no pivot, reverse whole array
    if (pivot == -1) {
      reverse(arr, 0, n - 1);
      return;
    }

    // Step 3: Find element just larger than pivot and swap
    for (int i = n - 1; i > pivot; i--) {
      if (arr[i] > arr[pivot]) {
        swap(arr, i, pivot);
        break;
      }
    }

    // Step 4: Reverse the part after pivot
    reverse(arr, pivot + 1, n - 1);
  }

  private void reverse(int[] arr, int start, int end) {
    while (start < end) {
      swap(arr, start, end);
      start++;
      end--;
    }
  }

  private void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void main(String[] args) {
    NextPermutation np = new NextPermutation();
    int[] arr = { 1, 2, 3 };

    np.nextPermutation(arr);

    for (int num : arr) {
      System.out.print(num + " ");
    }
  }
}
