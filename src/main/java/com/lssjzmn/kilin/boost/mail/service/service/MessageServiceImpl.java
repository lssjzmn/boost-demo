package com.lssjzmn.kilin.boost.mail.service.service;

import com.lssjzmn.kilin.boost.mail.msg.MailMessage;
import com.lssjzmn.kilin.boost.mail.msg.Message;
import com.lssjzmn.kilin.boost.mail.service.service.sender.MailSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.concurrent.*;

@Service
public class MessageServiceImpl implements MessageService {
    /**
     * The default queue size.
     */
    private static final int DEFAULT_QUEUE_SIZE = 1000;
    /**
     * The default wait time out.
     */
    private static final int DEFAULT_WAIT_TIMEOUT = 10000;
    /**
     * The default send message thread number
     */
    private static final int DEFAULT_SENDING_THREADS = 4;
    /**
     * The blocking queue for caching logs.
     */
    private BlockingQueue<Message> queue;
    /**
     * The queue size.
     */
    private int queueSize = DEFAULT_QUEUE_SIZE;
    /**
     * While the queue is full, the append log wait time out.
     * MILLISECONDS time.
     */
    private int waitTimeout = DEFAULT_WAIT_TIMEOUT;
    /**
     * The threads number of sending message.
     */
    private int sendingThreadNum = DEFAULT_SENDING_THREADS;
    /**
     * Sending message task.
     */
    private ExecutorService savingTask;

    /**
     * The slf4j logger.
     */
    private Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    public MessageServiceImpl() {
        init();
    }

    @Override
    public void send(Message message) {
        try {
            queue.offer(message, waitTimeout, TimeUnit.MILLISECONDS);
        } catch (InterruptedException ex) {
            logger.info(ex.getMessage(), ex);
        }
    }

    /**
     * Initial the queue and saving task. this method must be call after property setting.
     */
    public void init() {
        //Init Queue, Task.
        queue = new ArrayBlockingQueue<>(queueSize);
        savingTask = Executors.newFixedThreadPool(sendingThreadNum);
        for (int i = 0; i < sendingThreadNum; i++) {
            ConsumerTask task = new ConsumerTask(queue);
            savingTask.execute(task);
        }
        savingTask.shutdown();
    }

    /**
     * The consumer task for saving logs to DB.
     */
    private final class ConsumerTask implements Runnable {
        /**
         * The message queue.
         */
        private BlockingQueue<Message> queue;

        public ConsumerTask(BlockingQueue<Message> queue) {
            this.queue = queue;
        }

        @SuppressWarnings("unchecked")
        public void run() {
            while (true) {
                if (!Thread.interrupted()) {
                    try {
                        Message message = this.queue.take();
                        if (message instanceof MailMessage) {
                            try {
                                MailSender.getInstance().send(message);
                                logger.info("Thread " + Thread.currentThread().getName() + " sent a message successfully.");
                            } catch (Exception ex) {
                                logger.error("Thread " + Thread.currentThread().getName() + " sent a message failed.");
                                logger.error(ex.getMessage(), ex);
                            }
                        }
                    } catch (InterruptedException ex) {
                        logger.info("Thread " + Thread.currentThread().getName() + " interrupted normally.");
                        break;
                    }
                }
            }
        }
    }
}
