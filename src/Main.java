import java.util.Arrays;
import java.util.Random;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Random ran = new Random();
        Integer[] array = new Integer[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = ran.nextInt(1000);
        }

        insertionSort(array);
        System.out.println(Arrays.toString(array));
    }

    // tim kiem tuyen tinh
    public static <T, E> int linearSearch(T[] arr, T value) {
        for (int i = 0; i < arr.length; i++) {
            //   System.out.printf("Duyet vong lap thu %d , gia tri laf %d \n",i,arr[i]);

            if (arr[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // tim kiem nhi phan
    public static <T extends Comparable<T>> int binarySearchNoRecursive(T[] arr, T value) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid].compareTo(value) > 0) {
                end = mid - 1;
            } else if (arr[mid].compareTo(value) < 0) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }


    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        boolean isNextPass = true;
        for (int i = 1; i < arr.length && isNextPass; i++) {  // gia su da sap xep roi
            isNextPass = false;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isNextPass = true;
                }
            }
        }
    }

    public static  <T extends Comparable<T>> void selectionSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
//            gia su vij tri vaf gia trij nho nhat
            int indexMin = i;
            T valueMin = arr[i];
            // tim gia tri nho nhat
            for (int j = i + 1; j < arr.length; j++) {
                if (valueMin.compareTo(arr[j]) < 0) {
                    indexMin = j;
                    valueMin = arr[j];
                }
            }

            // doi cho voi gia tri dau tien
            arr[indexMin] = arr[i]; // doi vi tri index min truoc
            arr[i] = valueMin;
        }
    }

    // sap xep chen
    public static <T> void insertionSort(T[] arr) {
        for (int i = 1; i < arr.length; i++) {
            T currentValue = arr[i];
            int j;
            for (j = i - 1; j >= 0 && currentValue.equals(arr[j]) ; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = currentValue;
        }
    }
}