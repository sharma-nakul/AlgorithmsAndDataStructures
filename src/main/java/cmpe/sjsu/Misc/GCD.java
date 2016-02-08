package cmpe.sjsu.Misc;

import java.util.Scanner;

/*
Euclid's Algorithm for Computing the GCD of two integers

Given two integers, x and y, their GCD (greatest common divisor) can be calculated recursively using Euclid's Algorithm,
which essentially says that if x equals y, then GCD(x,y)=x; otherwise, GCD(x,y)=GCD(x?y,y) if x>y. Note that this logic
can be further optimized for a more efficient implementation.

Explanation

We are given x=1 and y=5. This explanation uses the subtraction implementation mentioned in the problem description,
and is outlined in pseudocode below:

int GCD(x,y):
    If x equals y, return x;
    Else, return GCD(x',y'), where x' = MAX(x,y) - MIN(x,y) and y' = MIN(x,y).
GCD(1,5): 1?5, so return a call to GCD(5?1,1).
GCD(4,1): 4?1, so return a call to GCD(4?1,1).
GCD(3,1): 3?1, so return a call to GCD(3?1,1).
GCD(2,1): 2?1, so return a call to GCD(2?1,1).
GCD(1,1): 1=1, so we return x (which is 1).

The final return is passed back through the call stack as the return value for the original call. That is to say,
GCD(1,1) returns 1 to GCD(2,1), the function that originally called it. GCD(2,1) then returns it to GCD(3,1), which
returns it to GCD(4,1), which returns it to GCD(1,5). Thus GCD(1,5) returns a value of 1, which we print as our answer.
 */

/**
 * Created by Naks on 24-Jan-16.
 */
public class GCD {

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        int gcd=find_gcd(a,b);
        System.out.println(gcd);
    }
    static  int find_gcd(int a,int b){
        if(a==b)
            return a;
        else if (a>b)
            return find_gcd(a-b,b);
        return find_gcd(b-a,a);
    }

}
