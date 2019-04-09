package com.yuqiyu.zkLock;

public abstract class AbstractLock implements Lock {

    public void getLock(){
        if(tryLock()){
            System.out.println("获取到锁");
        }else{
            waitLock();
            getLock();
        }
    }

    public abstract boolean tryLock();

    
    public abstract void waitLock();
}
