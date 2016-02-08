package cmpe.sjsu.Application;

import cmpe.sjsu.LinkedList.DoubleLinkedList;
import cmpe.sjsu.LinkedList.SingleLinkedList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        SingleLinkedList singleLinkedList = new SingleLinkedList();
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        ArrayList<Integer> arrayList=new ArrayList<>();
        File file = new File("resources/hackerrank_input.txt"); ;
        try

        {
            ArrayList<Integer> a=new ArrayList<>();
            Scanner sc = new Scanner(file);
            while (sc.hasNext()) {
                // add item to linkedlist from file.
                //doubleLinkedList.insertAtEnd(new Node(sc.next()));
                //arrayList.add(Integer.parseInt(sc.next()));
                System.out.println(sc.nextLine());
                Scanner sc1=new Scanner(sc.nextLine());
                while(sc1.hasNext()){
                    a.add(Integer.parseInt(sc1.next()));
                }

            }

            for( int i : a){
                System.out.println(i);}


            /* String Split Function
            System.out.print(sc.nextLine().toString());
            if(sc.hasNextLine())
            System.out.println(""); */

            /* Reverse Order Driver Code
            AlternateReverse alternateReverse= new AlternateReverse(singleLinkedList.getHead());
            alternateReverse.SplitAndMerge();

            */

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}
