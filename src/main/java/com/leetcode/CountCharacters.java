package com.leetcode;

public class CountCharacters {
    public static int countCharacters(String[] words, String chars) {
        int count=0;
        for(int i=0;i<words.length;i++){
            String[] word = words[i].split("");
            int index = 0;
            String temp = chars;
            boolean ok = true;
            for(int k=0;k<word.length;k++){
                if( (index=temp.indexOf(word[k]))>=0){
                    temp = temp.substring(0,index)+temp.substring(index+1);
                }else{
                    ok=false;
                    break;
                }
            }
            if(ok){
                count+=word.length;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] str = new String[]{"hello","world","leetcode"};
        countCharacters(str,"welldonehoneyr");
    }
}
