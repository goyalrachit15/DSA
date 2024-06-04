package alpha;

import java.util.Arrays;
// import java.util.Scanner;

public class divideandconquer {

    public static void print(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si; // iterator for left array
        int j = mid + 1; // iterator for right array
        int k = 0;

        // comapring elements in left and right array and merging them accordingly
        while (i <= mid && j <= ei) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // for elements left in left array
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        // for elements left in right array
        while (j <= ei) {
            temp[k++] = arr[j++];
        }

        // to copy sorted array from temp to original array
        for (k = 0, i = si; k < ei - si + 1; k++, i++) {
            arr[i] = temp[k];
        }
    }

    public static void mergesort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);
        merge(arr, si, mid, ei);
    }

    public static int partition(int arr[], int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }
        i++;
        int temp = pivot;
        arr[ei] = arr[i];
        arr[i] = temp;
        return i;

    }

    public static void quicksort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int par_index = partition(arr, si, ei);
        quicksort(arr, si, par_index - 1);
        quicksort(arr, par_index + 1, ei);
    }

    public static int search(int arr[], int target, int si, int ei) {
        int mid = (si + ei) / 2;

        if (si > ei) {
            return -1;
        }

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[si] <= arr[mid]) {

            if (arr[si] <= target && target < arr[mid]) {
                return search(arr, target, si, mid - 1);
            } else {
                return search(arr, target, mid + 1, ei);
            }
        }

        else {
            if (target > arr[mid] && target < arr[ei]) {
                return search(arr, target, mid + 1, ei);
            } else {
                return search(arr, target, si, mid - 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { -2, 0, 3, 2, 5, 3, 44 };
        // mergesort(arr, 0, arr.length-1);
        // quicksort(arr, 0, arr.length-1);
        // print(arr);
        Arrays.sort(arr);
        // System.out.println(search(arr, 44, 0, arr.length-1));

        int si = 0;
        int ei = arr.length - 1;
        int target = 44;
        int mid = (si + ei) / 2;
        while (si <= ei) {
            if (arr[mid] == target) {
                System.out.println(mid);
                return;
            }

            if (arr[si] <= arr[mid]) {

                if (arr[si] <= target && target < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }

            else {
                if (target > arr[mid] && target < arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
            mid = (si + ei) / 2;
        }
    }
}
