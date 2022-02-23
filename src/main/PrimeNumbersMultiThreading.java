package main;

import java.util.Scanner;

public class PrimeNumbersMultiThreading {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int number = scanner.nextInt();
        int a[] = new int[number +1];

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a)
                {
                    for(int i = 1; i <= number; i++){
                        a[i] = i;
                    }

                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (a){
                    for(int i = 0; i < a.length; i++) {
                        boolean isPrime = true;
                        if(a[i] == 1 || a[i] == 0){
                            isPrime = false;
                        }
                        for (int j = 2; j < a[i]; j++) {
                            if(a[i] % j ==0){
                                isPrime = false;
                                break;
                            }
                        }
                        try {
                            Thread.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if(isPrime){
                            System.out.println(a[i] + " Is prime number");
                        }

                    }
                }
            }
        });


        t1.start();
        t2.start();



    }
}
