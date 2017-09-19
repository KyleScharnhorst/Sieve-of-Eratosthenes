package com.SieveOfEratosthenes;

import java.util.Arrays;

public class SieveOfEratosthenes {

    private boolean[] isPrime;
    private int prime = 2;

    public SieveOfEratosthenes(int max) {
        isPrime = new boolean[max + 1];

        //init array
        Arrays.fill(isPrime, Boolean.TRUE);
        isPrime[0] = false;
        isPrime[1] = false;

        //determine primes
        while(prime <= Math.sqrt(max)) {
            //cross off multiples of the current prime.
            crossOff();
            //get the next prime value
            nextPrime();
        }
    }

    private void crossOff() {
        for(int i = prime * prime; i < isPrime.length; i += prime) {
            isPrime[i] = false;
        }
    }

    private void nextPrime() {
        int next = prime + 1;
        while(next < isPrime.length && !isPrime[next]) {
            next++;
        }
        prime = next;
    }

    public void printPrimes() {
        System.out.print("[");
        for(int i = 0; i < isPrime.length; i++) {
            if(i > 2 && isPrime[i]) {
                System.out.print(", " + i);
            } else if (isPrime[i]) {
                System.out.print(i);
            }
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        SieveOfEratosthenes soe = new SieveOfEratosthenes(1000);
        soe.printPrimes();
    }

}
