package com.xss.admintest;

/**
 * @ClassName MessageInfo
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/20 4:39 下午
 * @Return
 */
public class MessageInfo {
    private String content;
    public MessageInfo(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }
}
