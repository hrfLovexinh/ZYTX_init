package com.zytx.init.domain;


import java.sql.Date;

public class ElevatorInfo {

    /** DATA_ID */
    private int id;

    /** 二维码ID */
    private java.lang.String twoCodeId;
    /** 电梯编号 */
    private java.lang.String registNumber;
    /** 地址 */
    private java.lang.String address;
    /** 内部使用编号 */
    private java.lang.String useNumber;
    /** 注册代码 */
    private java.lang.String registCode;
    /** 电梯类别 */
    private java.lang.String eleType;
    /** 名称 */
    private java.lang.String name;
    /** 电梯类型 */
    private java.lang.String eleMode;
    /** 检验人员 */
    private java.lang.String inspector;
    /** 下次检验日期 */
    private java.lang.String nextInspectDate;
    /** 物管公司ID */
    private int wgCompanyId;
    /** 运维公司ID */
    private int ywCompanyId;
    /** 制造公司ID */
    private int zzCompanyId;
    /** 安装公司ID */
    private int azCompanyId;
    /** 检验公司ID */
    private int jyCompanyId;
    /** 质监公司ID */
    private int zjCompanyId;
    /** 电梯速度 */
    private java.lang.String speed;
    /** 额定荷载 */
    private java.lang.String eleLoad;
    /** 层站 */
    private java.lang.String eleStop;
    /** 室内外 */
    private java.lang.String inoutDoor;
    /** 高度 */
    private java.lang.String eleheight;
    /** 宽度 */
    private java.lang.String elewidth;
    /** 手机唯一码 */
    private java.lang.String mobileCode;
    /** 入库时间 */
    private java.sql.Date ruKudate;
    /** 数据传输标志 */
    private int isVaild;
    private String deviceId;
    private String deviceId2;
    /**所属区域*/
    private String area;
    /**所在乡镇/街道*/
    private int townshipStreets;
    /**楼盘名称*/
    private String buildingName;
    /**所在栋*/
    private String building;
    /**所在单元*/
    private String unit;
    /**坐标*/
    private String coordinates;
    /**制造日期*/
    private String manufactDate;
    /**出厂编号*/
    private String factoryNum;
    /**投用日期*/
    private String useDate;
    /**检验类别*/
    private String checkCategory;
    /**检验结论*/
    private String checkResult;
    /**报告编号*/
    private String checkReportNum;
    /**检验日期*/
    private String inspectDate;
    /**登记编号*/
    private String registCode2;
    /**注册登记人员*/
    private String registor;
    /**备注*/
    private String note;
    private String map_X;
    private String map_Y;
    private String updateTime;
    private int ischangInfo;
    private int oldywCompanyId;
    private String safetyManDepart;
    private String safetyManPerson;
    private String safetyManPersonTel;
    private String propertyRightsUnit;
    private String completeAcceptanceDate;
    private String acceptanceDateDepart;
    private String acceptanceReportNum;
    private String mContractVdate;
    private String handleCompany;
    private String handleCompanyCode;
    private String changeWay;
    private String shibieCode;
    private String neleType;
    private String usePlace;
    private String precise;
    /** 确认电梯坐标方式标志 */
    private int dealCoordinate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTwoCodeId() {
        return twoCodeId;
    }

    public void setTwoCodeId(String twoCodeId) {
        this.twoCodeId = twoCodeId;
    }

    public String getRegistNumber() {
        return registNumber;
    }

    public void setRegistNumber(String registNumber) {
        this.registNumber = registNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getUseNumber() {
        return useNumber;
    }

    public void setUseNumber(String useNumber) {
        this.useNumber = useNumber;
    }

    public String getRegistCode() {
        return registCode;
    }

    public void setRegistCode(String registCode) {
        this.registCode = registCode;
    }

    public String getEleType() {
        return eleType;
    }

    public void setEleType(String eleType) {
        this.eleType = eleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEleMode() {
        return eleMode;
    }

    public void setEleMode(String eleMode) {
        this.eleMode = eleMode;
    }

    public String getInspector() {
        return inspector;
    }

    public void setInspector(String inspector) {
        this.inspector = inspector;
    }

    public String getNextInspectDate() {
        return nextInspectDate;
    }

    public void setNextInspectDate(String nextInspectDate) {
        this.nextInspectDate = nextInspectDate;
    }

    public int getWgCompanyId() {
        return wgCompanyId;
    }

    public void setWgCompanyId(int wgCompanyId) {
        this.wgCompanyId = wgCompanyId;
    }

    public int getYwCompanyId() {
        return ywCompanyId;
    }

    public void setYwCompanyId(int ywCompanyId) {
        this.ywCompanyId = ywCompanyId;
    }

    public int getZzCompanyId() {
        return zzCompanyId;
    }

    public void setZzCompanyId(int zzCompanyId) {
        this.zzCompanyId = zzCompanyId;
    }

    public int getAzCompanyId() {
        return azCompanyId;
    }

    public void setAzCompanyId(int azCompanyId) {
        this.azCompanyId = azCompanyId;
    }

    public int getJyCompanyId() {
        return jyCompanyId;
    }

    public void setJyCompanyId(int jyCompanyId) {
        this.jyCompanyId = jyCompanyId;
    }

    public int getZjCompanyId() {
        return zjCompanyId;
    }

    public void setZjCompanyId(int zjCompanyId) {
        this.zjCompanyId = zjCompanyId;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getEleLoad() {
        return eleLoad;
    }

    public void setEleLoad(String eleLoad) {
        this.eleLoad = eleLoad;
    }

    public String getEleStop() {
        return eleStop;
    }

    public void setEleStop(String eleStop) {
        this.eleStop = eleStop;
    }

    public String getInoutDoor() {
        return inoutDoor;
    }

    public void setInoutDoor(String inoutDoor) {
        this.inoutDoor = inoutDoor;
    }

    public String getEleheight() {
        return eleheight;
    }

    public void setEleheight(String eleheight) {
        this.eleheight = eleheight;
    }

    public String getElewidth() {
        return elewidth;
    }

    public void setElewidth(String elewidth) {
        this.elewidth = elewidth;
    }

    public String getMobileCode() {
        return mobileCode;
    }

    public void setMobileCode(String mobileCode) {
        this.mobileCode = mobileCode;
    }

    public Date getRuKudate() {
        return ruKudate;
    }

    public void setRuKudate(Date ruKudate) {
        this.ruKudate = ruKudate;
    }

    public int getIsVaild() {
        return isVaild;
    }

    public void setIsVaild(int isVaild) {
        this.isVaild = isVaild;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceId2() {
        return deviceId2;
    }

    public void setDeviceId2(String deviceId2) {
        this.deviceId2 = deviceId2;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public int getTownshipStreets() {
        return townshipStreets;
    }

    public void setTownshipStreets(int townshipStreets) {
        this.townshipStreets = townshipStreets;
    }

    public String getBuildingName() {
        return buildingName;
    }

    public void setBuildingName(String buildingName) {
        this.buildingName = buildingName;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(String coordinates) {
        this.coordinates = coordinates;
    }

    public String getManufactDate() {
        return manufactDate;
    }

    public void setManufactDate(String manufactDate) {
        this.manufactDate = manufactDate;
    }

    public String getFactoryNum() {
        return factoryNum;
    }

    public void setFactoryNum(String factoryNum) {
        this.factoryNum = factoryNum;
    }

    public String getUseDate() {
        return useDate;
    }

    public void setUseDate(String useDate) {
        this.useDate = useDate;
    }

    public String getCheckCategory() {
        return checkCategory;
    }

    public void setCheckCategory(String checkCategory) {
        this.checkCategory = checkCategory;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckReportNum() {
        return checkReportNum;
    }

    public void setCheckReportNum(String checkReportNum) {
        this.checkReportNum = checkReportNum;
    }

    public String getInspectDate() {
        return inspectDate;
    }

    public void setInspectDate(String inspectDate) {
        this.inspectDate = inspectDate;
    }

    public String getRegistCode2() {
        return registCode2;
    }

    public void setRegistCode2(String registCode2) {
        this.registCode2 = registCode2;
    }

    public String getRegistor() {
        return registor;
    }

    public void setRegistor(String registor) {
        this.registor = registor;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getMap_X() {
        return map_X;
    }

    public void setMap_X(String map_X) {
        this.map_X = map_X;
    }

    public String getMap_Y() {
        return map_Y;
    }

    public void setMap_Y(String map_Y) {
        this.map_Y = map_Y;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public int getIschangInfo() {
        return ischangInfo;
    }

    public void setIschangInfo(int ischangInfo) {
        this.ischangInfo = ischangInfo;
    }

    public int getOldywCompanyId() {
        return oldywCompanyId;
    }

    public void setOldywCompanyId(int oldywCompanyId) {
        this.oldywCompanyId = oldywCompanyId;
    }

    public String getSafetyManDepart() {
        return safetyManDepart;
    }

    public void setSafetyManDepart(String safetyManDepart) {
        this.safetyManDepart = safetyManDepart;
    }

    public String getSafetyManPerson() {
        return safetyManPerson;
    }

    public void setSafetyManPerson(String safetyManPerson) {
        this.safetyManPerson = safetyManPerson;
    }

    public String getSafetyManPersonTel() {
        return safetyManPersonTel;
    }

    public void setSafetyManPersonTel(String safetyManPersonTel) {
        this.safetyManPersonTel = safetyManPersonTel;
    }

    public String getPropertyRightsUnit() {
        return propertyRightsUnit;
    }

    public void setPropertyRightsUnit(String propertyRightsUnit) {
        this.propertyRightsUnit = propertyRightsUnit;
    }

    public String getCompleteAcceptanceDate() {
        return completeAcceptanceDate;
    }

    public void setCompleteAcceptanceDate(String completeAcceptanceDate) {
        this.completeAcceptanceDate = completeAcceptanceDate;
    }

    public String getAcceptanceDateDepart() {
        return acceptanceDateDepart;
    }

    public void setAcceptanceDateDepart(String acceptanceDateDepart) {
        this.acceptanceDateDepart = acceptanceDateDepart;
    }

    public String getAcceptanceReportNum() {
        return acceptanceReportNum;
    }

    public void setAcceptanceReportNum(String acceptanceReportNum) {
        this.acceptanceReportNum = acceptanceReportNum;
    }

    public String getmContractVdate() {
        return mContractVdate;
    }

    public void setmContractVdate(String mContractVdate) {
        this.mContractVdate = mContractVdate;
    }

    public String getHandleCompany() {
        return handleCompany;
    }

    public void setHandleCompany(String handleCompany) {
        this.handleCompany = handleCompany;
    }

    public String getHandleCompanyCode() {
        return handleCompanyCode;
    }

    public void setHandleCompanyCode(String handleCompanyCode) {
        this.handleCompanyCode = handleCompanyCode;
    }

    public String getChangeWay() {
        return changeWay;
    }

    public void setChangeWay(String changeWay) {
        this.changeWay = changeWay;
    }

    public String getShibieCode() {
        return shibieCode;
    }

    public void setShibieCode(String shibieCode) {
        this.shibieCode = shibieCode;
    }

    public String getNeleType() {
        return neleType;
    }

    public void setNeleType(String neleType) {
        this.neleType = neleType;
    }

    public String getUsePlace() {
        return usePlace;
    }

    public void setUsePlace(String usePlace) {
        this.usePlace = usePlace;
    }

    public String getPrecise() {
        return precise;
    }

    public void setPrecise(String precise) {
        this.precise = precise;
    }

    public int getDealCoordinate() {
        return dealCoordinate;
    }

    public void setDealCoordinate(int dealCoordinate) {
        this.dealCoordinate = dealCoordinate;
    }
}
