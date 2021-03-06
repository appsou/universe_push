package com.comsince.github.websocket.im;

import com.comsince.github.Signal;
import com.comsince.github.SubSignal;
import com.comsince.github.handler.im.Handler;
import com.comsince.github.proto.FSCMessage;
import com.comsince.github.websocket.model.WsModifyGroupInfoRequest;

import static com.comsince.github.handler.im.IMTopic.ModifyGroupInfoTopic;

/**
 * @author comsicne
 * Copyright (c) [2019]
 * @Time 20-5-27 上午11:27
 **/
@Handler(value = ModifyGroupInfoTopic)
public class ModifyGroupInfoHandler extends WsImHandler<WsModifyGroupInfoRequest,Byte>{

    @Override
    public byte[] request(Signal signal, SubSignal subSignal, WsModifyGroupInfoRequest wsModifyGroupInfoRequest) {
        log.info("modify group info {}",wsModifyGroupInfoRequest);
        FSCMessage.ModifyGroupInfoRequest.Builder modifyGroupInfoBuilder = FSCMessage.ModifyGroupInfoRequest.newBuilder();
        modifyGroupInfoBuilder.setGroupId(wsModifyGroupInfoRequest.getGroupId());
        modifyGroupInfoBuilder.setType(wsModifyGroupInfoRequest.getType());
        modifyGroupInfoBuilder.setValue(wsModifyGroupInfoRequest.getValue());
        return modifyGroupInfoBuilder.build().toByteArray();
    }

    @Override
    public String result(Signal signal, SubSignal subSignal, Byte result) {
        return byteResult(result);
    }
}
