package com.ruoyi.hr.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import com.ruoyi.common.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.ruoyi.hr.domain.HrEmployee;
import com.ruoyi.hr.mapper.HrEmpSalaryMapper;
import com.ruoyi.hr.domain.HrEmpSalary;
import com.ruoyi.hr.service.IHrEmpSalaryService;

/**
 * 员工账套管理Service业务层处理
 *
 * @author 点点
 * @date 2023-02-13
 */
@Service
public class HrEmpSalaryServiceImpl implements IHrEmpSalaryService {
    private static final Logger log = LoggerFactory.getLogger(HrEmpSalaryServiceImpl.class);
    @Autowired
    private HrEmpSalaryMapper hrEmpSalaryMapper;

    /**
     * 查询员工账套管理
     *
     * @param id 员工账套管理主键
     * @return 员工账套管理
     */
    @Override
    public HrEmpSalary selectHrEmpSalaryById(Long id) {
        return hrEmpSalaryMapper.selectHrEmpSalaryById(id);
    }

    /**
     * 查询员工账套管理列表
     *
     * @param hrEmpSalary 员工账套管理
     * @return 员工账套管理
     */
    @Override
    public List<HrEmpSalary> selectHrEmpSalaryList(HrEmpSalary hrEmpSalary) {
        return hrEmpSalaryMapper.selectHrEmpSalaryList(hrEmpSalary);
    }

    /**
     * 新增员工账套管理
     *
     * @param hrEmpSalary 员工账套管理
     * @return 结果
     */
    @Transactional
    @Override
    public int insertHrEmpSalary(HrEmpSalary hrEmpSalary) {
        int rows = 0;
        try {
             rows = hrEmpSalaryMapper.insertHrEmpSalary(hrEmpSalary);
        }catch (Exception e){
            String msg = "<br/>"  + "员工" + hrEmpSalary.getEmployeeName() + hrEmpSalary.getSalaryName() + " 薪资账套绑定失败";
            log.error(msg, e);
        }
       
        return rows;
    }

    /**
     * 修改员工账套管理
     *
     * @param hrEmpSalary 员工账套管理
     * @return 结果
     */
    @Transactional
    @Override
    public int updateHrEmpSalary(HrEmpSalary hrEmpSalary) {
        return hrEmpSalaryMapper.updateHrEmpSalary(hrEmpSalary);
    }

    /**
     * 批量删除员工账套管理
     *
     * @param ids 需要删除的员工账套管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrEmpSalaryByIds(Long[] ids) {

        return hrEmpSalaryMapper.deleteHrEmpSalaryByIds(ids);
    }

    /**
     * 删除员工账套管理信息
     *
     * @param id 员工账套管理主键
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteHrEmpSalaryById(Long id) {
        return hrEmpSalaryMapper.deleteHrEmpSalaryById(id);
    }


}
