package com.yuqiyu.templatepattern;

public abstract class AbstractCar {
    protected abstract void weight();
    protected abstract void color();
    protected abstract int price();

    /**
     * 模板方法
     */
    public final void run(){
        if(this.price()>10){
            weight();
            color();
        }else{
            price();
        }
    }
}
