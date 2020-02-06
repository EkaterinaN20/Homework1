package Lesson_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class HW3 {
    private static String path1 = "123/2.txt";
    // pages for the 2nd task are files 0-4 in folder /123
    private static String path3 = "123/avidreaders.ru__voyna-i-mir-tom-1.txt";
    private final static int PAGE_SIZE = 1800;
    // methods 2-3 have problems with Russian language. English is ok.

        public static void main(String[] args) {
            try {
                task1();
                task2();
                task3();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static void task3() throws IOException {
            System.out.println("Задача 3");
            RandomAccessFile f = new RandomAccessFile(path3, "r");
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter page where you would like to start reading:");
            int p = sc.nextInt() - 1;
            f.seek(p * PAGE_SIZE);
            for (int i = 0; i < PAGE_SIZE; i++) {
                System.out.print((char)f.read());
            }
            f.close();
        }

        public static void task2() throws IOException {
            System.out.println("Задача 2");
            ArrayList<InputStream> al = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                al.add(new FileInputStream("123/" +i + ".txt"));
            }
            BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
            int x;
           // byte[] d;
            //String s = null;
            while((x = in.read()) != -1) {
               // s = new String(x);
               System.out.print(x);
            }
            in.close();
        }

        public static void task1() throws IOException {
            System.out.println("Задача 1");

            BufferedInputStream in = new BufferedInputStream(new FileInputStream("123/2.txt"));
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int x;
            while((x = in.read()) != -1) {
                out.write(x);
            }
            byte[] b = out.toByteArray();
            System.out.println(Arrays.toString(b));


            in.close();
            out.close();
        }
}
