package com.leetcode;

/**
 * @author zhuyinkui
 * @version 1.0.0
 * @Description TODO
 * @createTime 2020年05月22日 18:28:00
 */
public class Q79_exist {

    public boolean exist(char[][] board, String word) {
        if(board==null){
            return false;
        }
        int m = board.length;
        int n = board[0].length;
        int[][] check = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==word.charAt(0)){

                    if(word.length()==1 || findChar(board,word,1,check,i,j)){
                        return true;
                    }

                }
            }
        }
        return false;
    }

    public boolean findChar(char[][] board,String word,int c,int[][] check,int x,int y){
        check[x][y]=1;
        if(x>0){
            if(board[x-1][y]==word.charAt(c) && check[x-1][y]==0){
                if(c<word.length()-1) {
                    if(findChar(board, word, c + 1, check, x - 1, y)){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }

        if(x<board.length-1){
            if(board[x+1][y]==word.charAt(c) && check[x+1][y]==0){
                if(c<word.length()-1){
                    if(findChar(board,word,c+1,check,x+1,y)){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }

        if(y>0){
            if(board[x][y-1]==word.charAt(c) && check[x][y-1]==0){
                if(c<word.length()-1){
                    if(findChar(board,word,c+1,check,x,y-1)){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }

        if(y<board[0].length-1){
            if(board[x][y+1]==word.charAt(c) && check[x][y+1]==0){
                if(c<word.length()-1){
                    if(findChar(board,word,c+1,check,x,y+1)){
                        return true;
                    }
                }else{
                    return true;
                }
            }
        }
        check[x][y]=0;
        return false;
    }


    public static void main(String[] args) {
        char[][] board =new char[][] {{'c','e','e'},{'a','a','e'},{'b','c','d'}};

        Q79_exist q = new Q79_exist();
        boolean rs =q.exist(board,"aab");
        System.out.println(rs);
    }

}
