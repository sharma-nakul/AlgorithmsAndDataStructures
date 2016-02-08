package cmpe.sjsu.Misc;

/*
In this problem you will test your knowledge of loops. Given three integers a, b, and N, output the following series:

Series -> a+20b,a+20b+21b,......,a+20b+21b+...+2N?1b

Input Format
The first line will contain the number of testcases T. Each of the next T lines will have three integers, a, b, and N.

Output Format
Print the answer to each test case in a separate line.

Sample Input
2
5 3 5
0 2 10

Sample Output
8 14 26 50 98
2 6 14 30 62 126 254 510 1022 2046

Explanation
There are two test cases.
In the first case: a=5, b=3 ,N=5
1st term =   5+(20×3)=8
2nd term = 5+(20×3)+(21×3)=14
3rd term =  5+(20×3)+(21×3)+(22×3)=26
4th term =  5+(20×3)+(21×3)+(22×3)+(23×3)=50
5th term =  5+(20×3)+(21×3)+(22×3)+(23×3)+(24×3)=98
*/

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Naks on 24-Jan-16.
 *
 */
public class MathematicalSeries {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        ArrayList<Integer> in=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int noOfInputs = sc.nextInt();
        int sum=0;
        for(int i=0;i<noOfInputs;i++)
        {
            int count=1;
            while(count<=3){
                in.add(sc.nextInt());
                if(count==3)
                {
                    int N=in.get(2), a=in.get(0), b=in.get(1);
                    sum=a;
                    for(int k=0;k<N;k++){
                        sum=sum+(((int)Math.pow(2,k))*b);
                        System.out.print(sum+" ");
                    }
                }
                count++;
            }
            in.clear();
            System.out.print("\n");
        }


    }
}
