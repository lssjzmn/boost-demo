package com.lssjzmn.kilin.boost.rabbits;

import com.lssjzmn.kilin.boost.bo.LoginRet;
import com.rabbitmq.client.*;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;

/**
 * https://www.cnblogs.com/wy697495/p/9615616.html
 */
@Component
@EnableScheduling
public class RabbitMQAgent {

    private Logger logger = LoggerFactory.getLogger(getClass());
    private final String EXCHANGE_NAME = "WORKGROUP_EXCHANGE";
    private final String ROUTING_KEY_NAME = "WORKGROUP_ROUTING";
    private final String QUEUE_NAME = "WORKGROUP_QUEUE";

    private Connection sendConnection;
    private Channel sendChannel;

    private Connection receiveConnection;

    @PostConstruct
    public void initMQConnection() {
        try {
            sendConnection = AmqpConnectionUtil.getConnection();
            sendConnection.addBlockedListener(new ConnBlockedListener());
            sendConnection.addShutdownListener(new ConnShutdownListener());
            sendChannel = sendConnection.createChannel();
            sendChannel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.DIRECT, true);

            receiveConnection = AmqpConnectionUtil.getConnection();
            receiveConnection.addBlockedListener(new ConnBlockedListener());
            receiveConnection.addShutdownListener(new ConnShutdownListener());
            addConsumer(EXCHANGE_NAME, QUEUE_NAME, ROUTING_KEY_NAME, "FIRST");
            addConsumer(EXCHANGE_NAME, QUEUE_NAME, ROUTING_KEY_NAME, "SECOND");
            addConsumer(EXCHANGE_NAME, QUEUE_NAME, ROUTING_KEY_NAME, "THIRD");
            addConsumer(EXCHANGE_NAME, QUEUE_NAME, ROUTING_KEY_NAME, "FORTH");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void addConsumer(String exchangeName, String queueName, String routingKey, String TAG) throws IOException {
        Channel receiveChannel = receiveConnection.createChannel();
        receiveChannel.exchangeDeclare(exchangeName, BuiltinExchangeType.DIRECT, true);
        receiveChannel.queueDeclare(queueName, true, false, false, null);
        receiveChannel.queueBind(queueName, exchangeName, routingKey);
        receiveChannel.basicQos(1);
        WorkConsumer workConsumer = new WorkConsumer(receiveChannel, TAG);
        receiveChannel.basicConsume(queueName, false, workConsumer);
    }

    class ConnBlockedListener implements BlockedListener {
        @Override
        public void handleBlocked(String reason) throws IOException {

        }

        @Override
        public void handleUnblocked() throws IOException {

        }
    }

    class ConnShutdownListener implements ShutdownListener {
        @Override
        public void shutdownCompleted(ShutdownSignalException cause) {

        }
    }

    @Scheduled(fixedRate = 20)
    public void sendMessage() {
        try {
            LoginRet ret = new LoginRet();
            ret.setId(System.currentTimeMillis());
            ret.setStatus("200");
            ret.setInfo("this is a message from rabbitmq client");
            ret.setBody(new HashMap<>());
            JSONObject jsonObject = JSONObject.fromObject(ret);
            byte[] message = jsonObject.toString().getBytes("UTF-8");
            sendChannel.basicPublish(EXCHANGE_NAME, ROUTING_KEY_NAME, false, null, message);
            logger.info("** message count:" + sendChannel.messageCount(QUEUE_NAME));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
