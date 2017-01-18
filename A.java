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
class A{
    synchronized void foo(B b){
        String name = Thread.currentThread().getName();
        System.out.println(name+": entered A foo");
        
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("A interrupted");
        }
        System.out.println(name+": trying to call B.last");
        b.last();
    }
    synchronized void last(){
        System.out.println("inside A.last");
    }
    
}
