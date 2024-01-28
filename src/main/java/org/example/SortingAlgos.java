package org.example;
/*
Iterative Comparison Sorts
Bubble :
Shaker :
Selection :
Bidirectional selection :
Insertion :
Shell : 
Recursive Comparison Sorts
Mergesort : 
Quicksort
Heapsort
Non-Comparison Sorts
Counting Sort
Bucket Sort

 */

public class SortingAlgos {

    public static void bubble(int[] arr){
        Boolean swapped = false;
        for(int i = 0; i < arr.length - 1; i++){
            swapped = false;
            for(int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }



            if(!swapped) {
                break;
            }
        }
    }
    public static void shell(int[] arr){
        int gap = arr.length/2;
        while(gap > 0){
            for(int i = 0; i < arr.length; i = i + gap){
                int j = i ;
                while( j > 0 && arr[j] < arr[j-gap]){
                    int temp = arr[j];
                    arr[j] = arr[j-gap];
                    arr[j-gap] = temp;
                    j -= gap;
                }
            }
            gap /= 2; 
        }
    }

    public static void shaker(int[] arr){
        Boolean swapped = false;
        int m = 0;
        for(int i = 0; i < arr.length - 1; i++){
            swapped = false;
            for(int j = 0; j < arr.length - 1; j++){
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
                m = j;
            }
            while(arr[m] < arr[m-1] && m > 1){
                int temp = arr[m];
                arr[m] = arr[m-1];
                arr[m-1] = temp;
                m--;
            }



            if(!swapped) {
                break;
            }
        }
    }

    public static void insertion(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int j = i ;
            while( j > 0 && arr[j] < arr[j-1]){
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j -= 1;
            }
        }
    }

    public static void selection(int[] arr){
        for(int i = 0; i < arr.length; i++){
            int min = i;
            for(int j = i + 1; j < arr.length; j++){
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

    }

    public static int[] Merge(int[] left, int[] right) {
        //creating merged array and indexors
        int[] merged = new int[left.length + right.length];
        int l = 0, r = 0, m = 0;

        // while loop to merge
        while (l < left.length && r < right.length) {

            // left smaller case works by taking left into merged if left is smaller, then iterating left and merged
            if (left[l] < right[r]) {
                merged[m] = left[l];
                l++;
                m++;
            }
            // right smaller case works by taking right into merged if right is smaller, then iterating right and merged
            else if(left[l] > right[r]){
                merged[m] = right[r];
                r++;
                m++;
            }

            // if nothing left in left case then taking all from right by iterating through right and iterating merged and right
            if (l == left.length) {
                while(r < right.length) {
                    merged[m] = right[r];
                    r++;
                    m++;
                }
            }

            // if nothing left in right case then taking all from left by iterating through left and iterating merged and left
            else if (r == right.length) {
                while(l < left.length) {
                    merged[m] = left[l];
                    l++;
                    m++;
                }
            }
        }
        // returning the new merged section
        return merged;
    }

    public static int[] copyArr(int[] a, int start, int stop){
        // copy arr
        int[] copy = new int[stop-start];
        for (int i = start, j = 0; i < stop && j < stop - start; i++, j++){
            copy[j] = a[i];
        }
        return copy;
    }

    public static int[] MergeSort(int[] arr){
        // break case for if the array is a single object
        if(arr.length <= 1)
            return arr;
        int[] left = new int[arr.length/2];
        // creating left
        int[] right = new int[arr.length - left.length];
        // creating right
        //setting left = first half then right = right half
        left = copyArr(arr, 0, arr.length/2);
        right = copyArr(arr, arr.length/2, arr.length);
        //returning merge of merge sort of left and right
        return Merge(MergeSort(left), MergeSort(right));
    }

    public static void biSelection(int[] arr){
        int i = 0;
        while(i + 1 < arr.length - i){
            int min = i;
            int max = i;
            for(int j = i + 1; j < arr.length - i; j++){
                if (arr[j] < arr[min])
                    min = j;
                if (arr[j] > arr[max])
                    max = j;
            }

                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
                if(max == i){
                    temp = arr[min];
                    arr[min] = arr[arr.length - 1 - i];
                    arr[arr.length - 1 - i] = temp;
                }
                else {
                    temp = arr[max];
                    arr[max] = arr[arr.length - 1 - i];
                    arr[arr.length - 1 - i] = temp;
                }
            i++;
            }
    }


    static int partition(int[] arr, int start, int stop, int pivot){

    }
    static void quicksort(int[] arr, int start, int stop){
    
    }
	
    public static void bucket(){
	/*
	 *
	 * 
	 *
	 */

    }

    public static void main(String[] args) {
        int[] arr = {8,4,5,2,1,3,6,7};
        for (int x : arr) {
            System.out.println(x);
        }

        System.out.println("[");

        for (int x : arr) {
            System.out.println(x);
        }


    }
}

