package cmpe.sjsu.Misc;

import java.util.Scanner;

/*
Given a 6×6 2D Array, A:

1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
0 0 0 0 0 0
We can find 16 hourglasses in A; we define an hourglass in A to be a subset of values with indexes falling in this
pattern in A's graphical representation:

a b c
  d
e f g
The sum of an hourglass is the sum of the values within it.

Your task is to calculate the sum of every hourglass in some 2D Array, A, and print the largest value (maximum of the
sums) as your answer.

Output Format
Print the largest (maximum) hourglass sum found in A.

Sample Input
1 1 1 0 0 0
0 1 0 0 0 0
1 1 1 0 0 0
0 0 2 4 4 0
0 0 0 2 0 0
0 0 1 2 4 0

Sample Output
19
*/
public class HourGlass {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        int maxSum=Integer.MIN_VALUE;
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                if(j+2 < 6 && i+2 < 6 ){
                    int sum=arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+1]+arr[i+2][j]+arr[i+2][j+1]+arr[i+2][j+2];
                    if(sum>maxSum)
                        maxSum=sum;
                }
            }
        }
        System.out.println(maxSum);
    }

}
