package socket;

import java.io.*;
import java.net.Socket;

public class SocketClient {

    public void getClient(int number,String discription,String method) {

        Socket socket = null;
        try {
            socket = new Socket("localhost", 8888);

        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        SocketData socketData = new SocketData();
        socketData.setNumber(number);
        socketData.setDiscription(discription);
        socketData.setMethod(method);
        objectOutputStream.writeObject(socketData);
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        SocketData result = (SocketData) objectInputStream.readObject();
        System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        SocketClient socketClient = new SocketClient();
        socketClient.getClient(10,"我是调用端","changeData1");
    }
}
