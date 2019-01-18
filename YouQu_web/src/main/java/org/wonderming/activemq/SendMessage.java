package org.wonderming.activemq;


import org.springframework.jms.core.JmsTemplate;


import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: 王德明
 * @Date: 2019/1/18
 * @Time: 15:28
 * @Project: youqu
 * @Package: org.wonderming.activemq
 */
public class SendMessage {

    @Resource(name = "jmsTemplate")
    private JmsTemplate jmsTemplate;

    @Resource(name = "testQueue")
    private Destination testQueue;

    @Resource(name = "testTopic")
    private Destination testTopic;


    /**
     * 向队列发送消息
     * @param messageContent
     */
    public void sendQueueMessage(String messageContent) {
        jmsTemplate.send(testQueue, session -> {
            TextMessage msg = session.createTextMessage();
            msg.setText(messageContent);
            return msg;
        });

    }

    /**
     * 向主题发送消息
     * @param messageContent
     */
    public void sendTopicMessage(String messageContent) {
        jmsTemplate.send(testTopic, session -> {
            TextMessage msg = session.createTextMessage();
            msg.setText(messageContent);
            return msg;
        });
    }
}
