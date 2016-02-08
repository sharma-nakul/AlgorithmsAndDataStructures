package cmpe.sjsu.Misc;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
Sample Input
3  -- This mean number of keys followed by this number.
sam
99912222
tom
11122222
harry
12299933
sam  -- Query starts from here
edward
harry


Sample Output

sam=99912222
Not found
harry=12299933

 */

/**
 * Created by Naks on 24-Jan-16.
 */
public class DictionaryUsingHashMap {

    public static void main(String []argh)
    {
        Map<String,Integer> dictionary=new HashMap<>();
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        in.nextLine();
        for(int i=0;i<N;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            dictionary.put(name,phone);
            in.nextLine();
        }
        while(in.hasNext())
        {
            String s=in.nextLine();
            if(dictionary.containsKey(s)){
                System.out.println(s+"="+dictionary.get(s));
            }
            else
                System.out.println("Not found");
        }
    }

}
