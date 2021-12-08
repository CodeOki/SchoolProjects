import java.util.*;

public class Sorts {
private static Scanner sc = new Scanner(System.in);

private static int qckCompare = 0;
private static int qckIntrChng = 0;
private static int mrgCompare = 0;
private static int mrgIntrChng = 0;

private static int[] userInput(int num) {
int tmpArr[] = new int[num];
System.out.println("Enter the values");
for (int k = 0; k < num; k++)
tmpArr[k] = sc.nextInt();
return tmpArr;
}

private static void bSort(int arr[], int num) {
int tmpVal, cmpVal = 0, intrChng = 0;
for (int k = 0; k < num - 1; k++) {
for (int l = 0; l < num - k - 1; l++) {
cmpVal += 1;
if (arr[l] > arr[l + 1]) {
intrChng += 1;
tmpVal = arr[l];
arr[l] = arr[l + 1];
arr[l + 1] = tmpVal;
}
}
}
System.out.println("Comparisions: " + cmpVal);
System.out.println("InterChanges: " + intrChng);
}

private static int division(int arr[], int l, int h) {
int tmpVal, pvtEle = arr[h];
int m = l - 1;
for (int n = l; n <= h - 1; n++) {
qckCompare += 1;
if (arr[n] <= pvtEle) {
qckIntrChng += 1;
m++;
tmpVal = arr[m];
arr[m] = arr[n];
arr[n] = tmpVal;
}
}
tmpVal = arr[m + 1];
arr[m + 1] = arr[h];
arr[h] = tmpVal;
return m + 1;
}

private static void qckSortEle(int arr[], int l, int h) {
if (l < h) {
int t = division(arr, l, h);
qckSortEle(arr, l, t - 1);
qckSortEle(arr, t + 1, h);

}
}

private static void mrgEle(int arr[], int p, int q, int t) {
int a, b, f;
int n1 = q - p + 1, n2 = t - q;
int L[] = new int[n1], R[] = new int[n2];
for (a = 0; a < n1; a++) L[a] = arr[p + a];
for (b = 0; b < n2; b++) R[b] = arr[q + b + 1];
a = 0;
b = 0;
f = p;
mrgCompare += 1;
while (a < n1 && b < n2) {
mrgIntrChng += 1;
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
mrgEle(arr, left, mid, right);
}
}

public static void main(String args[]) {
int num;
System.out.print("Enter the number of elements in the array: ");
num = sc.nextInt();
int inp[] = new int[num];
inp = userInput(num);
System.out.println("\nBubble Sort");
bSort(inp, num);
System.out.println("\nQuick Sort");
qckSortEle(inp, 0, num - 1);
System.out.println("No of Comparisions: " + qckCompare);
System.out.println("InterChanges: " + qckIntrChng);
System.out.println("\nMerge Sort");
mrst(inp, 0, num - 1);
System.out.println("No of Comparisions: " + mrgCompare);
System.out.println("InterChanges: " + mrgIntrChng);
}
}