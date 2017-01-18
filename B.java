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
class B {
    synchronized void bar(A a){
        String name = Thread.currentThread().getName();
        System.out.println(name+": enetered B bar");
        
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            System.out.println("B interrupted");
        }
        System.out.println(name+": trying to enter A.last");
        a.last();
    }
    synchronized void last(){
        System.out.println("inside B.last");
    }
    
}
