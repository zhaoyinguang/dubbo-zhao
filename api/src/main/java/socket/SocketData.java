package socket;

import java.io.Serializable;

public class SocketData implements Serializable {
    private int number;

    private String discription;

    private String method;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "SocketData{" +
                "number=" + number +
                ", discription='" + discription + '\'' +
                ", method='" + method + '\'' +
                '}';
    }
}
