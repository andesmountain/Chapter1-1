package com.yuqiyu.jvm;

import lombok.Data;

import java.util.Arrays;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 *
 * @author dell
 * @date 2019/6/14
 * 公司：北京活力天汇<br>
 **/
@Data
public class BuilderPattern {
    private String name;
    private String gender;

    public static class Builder {
        BuilderPattern bb;

        public Builder() {
            this.bb = new BuilderPattern();
        }

        public Builder name(String name) {
            bb.name = name;
            return this;
        }

        public Builder gender(String gender) {
            bb.gender = gender;
            return this;
        }

        public BuilderPattern build() {
            return this.bb;
        }
    }


    public static void main(String[] args) {

        FlightState uu = FlightState.cancel;
        switch (uu) {
            case delay:
                System.out.println("delay");
                break;
            case early:
                System.out.println("early");
                FlightState.early.time();
                break;
            default:
                System.out.println("nothing");
        }


        Arrays.asList(FlightState.values()).forEach(f-> System.out.println(f));


        BuilderPattern bp = new BuilderPattern.Builder().name("abc").gender("male").build();
        System.out.println(bp);

    }

}
