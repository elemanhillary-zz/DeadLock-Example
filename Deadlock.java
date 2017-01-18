/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package deadlock;

/**
 *
 * @author linux
 */
public class Deadlock implements Runnable {
    A a = new A();
    B b = new B();
    
    Deadlock(){
        Thread.currentThread().setName("main thread");
        Thread t = new Thread(this,"Racingthread");
        t.start();
        
        a.foo(b);
        System.out.println("Back in the main thread");
    }
    public void run(){
        b.bar(a);
        System.out.println("Back in the other thread");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new Deadlock();
    }
    
}
