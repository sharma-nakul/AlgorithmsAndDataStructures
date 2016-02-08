package cmpe.sjsu.Misc;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Naks on 25-Jan-16.
 *
 */
public class BinaryNumberConversion {
    ArrayList<Integer> arr=new ArrayList<>();

    public int binary_conv(int n){
        if(n/2==1 && n%2==0){
            arr.add(0);
            return 1;}
        else if (n/2==1 && n%2==1){
            arr.add(1);
            return 0;
        }

        else{
            //System.out.print(n%2);
            arr.add(n%2);
            return binary_conv(n/2);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int n;
        //System.out.println(N);
        BinaryNumberConversion s =new BinaryNumberConversion();

        for(int k=1;k<=N;k++){
            n=sc.nextInt();
            s.arr.add(s.binary_conv(n));
            for(int i=s.arr.size()-1;i>=0;i--)
                System.out.print(s.arr.get(i));
            s.arr.clear();
            System.out.println("");
        }

    }
}
