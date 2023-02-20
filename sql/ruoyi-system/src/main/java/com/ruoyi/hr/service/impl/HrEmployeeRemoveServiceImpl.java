package com.ruoyi.hr.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.mapper.HrEmployeeMapper;
import com.ruoyi.system.domain.SysPost;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.ruoyi.system.mapper.SysPostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.hr.mapper.HrEmployeeRemoveMapper;
import com.ruoyi.hr.domain.HrEmployeeRemove;
import com.ruoyi.hr.service.IHrEmployeeRemoveService;

/**
 * 员工调动Service业务层处理
 *
 * @author diandian
 * @date 2023-02-19
 */
@Service
public class HrEmployeeRemoveServiceImpl implements IHrEmployeeRemoveService {
    @Autowired
    private HrEmployeeRemoveMapper hrEmployeeRemoveMapper;
    @Autowired
    private SysPostMapper sysPostMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private HrEmployeeMapper hrEmployeeMapper;


    /**
     * 查询员工调动
     *
     * @param id 员工调动主键
     * @return 员工调动
     */
    @Override
    public HrEmployeeRemove selectHrEmployeeRemoveById(Long id) {
        HrEmployeeRemove hrEmployeeRemove = hrEmployeeRemoveMapper.selectHrEmployeeRemoveById(id);
        SysPost afterPost = sysPostMapper.selectPostById(hrEmployeeRemove.getAfterPostId());
        SysPost beforePost = sysPostMapper.selectPostById(hrEmployeeRemove.getBeforePostId());
        SysDept afterDept = sysDeptMapper.selectDeptById(hrEmployeeRemove.getAfterDeptId());
        SysDept beforeDept = sysDeptMapper.selectDeptById(hrEmployeeRemove.getBeforeDeptId());
        hrEmployeeRemove.setAfterPost(afterPost);
        hrEmployeeRemove.setBeforePost(beforePost);
        hrEmployeeRemove.setAfterDept(afterDept);
        hrEmployeeRemove.setBeforeDept(beforeDept);
        return hrEmployeeRemove;
    }

    /**
     * 查询员工调动列表
     *
     * @param hrEmployeeRemove 员工调动
     * @return 员工调动
     */
    @Override
    public List<HrEmployeeRemove> selectHrEmployeeRemoveList(HrEmployeeRemove hrEmployeeRemove) {
        List<HrEmployeeRemove> list = hrEmployeeRemoveMapper.selectHrEmployeeRemoveList(hrEmployeeRemove);
        list.forEach(item -> {
            SysPost afterPost = sysPostMapper.selectPostById(item.getAfterPostId());
            SysPost beforePost = sysPostMapper.selectPostById(item.getBeforePostId());
            item.setAfterPost(afterPost);
            item.setBeforePost(beforePost);
            SysDept afterDept = sysDeptMapper.selectDeptById(item.getAfterDeptId());
            SysDept beforeDept = sysDeptMapper.selectDeptById(item.getBeforeDeptId());
            item.setAfterDept(afterDept);
            item.setBeforeDept(beforeDept);
        });
        return list;
    }

    /**
     * 新增员工调动
     *
     * @param hrEmployeeRemove 员工调动
     * @return 结果
     */
    @Override
    public int insertHrEmployeeRemove(HrEmployeeRemove hrEmployeeRemove) {
        int num = hrEmployeeRemoveMapper.insertHrEmployeeRemove(hrEmployeeRemove);
        HrEmployee employee = hrEmployeeMapper.selectHrEmployeeByEmployeeId(hrEmployeeRemove.getEmployeeId());
        employee.setDeptId(hrEmployeeRemove.getAfterDeptId());
        employee.setPostId(hrEmployeeRemove.getAfterPostId());
        num = hrEmployeeMapper.updateHrEmployee(employee);
        return num;
    }

    /**
     * 修改员工调动
     *
     * @param hrEmployeeRemove 员工调动
     * @return 结果
     */
    @Override
    public int updateHrEmployeeRemove(HrEmployeeRemove hrEmployeeRemove) {
        return hrEmployeeRemoveMapper.updateHrEmployeeRemove(hrEmployeeRemove);
    }

    /**
     * 批量删除员工调动
     *
     * @param ids 需要删除的员工调动主键
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeRemoveByIds(Long[] ids) {
        return hrEmployeeRemoveMapper.deleteHrEmployeeRemoveByIds(ids);
    }

    /**
     * 删除员工调动信息
     *
     * @param id 员工调动主键
     * @return 结果
     */
    @Override
    public int deleteHrEmployeeRemoveById(Long id) {
        return hrEmployeeRemoveMapper.deleteHrEmployeeRemoveById(id);
    }
}
