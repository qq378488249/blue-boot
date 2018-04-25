package com.blue.jiguang;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import cn.jiguang.common.ServiceHelper;
import cn.jiguang.common.connection.NativeHttpClient;
import cn.jiguang.common.connection.NettyHttpClient;
import cn.jiguang.common.resp.ResponseWrapper;
import cn.jpush.api.device.TagAliasResult;
import cn.jpush.api.push.CIDResult;
import cn.jpush.api.push.GroupPushClient;
import cn.jpush.api.push.model.notification.*;
import com.google.gson.*;
import io.netty.handler.codec.http.HttpMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cn.jiguang.common.ClientConfig;
import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Options;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.SMS;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.audience.AudienceTarget;

public class PushExample {
    protected static final Logger log = LoggerFactory.getLogger(PushExample.class);
    
    protected static final String APP_KEY = "34876644032a0bf285a36893";
    protected static final String MASTER_SECRET = "46eba7a340130f250d6782e7";
    protected static final String GROUP_PUSH_KEY = "2c88a01e073a0fe4fc7b167c";
    
    public static final String REGISTRATION_ID = "140fe1da9ea12a03396";

    //推送给生产环境
    private static boolean apnsProduction = true;
    //设置离线保存时间
    private static long timeToLive = 7 * 24 * 3600 * 1000;

    private static Options options = Options.newBuilder()
//            .setApnsProduction(apnsProduction).setTimeToLive(timeToLive)
            .build();
    private static ClientConfig clientConfig = ClientConfig.getInstance();
    private static JPushClient jpushClient = new JPushClient(MASTER_SECRET, APP_KEY, null, clientConfig);

    public static void main(String[] args) {
//        testSendPushWithCustomConfig();
//        testSendIosAlert();
        for (int i = 0; i < 10; i++) {
//            sendPushRegistrationId("biaoti"+i, "neirong"+i, "", "", "120c83f7602e785fedl\n");
            sendPushAll("biaot赛公交卡斯科拉的规划来看his看大家工商卡攻克乃还i"+i, "ne撒大哥离开时间大概时间刚开始感觉快速公交irong"+i, "", "");
        }
//        sendPushAll("biaoti", "neirong", "", "");
//        testGetCidList();
//        testSendPushes();
//        testSendPush_fromJSON();
//        testSendPushWithCallback();
    }

    public static void sendPushRegistrationId(String title, String alert, String extraKey, String extraValue, String... registrationId) {
        if (extraKey == null) {
            extraKey = "";
        }
        if (extraValue == null) {
            extraValue = "";
        }
        Map<String, String> extras = new HashMap<String, String>();
        extras.put(extraKey, extraValue);

        final PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
//                .setAudience(Audience.all())
                .setAudience(Audience.registrationId(registrationId))
                .setNotification(Notification.newBuilder()
                        .setAlert(alert)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title)
                                .addExtras(extras).build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .addExtra(extraKey, extraValue).build())
                        .build())
                .setOptions(options)
                .build();
        try {
            PushResult result = jpushClient.sendPush(payload);
            log.info("Got result - " + result);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
            log.error("Sendno: " + payload.getSendno());

        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
            log.info("Msg ID: " + e.getMsgId());
            log.error("Sendno: " + payload.getSendno());
        }
    }

    public static void sendPushAll(String title, String alert, String extraKey, String extraValue) {
        if (extraKey == null) {
            extraKey = "";
        }
        if (extraValue == null) {
            extraValue = "";
        }
        Map<String, String> extras = new HashMap<String, String>();
        extras.put(extraKey, extraValue);

        final PushPayload payload = PushPayload.newBuilder()
                .setPlatform(Platform.android_ios())
                .setAudience(Audience.all())
//                .setAudience(Audience.registrationId(registrationId))
                .setNotification(Notification.newBuilder()
                        .setAlert(alert)
                        .addPlatformNotification(AndroidNotification.newBuilder()
                                .setTitle(title)
                                .addExtras(extras).build())
                        .addPlatformNotification(IosNotification.newBuilder()
                                .incrBadge(1)
                                .addExtra(extraKey, extraValue).build())
                        .build())
                .setOptions(options)
                .build();
        try {
            PushResult result = jpushClient.sendPush(payload);
            log.info("Got result - " + result);
        } catch (APIConnectionException e) {
            log.error("Connection error. Should retry later. ", e);
            log.error("Sendno: " + payload.getSendno());

        } catch (APIRequestException e) {
            log.error("Error response from JPush server. Should review and fix it. ", e);
            log.info("HTTP Status: " + e.getStatus());
            log.info("Error Code: " + e.getErrorCode());
            log.info("Error Message: " + e.getErrorMessage());
            log.info("Msg ID: " + e.getMsgId());
            log.error("Sendno: " + payload.getSendno());
        }
    }



}

