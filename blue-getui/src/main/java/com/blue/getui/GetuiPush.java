package com.blue.getui;

import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.exceptions.RequestException;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.NotificationTemplate;
import com.gexin.rp.sdk.template.NotyPopLoadTemplate;
import com.gexin.rp.sdk.template.style.Style0;
import com.gexin.rp.sdk.template.style.Style1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 个推
 *
 * @author lblue
 * @date 2018/01/23 15:06
 */
public class GetuiPush {

    //定义常量, appId、appKey、masterSecret 采用本文档 "第二步 获取访问凭证 "中获得的应用配置
    private static String appId = "kizxrPdfai8PfS6LyHGJn";
    private static String appKey = "qHnUNaNf6RA1KPEJTje9R9";
    private static String masterSecret = "USfESHU6dE7PqusuYLHxM5";
    private static String url = "http://sdk.open.api.igexin.com/apiex.htm";
    static String CID = "e3768fc77d99e35e8cefacad5daa5743";

    private volatile static IGtPush iGtPush = null;

    public static IGtPush getIGtPush() {
        if (iGtPush == null) {
            synchronized (IGtPush.class) {
                if (iGtPush == null) {
                    iGtPush = new IGtPush(url, appKey, masterSecret);
                }
            }
        }
        return iGtPush;
    }

    public static void main(String[] args) throws IOException {
//        LinkTemplate();
//        pushMessageToApp("biaoti", "neirog");
//        pushNotificationTemplate(CID, "pushNotificationTemplate", "pushNotificationTemplate", "传输内容", "sad", "as");
//        pushLinkTemplate(CID, "pushLinkTemplate", "pushLinkTemplate", "http://www.baidu.com","sad", "as");
        pushNotyPopLoadTemplate(CID, "pushLinkTemplate", "pushLinkTemplate", "http://www.baidu.com","sad", "as");
    }

    public static void pushMessageToApp(String title, String text) {
        NotificationTemplate template = new NotificationTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setTransmissionType(1);

        Style0 style0 = new Style0();
        style0.setTitle(title);
        style0.setText(text);

        template.setStyle(style0);

        List<String> appIds = new ArrayList<String>();
        appIds.add(appId);

        // 定义"AppMessage"类型消息对象，设置消息内容模板、发送的目标App列表、是否支持离线发送、以及离线消息有效期(单位毫秒)
        AppMessage message = new AppMessage();
        message.setData(template);
        message.setAppIdList(appIds);
        message.setOffline(true);
        //离线7天
        message.setOfflineExpireTime(7 * 24 * 3600 * 1000);
        Date date = new Date();

        IPushResult ret = getIGtPush().pushMessageToApp(message);
        System.out.println(ret.getResponse().toString());
    }

    public static void pushNotificationTemplate(String clientId, String title, String text, String transmissionContent, String logo, String logoUrl) {
        NotificationTemplate template = new NotificationTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        // 透传消息设置，1为强制启动应用，客户端接收到消息后就会立即启动应用；2为等待应用启动
        template.setTransmissionType(1);
        //传输内容
        template.setTransmissionContent(transmissionContent);

        //设置样式
        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(text);
        // 配置通知栏图标
        style.setLogo(logo);
        // 配置通知栏网络图标
        style.setLogoUrl(logoUrl);
        // 设置通知是否响铃，震动，或者可清除
//        style.setRing(true);
//        style.setVibrate(true);
//        style.setClearable(true);

        template.setStyle(style);

        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);

        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(clientId);
        //设置别名
//        target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = getIGtPush().pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = getIGtPush().pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }

    public static void pushLinkTemplate(String clientId, String title, String text,String url, String logo, String logoUrl) {
        LinkTemplate template = new LinkTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);
        template.setUrl(url);

        //设置样式
        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(text);
        // 配置通知栏图标
        style.setLogo(logo);
        // 配置通知栏网络图标
        style.setLogoUrl(logoUrl);
        // 设置通知是否响铃，震动，或者可清除
//        style.setRing(true);
//        style.setVibrate(true);
//        style.setClearable(true);

        template.setStyle(style);

        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);

        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(clientId);
        //设置别名
//        target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = getIGtPush().pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = getIGtPush().pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }
    public static void pushNotyPopLoadTemplate(String clientId, String title, String text,String url, String logo, String logoUrl) {
        NotyPopLoadTemplate template = new NotyPopLoadTemplate();
        // 设置APPID与APPKEY
        template.setAppId(appId);
        template.setAppkey(appKey);

        Style0 style = new Style0();
        // 设置通知栏标题与内容
        style.setTitle(title);
        style.setText(text);
        // 配置通知栏图标
        style.setLogo(logo);
        // 配置通知栏网络图标
        style.setLogoUrl(logoUrl);
        // 设置通知是否响铃，震动，或者可清除
//        style.setRing(true);
//        style.setVibrate(true);
//        style.setClearable(true);
        template.setStyle(style);

        // 设置弹框标题与内容
        template.setPopTitle("弹框标题");
        template.setPopContent("弹框内容");
        // 设置弹框显示的图片
        template.setPopImage("");
        template.setPopButton1("下载1");
        template.setPopButton2("取消1");
        // 设置下载标题
        template.setLoadTitle("下载标题");
        template.setLoadIcon("file://icon.png");
        //设置下载地址
        template.setLoadUrl("http://gdown.baidu.com/data/wisegame/80bab73f82cc29bf/shoujibaidu_16788496.apk");
        template.setStyle(style);

        SingleMessage message = new SingleMessage();
        message.setOffline(true);
        // 离线有效时间，单位为毫秒，可选
        message.setOfflineExpireTime(24 * 3600 * 1000);
        message.setData(template);
        // 可选，1为wifi，0为不限制网络环境。根据手机处于的网络情况，决定是否下发
        message.setPushNetWorkType(0);

        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(clientId);
        //设置别名
//        target.setAlias(Alias);
        IPushResult ret = null;
        try {
            ret = getIGtPush().pushMessageToSingle(message, target);
        } catch (RequestException e) {
            e.printStackTrace();
            ret = getIGtPush().pushMessageToSingle(message, target, e.getRequestId());
        }
        if (ret != null) {
            System.out.println(ret.getResponse().toString());
        } else {
            System.out.println("服务器响应异常");
        }
    }

}
