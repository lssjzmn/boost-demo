package com.lssjzmn.kilin.boost.rabbits;

import com.alibaba.fastjson.JSON;
import com.lssjzmn.kilin.boost.bo.LoginRet;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class WorkConsumer extends DefaultConsumer {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private String TAG;

    public WorkConsumer(Channel channel, String TAG) {
        super(channel);
        this.TAG = TAG;
    }

    @Override
    public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");
        LoginRet ret = JSON.parseObject(message, LoginRet.class);
        logger.info(TAG + " received msg:" + ret.toString());
        getChannel().basicAck(envelope.getDeliveryTag(), false);
    }
}
