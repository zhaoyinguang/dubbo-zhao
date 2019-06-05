package active;

import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class MyConsumer implements MessageListener {
    @Override
    public void onMessage(Message message) {
        System.out.println();
        System.out.println();
        System.out.println();
        try {
            System.out.println(((TextMessage)message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
