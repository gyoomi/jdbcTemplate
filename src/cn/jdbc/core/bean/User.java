/**
 * Copyright © 2018, TaoDing
 * <p>
 * All Rights Reserved.
 */

package cn.jdbc.core.bean;

import java.io.Serializable;

/**
 * 类功能描述
 *
 * @author Leon
 * @version 2018/5/3 10:11
 */
public class User implements Serializable {
    private Integer id;
    private String username;
    private String sex;
    private String address;
    private String remark;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
