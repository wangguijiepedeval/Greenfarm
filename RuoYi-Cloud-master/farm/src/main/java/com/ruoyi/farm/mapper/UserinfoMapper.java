package com.ruoyi.farm.mapper;

import java.util.List;
import com.ruoyi.farm.domain.Userinfo;

/**
 * userinfo管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
public interface UserinfoMapper 
{
    /**
     * 查询userinfo管理
     * 
     * @param uesrid userinfo管理主键
     * @return userinfo管理
     */
    public Userinfo selectUserinfoByUesrid(String uesrid);

    /**
     * 查询userinfo管理列表
     * 
     * @param userinfo userinfo管理
     * @return userinfo管理集合
     */
    public List<Userinfo> selectUserinfoList(Userinfo userinfo);

    /**
     * 新增userinfo管理
     * 
     * @param userinfo userinfo管理
     * @return 结果
     */
    public int insertUserinfo(Userinfo userinfo);

    /**
     * 修改userinfo管理
     * 
     * @param userinfo userinfo管理
     * @return 结果
     */
    public int updateUserinfo(Userinfo userinfo);

    /**
     * 删除userinfo管理
     * 
     * @param uesrid userinfo管理主键
     * @return 结果
     */
    public int deleteUserinfoByUesrid(String uesrid);

    /**
     * 批量删除userinfo管理
     * 
     * @param uesrids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserinfoByUesrids(String[] uesrids);
}
