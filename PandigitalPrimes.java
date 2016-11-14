/*
 * Copyright (C) 2016 Michael <GrubenM@GMail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pandigitalprimes;

import java.util.Arrays;
import java.util.Stack;

/**
 * Finds the largest n-digit pandigital prime.
 * 
 * A number is n-digit pandigital if it makes use of the digits 1 through n
 * exactly once.
 * @author Michael <GrubenM@GMail.com>
 */
public class PandigitalPrimes {
    
    // https://en.wikipedia.org/wiki/Primality_test#Pseudocode
    private boolean isPrime(int n) { 
        if (n <= 1) return false;
        if (n <= 3) return true;
        if ((n % 2 == 0) || (n % 3 == 0)) return false;
        int i = 5;
        while (i * i <= n) {
            if ((n % i == 0) || (n % (i + 2) == 0)) return false;
            i += 6;
        }
        return true;
    }
    
    /**
     * Given an integer array representing a decimal integer,
     * returns that decimal integer.
     * 
     * e.g. atoi({1, 2, 3, 4}) -> 1234
     * @param a
     * @return 
     */
    public int atoi(int[] a) {
        int ans = 0;
        for (int i: a) {
            ans *= 10;
            ans += i;
        }
        return ans;
    }
    
    /**
     * Reverse the sequence from a[k+1] up to and including the final element
     * @param a
     * @param k 
     */
    public void reverseArray(int[] a, int k) {
        Stack<Integer> s = new Stack<>();
        for (int tmp = k; tmp + 1 < a.length; tmp++) s.push(a[tmp+1]);
        for (int tmp = k; tmp + 1 < a.length; tmp++) a[tmp+1] = s.pop();
    }
    
    /**
     * Swap the value of a[k] with that of a[l]
     * @param a
     * @param k
     * @param l 
     */
    public void swap(int[] a, int k, int l) {
        int tmp = a[k];
        a[k] = a[l];
        a[l] = tmp;
    }
    
    public void permute(int[] a) {
        /**
         * permute the array of digits in largest-to-smallest order
        Find the largest index k such that a[k] > a[k + 1]. If no such index exists, the permutation is the last permutation.
        Find the largest index l greater than k such that a[k] > a[l].
        Swap the value of a[k] with that of a[l].
        Reverse the sequence from a[k + 1] up to and including the final element a[n].
        * 
        * https://en.wikipedia.org/wiki/Permutation#Generation_in_lexicographic_order
        */
        
        // Find the largest index k
        int k;
        int largest = 0;
        boolean exit = true;
        for (k = largest; k < a.length - 1; k++) {
            if (a[k] > a[k + 1]) {
                largest = k;
                exit = false;  // the permutation is not the last permutation
            }
        }
        if (exit) return;
        k = largest;
        
        // Find the largest index l
        int l;
        largest = k + 1;
        for (l = largest; l < a.length; l++) {
            if (a[k] > a[l]) {
                largest = l;
            }
        }
        l = largest;
        
        // Swap and reverse
        this.swap(a, k, l);
        this.reverseArray(a, k);
    }
    
    /**
     * Given n, the length of the pandigital, returns the largest pandigital
     * prime of that length.
     * 
     * @param n
     * @return 
     */
    public int largestPandigitalPrime(int n) {
        // generate the array of digits to permute
        int[] a = new int[n];
        for (int i = n; i >= 1; i--) {
            a[n - i] = i;
        }
        
        int tmp;
        double upper = Math.pow(2, n);
        for(int i = 0; i < upper; i++) {
            tmp = this.atoi(a);
            if (this.isPrime(tmp)) return tmp;
            else this.permute(a);
        }
        return -1;
    }
    
    /**
     * Prints the given array as:
     * {i1, i2, i3, ..., i(n-1), in}
     * @param a 
     */
    public void printArray(int[] a) {
        String res = "{";
        for (int i: a) {
            res += i;
            res += ", ";
        }
        res = res.substring(0, res.length() - 2);
        res += "}";
        System.out.println(res);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PandigitalPrimes p = new PandigitalPrimes();
        int ans = -1;
        int n = 10;
        while (ans == -1 && n > 0) {
            ans = p.largestPandigitalPrime(--n);
        }
        System.out.println("Largest pandigital prime is: " + ans);
        System.out.println("n = " + n);
    }
}
