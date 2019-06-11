package com.lssjzmn.kilin.boost.controller;

import com.lssjzmn.kilin.boost.bo.LoginRet;
import com.lssjzmn.kilin.boost.dao.LocationPointRepository;
import com.lssjzmn.kilin.boost.dao.WorkFrameRepository;
import com.lssjzmn.kilin.boost.entity.RobotLocationPoint;
import com.lssjzmn.kilin.boost.entity.WorkAxesFrame;
import com.lssjzmn.kilin.boost.service.AmqpMessageSender;
import com.lssjzmn.kilin.boost.utils.util.JSONModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping(value = "/entry")
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AmqpMessageSender amqpMessageSender;

    @Autowired
    WorkFrameRepository workFrameRepository;

    @Autowired
    LocationPointRepository locationPointRepository;

    @RequestMapping(value = "/welcome/{id}.html", method = RequestMethod.GET)
    public String login(@PathVariable("id") Integer id, HttpServletRequest request, HttpServletResponse response, Model model) {
        LoginRet rabbitLogin = new LoginRet();
        rabbitLogin.setId(10086L);
        rabbitLogin.setStatus("200 OK");
        rabbitLogin.setInfo("this is a rabbitmq message of rabbitLogin");
        rabbitLogin.getBody().put("bofyInfo", 8888);
        amqpMessageSender.sendMessage("rabbitmq_queue_routingkey", rabbitLogin);
        /*amqpMessageSender.sendMessage("rabbitmq_queue_routingkey",
                "this is a rabbitmq message for rabbitmq_queue_routingkey_10000.id = " + id);*/
        model.addAttribute("id", id);
        return "/login";
    }

    @RequestMapping(value = "/requestLogin.html", method = RequestMethod.GET)
    @ResponseBody
    public Object requestLogin() {
        LoginRet loginRet = new LoginRet();
        loginRet.setId(10086L);
        loginRet.setStatus("200 OK");
        loginRet.setInfo("login success.");
        loginRet.getBody().put("bofyInfo", 8888);
        List<WorkAxesFrame> workAxesFrameList = workFrameRepository.findAll();
        List<RobotLocationPoint> locationPointList = locationPointRepository.findAll();
        List<RobotLocationPoint> locationPointList2 = (List<RobotLocationPoint>) locationPointRepository.findByIdGreaterThan(10010);
        String ret = JSONModel.convertObjectToJSON(locationPointList2);
        return ret;
    }

}
