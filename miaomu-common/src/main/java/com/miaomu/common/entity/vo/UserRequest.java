package com.miaomu.common.entity.vo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data

public class UserRequest {

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账户不能为空
     */
    @NotBlank(message = "请输入账号")
    private String userAccount;

    /**
     * 账户密码
     */
    @NotBlank(message = "请输入密码")
    private String userPassword;

    /**
     * 用户email
     */
    private String userEmail;

    /**
     * 用户手机号
     */
    @NotBlank(message = "请输入手机号")
    private String userPhone;

    /**
     * 昵称
     */
    private String userNick;

    /**
     * 心情
     */
    private String userMood;

    /**
     * 头像
     */
    private String headImage;

    /**
     * 生日
     */
    private String userBorth;

    /**
     * 0女 1男
     */
    private Integer userSex;

    /**
     * 省界限 code值
     */
    private Integer provice;

    /**
     * 市界限code值
     */
    private Integer city;

    /**
     * 县/区界限 code值
     */
    private Integer area;

    /**
     * 具体门牌号地址
     */
    private String address;

}
