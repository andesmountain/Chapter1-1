package com.yuqiyu.zkLock;

public interface Lock {

    void getLock();

    void waitLock();

    boolean unLock();
}
