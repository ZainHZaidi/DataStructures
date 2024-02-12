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
Quicksort :
Heapsort
Non-Comparison Sorts
Counting Sort
Bucket Sort

 */
import java.util.*;
import java.io.*;
import java.time.*;

public class sortingOutSorting {

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
        int temp = arr[pivot];
        arr[pivot] = arr[stop];
        arr[stop] = temp;
        pivot = stop;

        int i = start;
        for(int j = start; j < stop; j++){
            if(arr[j] < arr[pivot]){
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                i++;
            }
        }
        temp = arr[pivot];
        arr[pivot] = arr[i];
        arr[i] = temp;

        return i;
    }

    static void quicksort(int[] arr, int start, int stop){
        if(stop > start){
            int pivot = partition(arr, start, stop, (stop-start)/2 + start);
            quicksort(arr, start, pivot - 1);
            quicksort(arr, pivot + 1, stop);
        }
    }static public void dequeue(int[] arr, int stop){
        if(stop == 0){return;}
        int temp = arr[0];
        arr[0] = arr[stop];
        arr[stop] = temp;
        int i = 0;
        int largerChild = largerChild(arr, i);
        while(largerChild < stop && arr[i] < arr[largerChild]) {
            temp = arr[i];
            arr[i] = arr[largerChild];
            arr[largerChild] = temp;
            i = largerChild;
            largerChild = largerChild(arr, i);
        }
        dequeue(arr, stop-1);
    }

    static private int largerChild(int[] arr, int pos) {
        int left = pos*2+1;
        int right = pos*2+2;
        if (left >= arr.length) return -1;
        int newPos = left;
        if (right < arr.length) {
            if (arr[right] > arr[(left)]) {
                newPos = right;
            }
        }
        return newPos;
    }
    public static int[] heapify(int[] list) {
        for (int i = list.length/2 - 1; i >= 0; i--) {
            heapifyHelper(list, i);
        }
        return list;
    }

    private static void heapifyHelper(int[] list, int pos) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        if (left >= list.length) return;
        int newPos = left;
        if (right < list.length) {
            if (list[right] > list[left]) {
                newPos = right;
            }
        }
        if (list[newPos] > list[pos]) {
            int temp = list[newPos];
            list[newPos] = list[pos];
            list[pos] = temp;
            heapifyHelper(list, newPos);
        }
    }

    public static void heapSort(int[] arr){
        heapify(arr);
        dequeue(arr, arr.length-1);
    }

    public static int count(int[] array) {
        int c = 0;
        for(int el: array) { if(el != 0) c++; }
        return c;
    }

	
    public static int[][] bucket(int[] arr){
        int max = arr[0];
        for(int x: arr){
            if(x > max){
                max = x;
            }
        }
        int n = max/3;
        int[][] buckets = new int[max][arr.length];
        for(int x : arr){
            buckets[x/3][count(buckets[x/3])] = x;
        }
        for(int[] bucket : buckets){
            insertion(bucket);
        }
        return buckets;
    }

    public static int[] counting(int[] arr){
        int max = arr[0];
        for(int x: arr){
            if(x > max){
                max = x;
            }
        }
        int[] cArr = new int[max+1];

        for (int i = 0; i < arr.length; i++)
            cArr[arr[i]]++;


        int[] fin = new int[arr.length];
        int y = 0;

        for (int i = 0; i < cArr.length; i++) {
            for(int x = 0; x < cArr[i]; x++){
                fin[y] = i;
                y++;
            }
        }

        return fin;
    }

    public static int[][] getArrays(String fileName, int n){
        //open a scanner for the file passed in
        try{
            Scanner in = new Scanner(new File(fileName));
            int[][] output = new int[100][n];
            for (int i = 0; i < 100; i++){
                int[] arr = new int[n];
                String s = in.next();
                String[] line = s.split(",");
                for (int j = 0; j < n; j++){
                    arr[j] = Integer.valueOf(line[j]);
                }
                output[i] = arr;
            }
            in.close();
            return output;
        }
        catch(Exception e){ System.out.println(e); }
        return null;
    }

    @SuppressWarnings("deprecation")
    public static int[] deepCopy(int[] arr) {
        int[] cpy = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            cpy[i] = arr[i];
        }
        return cpy;
    }

    public static long measureTime(int[] arr) {
        int[] z = deepCopy(arr);
        long start = System.nanoTime();
        bucket(z);
        long end = System.nanoTime();
        return end - start;
    }


    public static void output(long[] data, String fileName){
        // use this to output the average runtime for each size
        // of a given algorithm
        try{
            File f = new File(fileName);
            if (f.createNewFile()) System.out.println("created file");
            else { System.out.println("File already exists");}
            FileWriter write = new FileWriter(fileName);
            for (int i = 0; i < data.length; i++){
                write.write(Long.toString(data[i]));
                write.write("\n");
            }
            write.close();
        }
        catch(Exception e) {System.out.println(e);}
    }


    public static void main(String[] args) {
        //initializing paths and times
        long[] times = new long[6];
        int[] ns = {10,50,100,500,1000,5000};
        String[] paths = {
                "C:\\Users\\Zain\\IdeaProjects\\DataStructures\\src\\main\\java\\org\\example\\arrays10.txt",
                "C:\\Users\\Zain\\IdeaProjects\\DataStructures\\src\\main\\java\\org\\example\\arrays50.txt",
                "C:\\Users\\Zain\\IdeaProjects\\DataStructures\\src\\main\\java\\org\\example\\arrays100.txt",
                "C:\\Users\\Zain\\IdeaProjects\\DataStructures\\src\\main\\java\\org\\example\\arrays500.txt",
                "C:\\Users\\Zain\\IdeaProjects\\DataStructures\\src\\main\\java\\org\\example\\arrays1000.txt",
                "C:\\Users\\Zain\\IdeaProjects\\DataStructures\\src\\main\\java\\org\\example\\arrays5000.txt",
        };
        for(int j = 0; j < 6; j++){
            int[][] arrays = getArrays(paths[j], ns[j]);
            long sum = 0;
            for(int i = 0; i < arrays.length; i++){
                sum += measureTime(arrays[i]);
            }
            System.out.println(sum);
        }
    }
}

