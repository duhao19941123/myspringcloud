package com.dh.entity;

/**
 * 数据字典类
 * @author DH
 */
public class Type {
    private String id;

    private String typecode;

    private String typename;

    private String typepid;

    private String typegroupid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTypecode() {
        return typecode;
    }

    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getTypepid() {
        return typepid;
    }

    public void setTypepid(String typepid) {
        this.typepid = typepid;
    }

    public String getTypegroupid() {
        return typegroupid;
    }

    public void setTypegroupid(String typegroupid) {
        this.typegroupid = typegroupid;
    }
}