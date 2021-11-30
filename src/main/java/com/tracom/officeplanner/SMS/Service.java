package com.tracom.officeplanner.SMS;

import org.springframework.beans.factory.annotation.Qualifier;

public class Service {

    private final SmsSender smsSender;

    public Service(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }
    public void sendSms(SmsRequest smsRequest){
        smsSender.sendSms(smsRequest);
    }
}
