package socket;

import java.io.*;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    private  void getSocket(){
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            while(true){
                Socket socket = serverSocket.accept();

                //输入相关流
                InputStream inputStream = socket.getInputStream();
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                //输出相关流
                OutputStream outputStream = socket.getOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

                //接收remoteCall对象流
                SocketData socketData = (SocketData) objectInputStream.readObject();
                Method[] methods = this.getClass().getMethods();
                Method method = this.getClass().getMethod(socketData.getMethod(), socketData.getClass());
                socketData = (SocketData) method.invoke(this,socketData);

                //返回给远程客户端
                objectOutputStream.writeObject(socketData);

                this.release(inputStream);
                this.release(outputStream);
                this.release(socket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private  <T extends Closeable> void release(T t)
    {
        if(t != null)
        {
            try
            {
                t.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public SocketData changeData1(SocketData socketData){
        System.out.println("调用信息为"+socketData);
        socketData.setNumber(socketData.getNumber()+500);
        socketData.setDiscription("这是changeData1返回数据");
        return socketData;
    }

    public SocketData changeData2(SocketData socketData){
        System.out.println("调用信息为"+socketData);
        socketData.setNumber(socketData.getNumber()-100);
        socketData.setDiscription("这是changeData2返回数据");
        return socketData;
    }

    public static void main(String[] args){
        new SocketServer().getSocket();
    }

}
