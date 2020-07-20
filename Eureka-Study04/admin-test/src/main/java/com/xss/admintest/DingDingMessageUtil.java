package com.xss.admintest;

import com.alibaba.fastjson.JSONObject;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @ClassName DingDingMessageUtil
 * @Description
 * @Author xushaoshuai
 * @Parameters
 * @Date 2020/7/20 4:36 下午
 * @Return
 */
public class DingDingMessageUtil {
    //https://oapi.dingtalk.com/robot/send?access_token=2a52900c30cc8afe76f31e67f74abf2e1e8a7cd849c4f3ab4e9733e9ded24da5
    public static String access_token = "2a52900c30cc8afe76f31e67f74abf2e1e8a7cd849c4f3ab4e9733e9ded24da5";
    public static void sendTextMessage(String msg) {
        try {
            Message message = new Message();
            message.setMsgtype("text");
            message.setText(new MessageInfo(msg));
            URL url = new URL("https://oapi.dingtalk.com/robot/send?access_token=" + access_token);
            // 建立 http 连接
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
            conn.connect();
            OutputStream out = conn.getOutputStream();
            String textMessage = JSONObject.toJSONString(message);
            byte[] data = textMessage.getBytes();
            out.write(data);
            out.flush();
            out.close();
            InputStream in = conn.getInputStream();
            byte[] data1 = new byte[in.available()];
            in.read(data1);
            System.out.println(new String(data1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
