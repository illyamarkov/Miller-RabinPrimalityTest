/*
 Okay so, I didn't really make this, but I did allow the use of Longs, and also some usability improvements.
 I did not write these comments, and most of the stuff was already finished (I don't think it was working properly, but still, most of it was already written).
 The one who wrote this is apparently Nikita Tiwari.
 I couldn't find any more information.
 */

import java.util.Scanner;
import java.io.*; 
import java.math.*; 
import java.io.*; 
import java.math.*; 
  
public class primeCheck { 
  
    // Utility function to do modular  
    // exponentiation. It returns (x^y) % p 
    static long power(long x, long y, long p) { 
          
    	long res = 1; // Initialize result 
          
        //Update x if it is more than or 
        // equal to p
    	
    	System.out.println("X:" + x);
    	
        x = x % p;  
        
  
        while (y > 0) { 
              
            // If y is odd, multiply x with result 
            if ((y & 1) == 1) 
                res = (res * x) % p; 
            	System.out.println("");
            	System.out.println("RESULT:" + res);
            	System.out.println("X%P:" + x);
            	System.out.println("P:" + p);
            	System.out.println("Y:" + y);
          
            	
            // y must be even now 
            y = y >> 1; // y = y/2 
            x = (x * x) % p; 
        } 
          
        return res; 
    } 
      
    // This function is called for all k trials.  
    // It returns false if n is composite and  
    // returns false if n is probably prime. 
    // d is an odd number such that d*2<sup>r</sup> 
    // = n-1 for some r >= 1 
    static boolean miillerTest(long d, long n) { 
          
        // Pick a random number in [2..n-2] 
        // Corner cases make sure that n > 4 
    	long a = 2 + (int)(Math.random() % (n - 4)); 
      
        // Compute a^d % n 
    	System.out.println("Compute A^D % N: A: " + a + " D: " + d + " N: " + n);
        long x = power(a, d, n); 
      
        if (x == 1 || x == n - 1) 
            return true; 
      
        // Keep squaring x while one of the 
        // following doesn't happen 
        // (i) d does not reach n-1 
        // (ii) (x^2) % n is not 1 
        // (iii) (x^2) % n is not n-1 
        while (d != n - 1) { 
            x = (x * x) % n; 
            System.out.println(x + "²");
            d *= 2; 
          
            if (x == 1) 
                return false; 
            if (x == n - 1) 
                return true; 
        } 
      
        // Return composite 
        return false; 
    } 
      
    // It returns false if n is composite  
    // and returns true if n is probably  
    // prime. k is an input parameter that  
    // determines accuracy level. Higher  
    // value of k indicates more accuracy. 
    static boolean isPrime(long n, long k) { 
          
        // Corner cases 
        if (n <= 1 || n == 4) 
            return false; 
        if (n <= 3) 
            return true; 
      
        // Find r such that n = 2^d * r + 1  
        // for some r >= 1 
        long d = n - 1; 
          
        while (d % 2 == 0) 
            d /= 2; 
      
        // Iterate given nber of 'k' times 
        for (int i = 0; i < k; i++) 
            if (!miillerTest(d, n)) 
                return false; 
      
        return true; 
    } 
      
    // Driver program 
    public static void main(String args[]) { 
          
        Scanner input = new Scanner(System.in);
        System.out.print("Input value to be checked:");
        long n = input.nextLong();
        System.out.print("Input number of iterations:");
        long k = input.nextLong();
        
        System.out.println(isPrime(n,k) ? "Prime" : "Not Prime");
    } 
} 