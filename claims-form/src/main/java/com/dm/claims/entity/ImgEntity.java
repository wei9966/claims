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
 * @date 2020-07-27 16:18:34
 */
@Data
@TableName("claim_img")
public class ImgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 图片id
	 */
	@TableId
	private Integer claimImgId;
	/**
	 * 理赔id
	 */
	private Integer claimFormId;
	/**
	 * 图片地址
	 */
	private String claimImgUri;

}
