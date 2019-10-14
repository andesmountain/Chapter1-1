package com.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 版权: Copyright (c) 2011-2018 <br>
 * 公司: 北京活力天汇 <br>
 * 如果出现下述两种情况，交易 可能无效：
 *
 * 交易金额超过 ¥1000
 * 或者，它和另一个城市中同名的另一笔交易相隔不超过 60 分钟（包含 60 分钟整）
 * 每个交易字符串 transactions[i] 由一些用逗号分隔的值组成，这些值分别表示交易的名称，时间（以分钟计），金额以及城市。
 *
 * 给你一份交易清单 transactions，返回可能无效的交易列表。你可以按任何顺序返回答案。
 *
 * ["alice,20,800,mtv","alice,50,100,beijing"]
 * @author dell
 * @date 2019/8/26
 * 公司：北京活力天汇<br>
 **/
public class Q1169_invalidTransactions {


    public List<String> invalidTransactions(String[] transactions) {
        List<String> invalidList = new ArrayList<>();
        Map<String,List<String>> map = new HashMap<>();

        for(String str:transactions){
            String[] abc = str.split(",");
            String name = abc[0];
            int time = Integer.parseInt(abc[1]);
            int amount = Integer.parseInt(abc[2]);
            String city = abc[3];
            // 交易金额超过 ¥1000
            if(amount>1000){
                invalidList.add(str);
            }

            // 不同城市，同名交易相隔不超过60分钟
            if(map.containsKey(name)){
                List<String> list = map.get(name);
                for(String dupl:list){
                    String[] spl = dupl.split(",");
                    int time2= Integer.parseInt(spl[1]);
                    String city2 = spl[3];
                    if(!city.equals(city2) &&  Math.abs(time-time2)<=60){
                        // 两个都要加入
                        if(!invalidList.contains(str))
                            invalidList.add(str);
                        if(!invalidList.contains(dupl))
                            invalidList.add(dupl);
                    }
                }
                list.add(str);
                map.put(name,list);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(name,list);
            }
        }
        return invalidList;

    }

    public static void main(String[] args) {
        Q1169_invalidTransactions q = new Q1169_invalidTransactions();

        q.invalidTransactions(new String[]{"alice,20,800,mtv","alice,50,100,beijing"});

    }

}
