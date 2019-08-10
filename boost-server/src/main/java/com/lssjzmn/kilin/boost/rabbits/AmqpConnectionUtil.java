package com.lssjzmn.kilin.boost.rabbits;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AmqpConnectionUtil {

    private static Logger logger = LoggerFactory.getLogger(AmqpConnectionUtil.class);

    public static Connection getConnection() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("127.0.0.1");
            factory.setPort(5672);
            factory.setVirtualHost("/");
            factory.setAutomaticRecoveryEnabled(true);
            factory.setUsername("lssjzmn");
            factory.setPassword("lssjzmn634634");
            Connection connection = factory.newConnection();
            return connection;
        } catch (Exception e) {
            return null;
        }
    }
}
