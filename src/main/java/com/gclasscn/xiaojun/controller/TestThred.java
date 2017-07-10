package com.gclasscn.xiaojun.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

 
public class TestThred {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.execute(new DepositAPeenyTask());
        executors.execute(new WithDraw());
        executors.shutdown();
    }
 
}
 
//存储类
 class DepositAPeenyTask implements Runnable{
    Account account1 = new Account();
     
    public void run(){
            try {
                while(true){
                    account1.deposit((int)(Math.random()*500)+1);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
         
    }
}
 
 
//取钱类
class  WithDraw implements Runnable {
    Account account2 = new Account();
    @Override
    public void run() {
        try {
             
            while(true) {
                account2.withDraw((int) (Math.random() * 1000) + 1);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
             
            System.out.println(e.toString());
        }
    }
     
}
 
//账户类
 class Account {
     
    private static Lock lock = new ReentrantLock();
    private static Condition condition = lock.newCondition();
    private static int balance = 0 ;
     
    //get the balance
    public int getBalance(){
        return balance;
    }
     
    //deposit the money
    public void deposit(int amount){
        lock.lock();
        System.out.println("存入 "+amount+" 钱");
        balance += amount;
        System.out.println("账户共有资金："+getBalance());
        condition.signalAll();  
        lock.unlock();
    }
     
    //withDraw the money
    public void withDraw(int amount){
        int i = 0 ;
         int j = 0 ; 
        lock.lock();
        try{
            System.out.println("i的值："+(++i));
            while(balance < amount){
                System.out.println("你的取款金额为"+amount+"元，但是系统金额不足，请等待!");
                condition.await();
            System.out.println("j的值："+(++j));   
            }
            balance -= amount;
            System.out.println("您已经取出"+amount+"元，您账户剩余的金额为："+getBalance());
        }catch (Exception e) {
            System.out.println(e.toString());
        }finally{
            lock.unlock();
        }
    }
     
}