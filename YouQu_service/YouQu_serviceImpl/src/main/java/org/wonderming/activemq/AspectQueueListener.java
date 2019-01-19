package org.wonderming.activemq;

import org.apache.activemq.command.ActiveMQObjectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.wonderming.exception.BaseException;
import org.wonderming.pojo.SystemLog;
import org.wonderming.service.SystemLogService;
import org.wonderming.utils.IdUtils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @className: aspectQueueListener
 * @package: org.wonderming.activemq
 * @author: wangdeming
 * @date: 2019-01-19 14:36
 **/
public class AspectQueueListener implements MessageListener {

    @Autowired
    private SystemLogService systemLogService;

    /**
     * 监听aspectQueue消息队列
     * @param message
     */
    @Override
    public void onMessage(Message message) {

        if (message instanceof ActiveMQObjectMessage){
            ActiveMQObjectMessage activeMQObjectMessage = (ActiveMQObjectMessage) message;
            try {
                SystemLog systemLog = (SystemLog) activeMQObjectMessage.getObject();
                systemLog.setId(IdUtils.creatKey());
                systemLogService.addSystemLogService(systemLog);
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }else {
            throw new BaseException("只支持ActiveMQObjectMessage 类型消息！");
        }
    }
}
