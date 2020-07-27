package com.dm.claims.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.dm.claims.entity.ClaimImg;
import com.dm.claims.entity.FormEntity;
import com.dm.claims.entity.ImgEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ClaimImg)表数据库访问层
 *
 * @author wb
 * @since 2020-07-27 13:50:36
 */
@Mapper
public interface ClaimImgDao extends BaseMapper<ClaimImg> {

    /**
     * 通过ID查询单条数据
     *
     * @param claimImgId 主键
     * @return 实例对象
     */
    ClaimImg queryById(Integer claimImgId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<ClaimImg> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param claimImg 实例对象
     * @return 对象列表
     */
    List<ClaimImg> queryAll(ClaimImg claimImg);

    /**
     * 新增数据
     *
     * @param claimImg 实例对象
     * @return 影响行数
     */
    int insert(ClaimImg claimImg);

    /**
     * 修改数据
     *
     * @param claimImg 实例对象
     * @return 影响行数
     */
    int update(ClaimImg claimImg);

    /**
     * 通过主键删除数据
     *
     * @param claimImgId 主键
     * @return 影响行数
     */
    int deleteById(Integer claimImgId);

    void insertListImgs(@Param("uri") String s,@Param("formId") Integer claimFormId);

    /**
     * 根据uri查询
     * @param s uri地址
     * @return
     */
    List<ImgEntity> queryByUri(@Param("uri") String s);

    /**
     * 根据formId删除图片
     * @param i
     */
    void deleteByFormId(@Param("formId") int i);
}