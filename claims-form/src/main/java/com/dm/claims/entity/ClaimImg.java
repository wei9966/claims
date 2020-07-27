package com.dm.claims.entity;

import java.io.Serializable;

/**
 * (ClaimImg)实体类
 *
 * @author wb
 * @since 2020-07-27 13:50:36
 */
public class ClaimImg implements Serializable {
    private static final long serialVersionUID = 463664367682191213L;
    /**
    * 图片id
    */
    private Integer claimImgId;
    /**
    * 理赔id
    */
    private Integer claimFormId;
    /**
    * 图片地址
    */
    private String claimImgUri;


    public Integer getClaimImgId() {
        return claimImgId;
    }

    public void setClaimImgId(Integer claimImgId) {
        this.claimImgId = claimImgId;
    }

    public Integer getClaimFormId() {
        return claimFormId;
    }

    public void setClaimFormId(Integer claimFormId) {
        this.claimFormId = claimFormId;
    }

    public String getClaimImgUri() {
        return claimImgUri;
    }

    public void setClaimImgUri(String claimImgUri) {
        this.claimImgUri = claimImgUri;
    }

}