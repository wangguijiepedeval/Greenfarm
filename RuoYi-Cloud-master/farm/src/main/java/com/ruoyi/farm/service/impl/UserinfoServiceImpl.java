package com.ruoyi.farm.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.farm.mapper.UserinfoMapper;
import com.ruoyi.farm.domain.Userinfo;
import com.ruoyi.farm.service.IUserinfoService;

/**
 * userinfo管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-04
 */
@Service
public class UserinfoServiceImpl implements IUserinfoService 
{
    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 查询userinfo管理
     * 
     * @param uesrid userinfo管理主键
     * @return userinfo管理
     */
    @Override
    public Userinfo selectUserinfoByUesrid(String uesrid)
    {
        return userinfoMapper.selectUserinfoByUesrid(uesrid);
    }

    /**
     * 查询userinfo管理列表
     * 
     * @param userinfo userinfo管理
     * @return userinfo管理
     */
    @Override
    public List<Userinfo> selectUserinfoList(Userinfo userinfo)
    {
        return userinfoMapper.selectUserinfoList(userinfo);
    }

    /**
     * 新增userinfo管理
     * 
     * @param userinfo userinfo管理
     * @return 结果
     */
    @Override
    public int insertUserinfo(Userinfo userinfo)
    {
        userinfo.setCreateTime(DateUtils.getNowDate());
        return userinfoMapper.insertUserinfo(userinfo);
    }

    /**
     * 修改userinfo管理
     * 
     * @param userinfo userinfo管理
     * @return 结果
     */
    @Override
    public int updateUserinfo(Userinfo userinfo)
    {
        userinfo.setUpdateTime(DateUtils.getNowDate());
        return userinfoMapper.updateUserinfo(userinfo);
    }

    /**
     * 批量删除userinfo管理
     * 
     * @param uesrids 需要删除的userinfo管理主键
     * @return 结果
     */
    @Override
    public int deleteUserinfoByUesrids(String[] uesrids)
    {
        return userinfoMapper.deleteUserinfoByUesrids(uesrids);
    }

    /**
     * 删除userinfo管理信息
     * 
     * @param uesrid userinfo管理主键
     * @return 结果
     */
    @Override
    public int deleteUserinfoByUesrid(String uesrid)
    {
        return userinfoMapper.deleteUserinfoByUesrid(uesrid);
    }
}
