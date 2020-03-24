package com.wangyaochong.springsecurityboot.generated.dao;

import com.wangyaochong.springsecurityboot.generated.entity.UserRole;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (UserRole)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-24 08:26:17
 */
public interface UserRoleDao {

    /**
     * 通过ID查询单条数据
     *
     * @param  主键
     * @return 实例对象
     */
    List<UserRole> queryById(Long userId );

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UserRole> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param userRole 实例对象
     * @return 对象列表
     */
    List<UserRole> queryAll(UserRole userRole);

    /**
     * 新增数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int insert(UserRole userRole);

    /**
     * 修改数据
     *
     * @param userRole 实例对象
     * @return 影响行数
     */
    int update(UserRole userRole);

    /**
     * 通过主键删除数据
     *
     * @param  主键
     * @return 影响行数
     */
    int deleteById( );



}