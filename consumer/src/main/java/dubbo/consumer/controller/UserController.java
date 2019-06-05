package dubbo.consumer.controller;

import dubbo.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller
public class UserController {
    @Autowired
    private UserService demoService;

//    @Autowired
//    private WordService wordService;

    @RequestMapping(value = "/test", produces = "application/json; charset=utf-8")
    @ResponseBody
    public String test(String topic){

        String userName = demoService.getUserName(topic);
        return "test "+userName;
    }

    @RequestMapping("/translta")
    @ResponseBody
    public String result(MultipartFile file, String userName, String url){
        return null;
    }
}
