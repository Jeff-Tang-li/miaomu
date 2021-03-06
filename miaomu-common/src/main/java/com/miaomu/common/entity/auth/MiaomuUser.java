package com.miaomu.common.entity.auth;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author jeff·Tang
 * @since 2020-11-19
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MiaomuUser extends Model<MiaomuUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户账户不能为空
     */
    private String userAccount;

    /**
     * 账户密码
     */
    private String userPassword;

    /**
     * 用户email
     */
    private String userEmail;

    /**
     * 用户手机号
     */
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
    private LocalDateTime userBorth;

    /**
     * 最后一次登录时间
     */
    private LocalDateTime lastLogin;

    /**
     * 第一次登录时间
     */
    private LocalDateTime firstLogin;

    /**
     * 0女 1男
     */
    private Boolean userSex;

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


    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    private Integer updateBy;

    /**
     * 0无效,1有效
     */
    @TableField(fill = FieldFill.INSERT)
    private Boolean isValued;

    /**
     * 加密盐值
     */
    private String saltCode;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
