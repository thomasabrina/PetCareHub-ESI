package com.petcarehub.usermgmts;

public class Usermgmt {

    private int uid;
    private String hashpwd;
    private String name;
    private String email;
    private String addr;

    public Usermgmt() {
    }

    public Usermgmt(int uid, String hashpwd, String name, String email, String addr) {
        this.uid = uid;
        this.hashpwd = hashpwd;
        this.name = name;
        this.email = email;
        this.addr = addr;
    }

    public int getUid() {
        return this.uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getHashpwd() {
        return this.hashpwd;
    }

    public void setHashpwd(String hashpwd) {
        this.hashpwd = hashpwd;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddr() {
        return this.addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

}
