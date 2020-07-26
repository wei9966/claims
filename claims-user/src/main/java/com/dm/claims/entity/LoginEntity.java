package com.dm.claims.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * 
 * @author wb
 * @email 996649855@qq.com
 * @date 2020-07-26 14:14:00
 */
@Data
@TableName("insurance_login")
public class LoginEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 登录id
	 */
	@TableId
	private Integer insuranceLoginId;
	/**
	 * 登录用户名
	 */
	private String insuranceLoginUser;
	/**
	 * 登录密码
	 */
	private String insuranceLoginPassword;
	/**
	 * 角色id
	 */
	private Integer roleId;
	/**
	 * 登录手机号
	 */
	private String insuranceLoginPhone;
	/**
	 * 登录邮箱
	 */
	private String insuranceLoginEmai;

}
