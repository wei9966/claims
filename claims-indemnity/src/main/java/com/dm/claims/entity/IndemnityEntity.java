package com.dm.claims.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 赔款表indemnity
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@Data
@TableName("claims_indemnity")
public class IndemnityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 赔款id
	 */
	@TableId
	private Long indemnityId;
	/**
	 * 计算赔款总金额
	 */
	private Double indemnitySum;

}
