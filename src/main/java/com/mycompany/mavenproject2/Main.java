/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author Matt
 */
public class Main {
    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public static boolean hasDigit3(int n) {
        return String.valueOf(n).contains("3");
    }
    
    public static int primeWithDigit3(int n) {
        SinglyLinkedList primeList = new SinglyLinkedList();
        SinglyLinkedList primeWith3List = new SinglyLinkedList();
        
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                primeList.addNode(i);
                if (hasDigit3(i)) {
                    primeWith3List.addNode(i);
                }
            }
        }
        
        System.out.printf("Prime numbers between 0 and %d:%n", n);
        primeList.display();
        
        System.out.printf("Prime numbers with digit 3 between 0 and %d:%n", n);
        primeWith3List.display();
        
        return sumNodeData(primeWith3List);
    }
    
    public static int sumNodeData(SinglyLinkedList linkedList) {
        Node current = linkedList.head;
        int sum = 0;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    
    public static void main(String[] args) {
        int n = 100;
        System.out.printf("Sum of prime numbers with digit 3 between 0 and %d:%n", n);
        System.out.println(primeWithDigit3(n));
    }
}