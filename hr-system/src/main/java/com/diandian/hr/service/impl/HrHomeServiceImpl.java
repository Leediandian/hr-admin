package com.diandian.hr.service.impl;


import cn.hutool.core.date.DateUtil;
import com.diandian.common.core.domain.AjaxResult;
import com.diandian.common.core.domain.entity.SysDept;
import com.diandian.common.core.domain.entity.SysUser;
import com.diandian.common.utils.DateUtils;
import com.diandian.hr.domain.HrAttendance;
import com.diandian.hr.domain.HrEmployee;
import com.diandian.hr.mapper.HrAttendanceMapper;
import com.diandian.hr.mapper.HrEmployeeMapper;
import com.diandian.hr.service.IHrHomeService;
import com.diandian.system.mapper.SysDeptMapper;
import com.diandian.system.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;


/**
 * 首页可视化Service业务层处理
 *
 * @author diandian
 * @date 2023-02-13
 */
@Service
public class HrHomeServiceImpl implements IHrHomeService {
    @Autowired
    private HrAttendanceMapper hrAttendanceMapper;
    @Autowired
    private HrEmployeeMapper hrEmployeeMapper;
    @Autowired
    private SysUserMapper userMapper;
    @Autowired
    private SysDeptMapper deptMapper;

    /**
     * 通过工号获取员工的当月考勤信息
     *
     * @param workId
     * @param month
     * @return
     */
    @Override
    public AjaxResult getAttendanceData(String workId, String month) {
        if (month == null || month == "") {
            month = DateUtil.format(new java.util.Date(), "yyyyMM");
        }

        String[] monthDayList = DateUtils.getMonthDayList(month);
        HrEmployee arr = new HrEmployee();
        arr.setWorkId(workId);
        List<HrEmployee> hrEmployeeList = hrEmployeeMapper.selectHrEmployeeList(arr);
        if (hrEmployeeList.size() == 0) {
            return AjaxResult.error("获取当月考勤数据失败 员工工号有误");
        }

        HrEmployee hrEmployee = hrEmployeeList.get(0);

        // 考勤状态表
        List<HashMap<String, Object>> list = new ArrayList<>();
        for (String day : monthDayList) {
            HashMap<String, Object> map = new HashMap<>();
            HrAttendance attendance = hrAttendanceMapper.selectHrAttendanceByIdAndDay(hrEmployee.getEmployeeId(), day);
            if (attendance == null) {
                Date date = DateUtil.parse(day, "yyyyMMdd").toSqlDate();
                // 如果是周末就休假
                if (DateUtil.isWeekend(date)) {
                    map.put("value", "4");
                } else {
                    map.put("value", "0");
                }
            } else {
                map.put("value", attendance.getAttendanceStatus());
            }
            list.add(map);
        }
        return AjaxResult.success(list);
    }

    @Override
    public AjaxResult getDepartmentData() {
        SysDept arr = new SysDept();
        List<SysDept> list = deptMapper.selectDeptList(arr);
        List<Map<String, Object>> mapList = new ArrayList<>();
        for (SysDept parentDept : list) {
            Integer num = hrEmployeeMapper.countDept(parentDept.getDeptId());
            Map<String, Object> map = new HashMap<>();
            map.put("value", num);
            map.put("name", parentDept.getDeptName());
            mapList.add(map);
        }
        return AjaxResult.success(mapList);
    }

    @Override
    public AjaxResult getCountData() throws Exception {
        HrEmployee arr = new HrEmployee();
        SysUser arr1 = new SysUser();
        List<HrEmployee> elist = hrEmployeeMapper.selectHrEmployeeList(arr);
        List<SysUser> ulist = userMapper.selectUserList(arr1);

        HashMap<String, Object> result = new HashMap<>();
        //总员工数
        result.put("employeeCont", elist.size());
        //总用户数
        result.put("userCont", ulist.size());

        String month = DateUtil.format(new java.util.Date(), "yyyyMM");
        //离职人数
        Integer notWorkNum = hrEmployeeMapper.countNotWork(month);
        //入职人数
        Integer beginWorkNum =hrEmployeeMapper.countBeginWork(month);
        result.put("notWorkNum",notWorkNum);
        result.put("beginWorkNum",beginWorkNum);

        //学历构成
        Map<String, Object> tiptopDegreeMap = new HashMap<>();
        //年龄构成
        Map<String, Object> ageMap = new HashMap<>();
        //分别是小学 初中 高中 大专 本科  硕士 博士 其他
        int num1 = 0;
        int num2 = 0;
        int num3 = 0;
        int num4 = 0;
        int num5 = 0;
        int num6 = 0;
        int num7 = 0;
        int num8 = 0;
        //分别是20-29岁 30-39岁 40-49岁 50-59岁
        int num9 = 0;
        int num10 = 0;
        int num11 = 0;
        int num12 = 0;
        for (HrEmployee item : elist) {
            switch (item.getTiptopDegree()) {
                case "0":
                    num1++;
                    break;
                case "1":
                    num2++;
                    break;
                case "2":
                    num3++;
                    break;
                case "3":
                    num4++;
                    break;
                case "4":
                    num5++;
                    break;
                case "5":
                    num6++;
                    break;
                case "6":
                    num7++;
                    break;
                default:
                    num8++;
            }
            int age = getAge(item.getBirthday());
            //分别是20-29岁 30-39岁 40-49岁 50-59岁
            if(age >= 20 && age < 30){
                num9++;
            }else if(age >= 30 && age < 40){
                num10++;
            }else if(age >= 40 && age < 50){
                num11++;
            }else if(age >= 50 && age < 60){
                num12++;
            }
        }
        tiptopDegreeMap.put("小学",num1);
        tiptopDegreeMap.put("初中",num2);
        tiptopDegreeMap.put("高中",num3);
        tiptopDegreeMap.put("大专",num4);
        tiptopDegreeMap.put("本科",num5);
        tiptopDegreeMap.put("硕士",num6);
        tiptopDegreeMap.put("博士",num7);
        tiptopDegreeMap.put("其他",num8);
        ageMap.put("20-29岁",num9);
        ageMap.put("30-39岁",num10);
        ageMap.put("40-49岁",num11);
        ageMap.put("50-59岁",num12);
        result.put("tiptopDegreeMap",tiptopDegreeMap);
        result.put("ageMap",ageMap);

        return AjaxResult.success(result);
    }

    //由出生日期获得年龄
    public static int getAge(Date birthDay) throws Exception {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException("The birthDay is before Now.It’s unbelievable !");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }
}
