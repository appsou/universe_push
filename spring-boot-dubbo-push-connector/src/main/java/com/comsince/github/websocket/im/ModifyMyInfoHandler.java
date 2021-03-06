package com.comsince.github.websocket.im;

import com.comsince.github.Signal;
import com.comsince.github.SubSignal;
import com.comsince.github.handler.im.Handler;
import com.comsince.github.handler.im.IMTopic;
import com.comsince.github.proto.FSCMessage;
import com.comsince.github.websocket.model.WsModifyMyInfoRequest;

/**
 * @author comsicne
 * Copyright (c) [2019]
 * @Time 20-5-27 下午2:26
 **/
@Handler(IMTopic.ModifyMyInfoTopic)
public class ModifyMyInfoHandler extends WsImHandler<WsModifyMyInfoRequest,Byte>{

    @Override
    public byte[] request(Signal signal, SubSignal subSignal, WsModifyMyInfoRequest wsModifyMyInfoRequest) {
        log.info("modify myInfo {}",wsModifyMyInfoRequest);
        FSCMessage.ModifyMyInfoRequest.Builder modifyMyInfoBuilder = FSCMessage.ModifyMyInfoRequest.newBuilder();
        FSCMessage.InfoEntry infoEntry = FSCMessage.InfoEntry.newBuilder()
                .setType(wsModifyMyInfoRequest.getType())
                .setValue(wsModifyMyInfoRequest.getValue()).build();
        modifyMyInfoBuilder.addEntry(infoEntry);
        return modifyMyInfoBuilder.build().toByteArray();
    }

    @Override
    public String result(Signal signal, SubSignal subSignal, Byte result) {
        return byteResult(result);
    }
}
