/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package timecomplexity;

/**
 *
 * @author khanh
 */
public class O2n{
    public static void main(String[] args) {
        int n = 5;
        int result = recursiveFunction(n);
        System.out.println("Result: " + result);
    }

    private static int recursiveFunction(int n) {
        if (n <= 1) {
            return n;
        }
        return recursiveFunction(n - 1) + recursiveFunction(n - 2);
    }
}

