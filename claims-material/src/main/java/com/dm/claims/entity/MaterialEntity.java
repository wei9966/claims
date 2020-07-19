package com.dm.claims.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import lombok.Data;

/**
 * 理赔资料表material
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@Data
@TableName("claims_material")
public class MaterialEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 理赔资料id
	 */
	@TableId
	private Integer materialId;
	/**
	 * 客户银行卡号
	 */
	private String materialBankCard;
	/**
	 * 客和银行卡对应的名字
	 */
	private String materialBankCardUser;
	/**
	 * 被保险人的id（通过被保险人的id获取被保险人的姓名身份证号码如果是公司的车辆这里就是获取公司的名称和公司的组织机构代码）
	 */
	private Integer insuredId;

}
