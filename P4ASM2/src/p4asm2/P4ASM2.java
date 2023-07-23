/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package p4asm2;

/**
 *
 * @author khanh
 */
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class P4ASM2 {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        Stack<String> stack = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String strInput = scanner.nextLine();

        // Step 1: Enqueue into the Queue
        if (strInput.length() <= 250) {
            queue.offer(strInput);
            System.out.println("String enqueued successfully!");
        } else {
            System.out.println("Input string is too long. Please enter a string with a length less than 250 characters.");
            scanner.close();
            return;
        }

        // Step 2: Dequeue from the Queue and push into the Stack
        while (!queue.isEmpty()) {
            String item = queue.poll();
            stack.push(item);
            System.out.println("Dequeued from Queue: " + item);
        }

        // Step 3: Print and pop messages from the Stack
        System.out.println("Messages in the stack:");
        while (!stack.isEmpty()) {
            String message = stack.pop();
            System.out.println(message);
        }

        scanner.close();
    }
}

