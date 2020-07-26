package com.dm.claims.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 定损表loss_assessment
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-25 09:58:29
 */
@Data
@TableName("claims_loss_assessment")
public class LossAssessmentEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 定损id
	 */
	@TableId
	private Integer clossAssessmentId;
	/**
	 * 交警定责（这里就是指判断双方责任比如46、37等）
	 */
	private String lossAssessmentFixDuty;
	/**
	 * 保险人员（指的是负责定损的人员）
	 */
	private String lossAssessmentFixDutyUser;
	/**
	 * 赔款id
	 */
	private Integer indemnityId;

}
