/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.asm2dsap4;

import java.util.*;

/**
 *
 * @author ADMIN
 */
public class MessageApp {
    // A queue to store the input messages

    private Queue<String> inputQueue;

    // A stack to store the sent messages
    private Stack<String> sentStack;

    // A scanner to read user input
    private Scanner scanner;

    // A constructor to initialize the queue, stack and scanner
    public MessageApp() {
        inputQueue = new LinkedList<>();
        sentStack = new Stack<>();
        scanner = new Scanner(System.in);
    }

    // A method to input a message and enqueue it to the queue
    public void inputMessage() {
        System.out.println("Enter the string str < 250 characters.");
        String message = scanner.nextLine();
        if (message.length() < 250) {
            inputQueue.add(message);
            System.out.println("Message added to the queue.");
        } else {
            System.out.println("Message too long. Try again.");
        }
    }

    // A method to send a message by dequeueing it from the queue and pushing it to the stack
    public void sendMessage() {
        try { // try to send a message
            String message = inputQueue.remove(); // this might throw a NoSuchElementException if the queue is empty
            sentStack.push(message);
            System.out.println("Message sent: " + message);
        } catch (NoSuchElementException e) { // catch the exception if it occurs
            System.out.println("No messages to send."); // handle the exception by printing a message
        }
    }

    // A method to view the received messages by popping them from the stack
    public void viewMessage() {
        try { // try to view a message
            System.out.println("Received messages:");
            while (!sentStack.isEmpty()) {
                String message = sentStack.pop(); // this might throw an EmptyStackException if the stack is empty
                System.out.println(message);
            }
        } catch (EmptyStackException e) { // catch the exception if it occurs
            System.out.println("No messages to view."); // handle the exception by printing a message
        }
    }

    // A method to display the menu and handle user choices
    public void run() {
        boolean exit = false;
        while (!exit) {
            System.out.println("Choose an option:");
            System.out.println("1. Input message");
            System.out.println("2. Send message");
            System.out.println("3. View message");
            System.out.println("4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline
            switch (choice) {
                case 1:
                    inputMessage();
                    break;
                case 2:
                    sendMessage();
                    break;
                case 3:
                    viewMessage();
                    break;
                case 4:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
                    break;
            }
        }
        System.out.println("Bye!");
    }
}
