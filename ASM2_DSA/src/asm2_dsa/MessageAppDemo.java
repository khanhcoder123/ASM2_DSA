/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asm2_dsa;

/**
 *
 * @author khanh
 */
import java.util.Scanner;

public class MessageAppDemo {
    private static final int MAX_MESSAGE_LENGTH = 250;

    public static void main(String[] args) {
        Queue inputQueue = new Queue();
        Stack sentStack = new Stack();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Enter the number of messages");
            System.out.println("2. Send messages");
            System.out.println("3. View received messages");
            System.out.println("4. Exit");
            System.out.print("Your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter the number of messages: ");
                    int numMessages = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < numMessages; i++) {
                        System.out.print("Message " + (i + 1) + ": ");
                        String message = scanner.nextLine();
                        inputQueue.enqueue(message);
                    }
                    break;
                case 2:
                    System.out.println("\nSending messages:");
                    while (!inputQueue.isEmpty()) {
                        String message = inputQueue.dequeue();
                        if (message.length() <= MAX_MESSAGE_LENGTH) {
                            sentStack.push(message);
                            System.out.println("Sent: Messages sent" + message);
                        } else {
                            System.out.println("Message too long. Not sent.");
                        }
                    }
                    break;
                case 3:
                    System.out.println("\nViewing received messages:");
                    while (!sentStack.isEmpty()) {
                        String message = sentStack.pop();
                        System.out.println("Received: " + message);
                    }
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}



// Rest of the Queue and Stack implementations remain unchanged


// Queue ADT implementation
class Queue {
    private static class QueueNode {
        String data;
        QueueNode next;

        public QueueNode(String data) {
            this.data = data;
        }
    }

    private QueueNode front;
    private QueueNode rear;

    public Queue() {
        front = null;
        rear = null;
    }

    public void enqueue(String message) {
        QueueNode newNode = new QueueNode(message);
        if (isEmpty()) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public String dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty.");
        }
        String message = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return message;
    }

    public boolean isEmpty() {
        return front == null;
    }
}

// Stack ADT implementation
class Stack {
    private static class StackNode {
        String data;
        StackNode next;

        public StackNode(String data) {
            this.data = data;
        }
    }

    private StackNode top;

    public Stack() {
        top = null;
    }

    public void push(String message) {
        StackNode newNode = new StackNode(message);
        newNode.next = top;
        top = newNode;
    }

    public String pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty.");
        }
        String message = top.data;
        top = top.next;
        return message;
    }

    public boolean isEmpty() {
        return top == null;
    }
}

