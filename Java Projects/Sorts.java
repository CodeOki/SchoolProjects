import java.util.*;

public class Sorts {
   private static Scanner sc = new Scanner(System.in);

   private static int quickCompare = 0;
   private static int quickInterchange = 0;
   private static int mergeCompare = 0;
   private static int mergeInterchange = 0;

   private static int[] userInput(int num) {
      int tempArr[] = new int[num];
      System.out.println("Enter the values");
      for (int k = 0; k < num; k++)
      tempArr[k] = sc.nextInt();
      return tempArr;
   }

   private static void bubbleSort(int arr[], int num) {
      int tempVal, compareVal = 0, interchange = 0;
      for (int k = 0; k < num - 1; k++) {
      for (int l = 0; l < num - k - 1; l++) {
         compareVal += 1;
      if (arr[l] > arr[l + 1]) {
         interchange += 1;
         tempVal = arr[l];
         arr[l] = arr[l + 1];
         arr[l + 1] = tempVal;
      }
      }
      }
      System.out.println("Comparisions: " + compareVal);
      System.out.println("InterChanges: " + interchange);
   }

   private static int division(int arr[], int l, int h) {
      int tempVal, pvtEle = arr[h];
      int m = l - 1;
      for (int n = l; n <= h - 1; n++) {
      quickCompare += 1;
      if (arr[n] <= pvtEle) {
      quickInterchange += 1;
      m++;
      tempVal = arr[m];
      arr[m] = arr[n];
      arr[n] = tempVal;
      }
      }
      tempVal = arr[m + 1];
      arr[m + 1] = arr[h];
      arr[h] = tempVal;
      return m + 1;
   }

   private static void quickSortElement(int arr[], int l, int h) {
      if (l < h) {
      int t = division(arr, l, h);
      quickSortElement(arr, l, t - 1);
      quickSortElement(arr, t + 1, h);   
      }
   }

   private static void mergeElement(int arr[], int p, int q, int t) {
      int a, b, f;
      int n1 = q - p + 1, n2 = t - q;
      int L[] = new int[n1], R[] = new int[n2];
      for (a = 0; a < n1; a++) L[a] = arr[p + a];
      for (b = 0; b < n2; b++) R[b] = arr[q + b + 1];
      a = 0;
      b = 0;
      f = p;
      mergeCompare += 1;
      while (a < n1 && b < n2) {
      mergeInterchange += 1;
      if (L[a] <= R[b])
      arr[f++] = L[a++];
      else arr[f++] = R[b++];
      }
      while (a < n1) arr[f++] = L[a++];
      while (b < n2) arr[f++] = R[b++];
   }
   private static void mrst(int arr[], int left, int right) {
      if (left < right) {
      int mid = left + (right - left) / 2;
      mrst(arr, left, mid);
      mrst(arr, mid + 1, right);
      mergeElement(arr, left, mid, right);
      }
   }
   
   public static void main(String args[]) {
      int num;
      System.out.print("Enter the number of elements in the array: ");
      num = sc.nextInt();
      int inp[] = new int[num];
      inp = userInput(num);
      System.out.println("\nBubble Sort");
      bubbleSort(inp, num);
      System.out.println("\nQuick Sort");
      quickSortElement(inp, 0, num - 1);
      System.out.println("No of Comparisions: " + quickCompare);
      System.out.println("InterChanges: " + quickInterchange);
      System.out.println("\nMerge Sort");
      mrst(inp, 0, num - 1);
      System.out.println("No of Comparisions: " + mergeCompare);
      System.out.println("InterChanges: " + mergeInterchange);
   }
   
}