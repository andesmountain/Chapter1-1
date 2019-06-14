package com.yuqiyu.jvm;

import com.sun.org.apache.xml.internal.res.XMLErrorResources_tr;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/6/14
 * 公司：北京活力天汇<br>
 **/
public enum FlightState {


    early("提前",3){
        @Override
        double time(){
          return -1;
        }
    },delay("延误",4){
        @Override
        double time(){
            return 1;
        }
    },cancel("取消",0){
        @Override
        double time(){
            return 0;
        }
    };


    private String name;
    private int status;


    FlightState(String name,int status){
        this.name=name;
        this.status=status;
    }

    abstract double time();


    @Override
    public String toString() {
        return name+"_"+status;
    }}
