package org.wonderming.activemq;


import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.jms.core.JmsTemplate;
import org.wonderming.pojo.SystemLog;

import javax.annotation.Resource;
import javax.jms.Destination;


/**
 * @author wangdeming
 * @class AspectMessage
 * @date 2019-01-19 14:23
 **/
public class AspectMessage {

    @Resource
    private JmsTemplate jmsTemplate;

    @Resource
    private Destination aspectQueue;


    /**
     * 向消息队列发送系统日志对象
     * @param systemLog
     */
    public void sendAspectMessage(SystemLog systemLog){
        jmsTemplate.send(aspectQueue,session -> {
            ActiveMQObjectMessage msg = (ActiveMQObjectMessage)session.createObjectMessage();
            msg.setObject(systemLog);
            return msg;
        });
    }
}
