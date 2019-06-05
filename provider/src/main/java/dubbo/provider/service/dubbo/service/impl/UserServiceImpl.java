package dubbo.provider.service.dubbo.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import dubbo.provider.service.UserService;
import dubbo.provider.service.mq.MqProducer;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private MqProducer mqProducer;


    public String getUserName(String topic){
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        mqProducer.senMessage("你调用的是provider2",topic);
        return "我是provider2";
    }
}
