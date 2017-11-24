package com.smart.admin.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 业务用户
 * </p>
 *
 * @author xiaobai
 * @since 2017-11-24
 */
@TableName("smart_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
	@TableId(value="id", type= IdType.AUTO)
	private Long id;
    /**
     * 手机号
     */
	private String mobile;
    /**
     * 昵称
     */
	@TableField("nick_name")
	private String nickName;
    /**
     * 密码
     */
	private String password;
    /**
     * 盐
     */
	private String salt;
    /**
     * openid
     */
	@TableField("open_id")
	private String openId;
    /**
     * 微信唯一id
     */
	@TableField("union_id")
	private String unionId;
    /**
     * 头像
     */
	private String avatar;
    /**
     * 是否停用
     */
	@TableField("is_stop")
	private Boolean isStop;
    /**
     * 创建时间
     */
	@TableField("create_time")
	private Date createTime;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUnionId() {
		return unionId;
	}

	public void setUnionId(String unionId) {
		this.unionId = unionId;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public Boolean isIsStop() {
		return isStop;
	}

	public void setIsStop(Boolean isStop) {
		this.isStop = isStop;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public static final String ID = "id";

	public static final String MOBILE = "mobile";

	public static final String NICK_NAME = "nick_name";

	public static final String PASSWORD = "password";

	public static final String SALT = "salt";

	public static final String OPEN_ID = "open_id";

	public static final String UNION_ID = "union_id";

	public static final String AVATAR = "avatar";

	public static final String IS_STOP = "is_stop";

	public static final String CREATE_TIME = "create_time";

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", mobile=" + mobile +
			", nickName=" + nickName +
			", password=" + password +
			", salt=" + salt +
			", openId=" + openId +
			", unionId=" + unionId +
			", avatar=" + avatar +
			", isStop=" + isStop +
			", createTime=" + createTime +
			"}";
	}
}
