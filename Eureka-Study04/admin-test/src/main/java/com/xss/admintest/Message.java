package com.xss.admintest;

/**
 * @ClassName Message
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/20 4:39 下午
 * @Return
 */
public class Message {
    private String msgtype;
    private MessageInfo text;
    public String getMsgtype() {
        return msgtype;
    }
    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype;
    }
    public MessageInfo getText() {
        return text;
    }
    public void setText(MessageInfo text) {
        this.text = text;
    }
}
