package com.mofei.wxlogin.model;

public class WXSessionModel {
    private String session_key;
    private String openid;
    private int expires_in;

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getSession_key() {
        return session_key;
    }
    public void setSession_key(String session_key) {
        this.session_key = session_key;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid;
    }

}
