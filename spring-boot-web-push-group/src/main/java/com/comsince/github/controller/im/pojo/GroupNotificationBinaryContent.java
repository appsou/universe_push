/*
 * This file is part of the Wildfire Chat package.
 * (c) Heavyrain2012 <heavyrain.lee@gmail.com>
 *
 * For the full copyright and license information, please view the LICENSE
 * file that was distributed with this source code.
 */

package com.comsince.github.controller.im.pojo;

import com.comsince.github.proto.ProtoConstants;
import com.comsince.github.proto.FSCMessage;
import com.google.gson.Gson;
import com.google.protobuf.ByteString;

import java.util.List;

public class GroupNotificationBinaryContent {
    //groupId
    private String g;

    //operator
    private String o;

    //name
    private String n;

    //members
    private List<String> ms;

    //members
    private String m;

    public GroupNotificationBinaryContent(String g, String o, String n, String m) {
        this.g = g;
        this.o = o;
        this.n = n;
        this.m = m;
    }

    public GroupNotificationBinaryContent(String g, String operator, String name, List<String> members) {
        this.g = g;
        this.o = operator;
        this.n = name;
        this.ms = members;
    }

    public String getG() {
        return g;
    }

    public void setG(String g) {
        this.g = g;
    }

    public String getM() {
        return m;
    }

    public void setM(String m) {
        this.m = m;
    }

    public String getO() {
        return o;
    }

    public void setO(String o) {
        this.o = o;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public List<String> getMs() {
        return ms;
    }

    public void setMs(List<String> ms) {
        this.ms = ms;
    }

    public FSCMessage.MessageContent getGroupNotifyContent(int groupContentType) {
        return FSCMessage.MessageContent.newBuilder().setType(groupContentType).setData(ByteString.copyFromUtf8(new Gson().toJson(this))).build();
    }

    public FSCMessage.MessageContent getAddGroupNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_ADD_GROUP_MEMBER);
    }

    public FSCMessage.MessageContent getCreateGroupNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_CREATE_GROUP);
    }

    public FSCMessage.MessageContent getDismissGroupNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_DISMISS_GROUP);
    }

    public FSCMessage.MessageContent getKickokfMemberGroupNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_KICKOF_GROUP_MEMBER);
    }

    public FSCMessage.MessageContent getQuitGroupNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_QUIT_GROUP);
    }

    public FSCMessage.MessageContent getTransferGroupNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_TRANSFER_GROUP_OWNER);
    }

    public FSCMessage.MessageContent getChangeGroupNameNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_CHANGE_GROUP_NAME);
    }

    public FSCMessage.MessageContent getChangeGroupPortraitNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_CHANGE_GROUP_PORTRAIT);
    }

    public FSCMessage.MessageContent getModifyGroupMemberAliasNotifyContent() {
        return getGroupNotifyContent(ProtoConstants.MESSAGE_CONTENT_TYPE_MODIFY_GROUP_ALIAS);
    }
}
