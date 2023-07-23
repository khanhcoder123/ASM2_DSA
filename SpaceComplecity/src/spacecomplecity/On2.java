/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package spacecomplecity;

/**
 *
 * @author khanh
 */
public class On2 {
    public static void generatePairs(int[] arr1, int[] arr2) {
        for (int num1 : arr1) {
            for (int num2 : arr2) {
                System.out.println("(" + num1 + ", " + num2 + ")");
            }
        }
    }

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3};
        int[] array2 = {4, 5};
        generatePairs(array1, array2);
    }
}
