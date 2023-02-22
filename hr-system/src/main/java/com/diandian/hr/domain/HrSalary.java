package com.diandian.hr.domain;

import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.diandian.common.annotation.Excel;
import com.diandian.common.core.domain.BaseEntity;

/**
 * 薪资账套管理对象 hr_salary
 *
 * @author ruoyi
 * @date 2023-02-13
 */
public class HrSalary extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 薪资编号
     */
    private Long salaryId;

    /**
     * 薪资账套名称
     */
    @Excel(name = "薪资账套名称")
    private String salaryName;

    /**
     * 基本工资
     */
    @Excel(name = "基本工资")
    private BigDecimal basicSalary;

    /**
     * 奖金
     */
    @Excel(name = "奖金")
    private BigDecimal bonus;

    /**
     * 午餐补助
     */
    @Excel(name = "午餐补助")
    private BigDecimal lunchSalary;

    /**
     * 交通补助
     */
    @Excel(name = "交通补助")
    private BigDecimal trafficSalary;

    /**
     * 应发工资
     */
    @Excel(name = "应发工资")
    private BigDecimal allSalary;

    /**
     * 养老金基数
     */
    @Excel(name = "养老金基数")
    private BigDecimal pensionBase;

    /**
     * 养老金比率
     */
    @Excel(name = "养老金比率")
    private BigDecimal pensionPer;

    /**
     * 医疗基数
     */
    @Excel(name = "医疗基数")
    private BigDecimal medicalBase;

    /**
     * 医疗保险比率
     */
    @Excel(name = "医疗保险比率")
    private BigDecimal medicalPer;

    /**
     * 公积金基数
     */
    @Excel(name = "公积金基数")
    private BigDecimal accumulationFundbase;

    /**
     * 公积金比率
     */
    @Excel(name = "公积金比率")
    private BigDecimal accumulationFundper;

    public void setSalaryId(Long salaryId) {
        this.salaryId = salaryId;
    }

    public Long getSalaryId() {
        return salaryId;
    }

    public void setSalaryName(String salaryName) {
        this.salaryName = salaryName;
    }

    public String getSalaryName() {
        return salaryName;
    }

    public void setBasicSalary(BigDecimal basicSalary) {
        this.basicSalary = basicSalary;
    }

    public BigDecimal getBasicSalary() {
        return basicSalary;
    }

    public void setBonus(BigDecimal bonus) {
        this.bonus = bonus;
    }

    public BigDecimal getBonus() {
        return bonus;
    }

    public void setLunchSalary(BigDecimal lunchSalary) {
        this.lunchSalary = lunchSalary;
    }

    public BigDecimal getLunchSalary() {
        return lunchSalary;
    }

    public void setTrafficSalary(BigDecimal trafficSalary) {
        this.trafficSalary = trafficSalary;
    }

    public BigDecimal getTrafficSalary() {
        return trafficSalary;
    }

    public void setAllSalary(BigDecimal allSalary) {
        this.allSalary = allSalary;
    }

    public BigDecimal getAllSalary() {
        return allSalary;
    }

    public void setPensionBase(BigDecimal pensionBase) {
        this.pensionBase = pensionBase;
    }

    public BigDecimal getPensionBase() {
        return pensionBase;
    }

    public void setPensionPer(BigDecimal pensionPer) {
        this.pensionPer = pensionPer;
    }

    public BigDecimal getPensionPer() {
        return pensionPer;
    }

    public void setMedicalBase(BigDecimal medicalBase) {
        this.medicalBase = medicalBase;
    }

    public BigDecimal getMedicalBase() {
        return medicalBase;
    }

    public void setMedicalPer(BigDecimal medicalPer) {
        this.medicalPer = medicalPer;
    }

    public BigDecimal getMedicalPer() {
        return medicalPer;
    }

    public void setAccumulationFundbase(BigDecimal accumulationFundbase) {
        this.accumulationFundbase = accumulationFundbase;
    }

    public BigDecimal getAccumulationFundbase() {
        return accumulationFundbase;
    }

    public void setAccumulationFundper(BigDecimal accumulationFundper) {
        this.accumulationFundper = accumulationFundper;
    }

    public BigDecimal getAccumulationFundper() {
        return accumulationFundper;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("salaryId", getSalaryId())
                .append("salaryName", getSalaryName())
                .append("basicSalary", getBasicSalary())
                .append("bonus", getBonus())
                .append("lunchSalary", getLunchSalary())
                .append("trafficSalary", getTrafficSalary())
                .append("allSalary", getAllSalary())
                .append("pensionBase", getPensionBase())
                .append("pensionPer", getPensionPer())
                .append("medicalBase", getMedicalBase())
                .append("medicalPer", getMedicalPer())
                .append("accumulationFundbase", getAccumulationFundbase())
                .append("accumulationFundper", getAccumulationFundper())
                .toString();
    }
}
