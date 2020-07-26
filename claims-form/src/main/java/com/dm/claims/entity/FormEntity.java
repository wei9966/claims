package com.dm.claims.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 理赔表claims_form
 * 
 * @author dmTeam
 * @email 1148098878@qq.com
 * @date 2020-07-15 11:07:50
 */
@Data
@TableName("claims_form")
public class FormEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 理赔id
	 */
	@TableId
	private Integer claimFormId;
	/**
	 * 记录人（这里指客户打电话接电话的人）
	 */
	private String claimFormRecorder;
	/**
	 * 事故原因
	 */
	private String claimFormCause;
	/**
	 * 事故地点
	 */
	private String claimFormSite;
	/**
	 * 险种id
	 */
	private Integer insuranceInserIncludeId;
	/**
	 * 事故图片
	 */
	private String claimFormPicture;
	/**
	 * 勘探人
	 */
	private String claimFormExploration;
	/**
	 * 勘探人手机号
	 */
	private String claimFormExplorationPhone;
	/**
	 * 定损id
	 */
	private Integer lossAssessmentId;
	/**
	 * 理赔资料id
	 */
	private Integer materialId;
	/**
	 * 赔款id
	 */
	private Integer indemnityId;

}
