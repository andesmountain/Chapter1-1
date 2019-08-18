package com.tomcat.handwrite;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TomcatServer {

    private static ExecutorService es= Executors.newCachedThreadPool();

    public static void main(String[] args) throws IOException {
        // 加载项目


        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("启动serverSocket");
        while(!serverSocket.isClosed()){
            Socket socket = serverSocket.accept();
            es.submit(()->{
                InputStream is = null;

                try {
                    is = socket.getInputStream();
                    BufferedReader reader = new BufferedReader(new InputStreamReader(is,"utf-8"));
                    String msg = null;
                    StringBuilder sb = new StringBuilder();
                    while((msg=reader.readLine())!=null){
                        if(msg.length()==0) break;
                        sb.append(msg).append("\r\n");
                    }
                    System.out.println(sb.toString());

                    OutputStream outputStream = socket.getOutputStream();
                    byte[] b = "响应成功".getBytes();
                    outputStream.write(b);
                    outputStream.flush();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            });



        }


    }
}
