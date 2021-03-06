package com.comsince.github.websocket.im;

import com.comsince.github.Signal;
import com.comsince.github.SubSignal;
import com.comsince.github.handler.im.Handler;
import com.comsince.github.handler.im.IMTopic;
import com.comsince.github.proto.FSCMessage;
import com.comsince.github.websocket.model.WsGroupDismissRequest;

/**
 * @author comsicne
 * Copyright (c) [2019]
 * @Time 20-5-27 上午11:32
 **/
@Handler(IMTopic.DismissGroupTopic)
public class DismissGroupHandler extends WsImHandler<WsGroupDismissRequest,Byte>{
    @Override
    public byte[] request(Signal signal, SubSignal subSignal, WsGroupDismissRequest wsGroupDismissRequest) {
        FSCMessage.DismissGroupRequest.Builder builder = FSCMessage.DismissGroupRequest.newBuilder();
        builder.setGroupId(wsGroupDismissRequest.getGroupId());
        return builder.build().toByteArray();
    }

    @Override
    public String result(Signal signal, SubSignal subSignal, Byte result) {
        return byteResult(result);
    }
}
