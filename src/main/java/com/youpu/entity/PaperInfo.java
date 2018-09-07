package com.youpu.entity;

import java.io.Serializable;
import java.util.Date;

public class PaperInfo implements Serializable{
	 /**
	 * 
	 */
	private static final long serialVersionUID = 2131226323728083271L;

    private Long id;

    private String areaids;

    private Date testTime;

    private Long schoolId;

    private String name;

    private Integer type;

    private Integer testedNum;

    private Integer testedPeople;

    private Integer semester;

    private Integer paperStatus;

    private String source;

    private Integer paperLibrary;

    private String createrId;

    private Integer subjectId;

    private Integer materialId;

    private Integer chooseNum;

    private Integer answerNum;

    private Integer allNum;

    private Integer hasSubjective;

    private String difficultyValue;

    private Integer score;

    private Integer gradeId;

    private Integer phaseId;

    private Integer answerTokinaga;

    private String distinctionDegree;

    private String remark;

    private String pdfUrl;

    private Integer belongAnalysis;

    private Integer belongScan;

    private Integer belongAccurate;

    private Date createTime;

    private Date updateTime;

    private Integer deleteStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaids() {
        return areaids;
    }

    public void setAreaids(String areaids) {
        this.areaids = areaids == null ? null : areaids.trim();
    }

    public Date getTestTime() {
        return testTime;
    }

    public void setTestTime(Date testTime) {
        this.testTime = testTime;
    }

    public Long getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Long schoolId) {
        this.schoolId = schoolId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getTestedNum() {
        return testedNum;
    }

    public void setTestedNum(Integer testedNum) {
        this.testedNum = testedNum;
    }

    public Integer getTestedPeople() {
        return testedPeople;
    }

    public void setTestedPeople(Integer testedPeople) {
        this.testedPeople = testedPeople;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getPaperStatus() {
        return paperStatus;
    }

    public void setPaperStatus(Integer paperStatus) {
        this.paperStatus = paperStatus;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public Integer getPaperLibrary() {
        return paperLibrary;
    }

    public void setPaperLibrary(Integer paperLibrary) {
        this.paperLibrary = paperLibrary;
    }

    public String getCreaterId() {
        return createrId;
    }

    public void setCreaterId(String createrId) {
        this.createrId = createrId == null ? null : createrId.trim();
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public Integer getMaterialId() {
        return materialId;
    }

    public void setMaterialId(Integer materialId) {
        this.materialId = materialId;
    }

    public Integer getChooseNum() {
        return chooseNum;
    }

    public void setChooseNum(Integer chooseNum) {
        this.chooseNum = chooseNum;
    }

    public Integer getAnswerNum() {
        return answerNum;
    }

    public void setAnswerNum(Integer answerNum) {
        this.answerNum = answerNum;
    }

    public Integer getAllNum() {
        return allNum;
    }

    public void setAllNum(Integer allNum) {
        this.allNum = allNum;
    }

    public Integer getHasSubjective() {
        return hasSubjective;
    }

    public void setHasSubjective(Integer hasSubjective) {
        this.hasSubjective = hasSubjective;
    }

    public String getDifficultyValue() {
        return difficultyValue;
    }

    public void setDifficultyValue(String difficultyValue) {
        this.difficultyValue = difficultyValue == null ? null : difficultyValue.trim();
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getGradeId() {
        return gradeId;
    }

    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    public Integer getPhaseId() {
        return phaseId;
    }

    public void setPhaseId(Integer phaseId) {
        this.phaseId = phaseId;
    }

    public Integer getAnswerTokinaga() {
        return answerTokinaga;
    }

    public void setAnswerTokinaga(Integer answerTokinaga) {
        this.answerTokinaga = answerTokinaga;
    }

    public String getDistinctionDegree() {
        return distinctionDegree;
    }

    public void setDistinctionDegree(String distinctionDegree) {
        this.distinctionDegree = distinctionDegree == null ? null : distinctionDegree.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl == null ? null : pdfUrl.trim();
    }

    public Integer getBelongAnalysis() {
        return belongAnalysis;
    }

    public void setBelongAnalysis(Integer belongAnalysis) {
        this.belongAnalysis = belongAnalysis;
    }

    public Integer getBelongScan() {
        return belongScan;
    }

    public void setBelongScan(Integer belongScan) {
        this.belongScan = belongScan;
    }

    public Integer getBelongAccurate() {
        return belongAccurate;
    }

    public void setBelongAccurate(Integer belongAccurate) {
        this.belongAccurate = belongAccurate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}