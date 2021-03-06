package cn.yuntangnet.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * This class was generated by MyBatis Generator.
 * This class corresponds to the database table user_wechat
 *
 * @mbg.generated do_not_delete_during_merge
 */
public class UserWechat implements Serializable {
    /**
     * Database Column Remarks:
     *   用户主键
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     * Database Column Remarks:
     *   为0表示未关注公众号
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.subscribe
     *
     * @mbg.generated
     */
    private String subscribe;

    /**
     * Database Column Remarks:
     *   公众号唯一ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.openid
     *
     * @mbg.generated
     */
    private String openid;

    /**
     * Database Column Remarks:
     *   开放平台唯一ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.unionid
     *
     * @mbg.generated
     */
    private String unionid;

    /**
     * Database Column Remarks:
     *   昵称
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.nickname
     *
     * @mbg.generated
     */
    private String nickname;

    /**
     * Database Column Remarks:
     *   1.男性，2.女性，0.未知
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.sex
     *
     * @mbg.generated
     */
    private String sex;

    /**
     * Database Column Remarks:
     *   城市
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.city
     *
     * @mbg.generated
     */
    private String city;

    /**
     * Database Column Remarks:
     *   国家
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.country
     *
     * @mbg.generated
     */
    private String country;

    /**
     * Database Column Remarks:
     *   省份
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.province
     *
     * @mbg.generated
     */
    private String province;

    /**
     * Database Column Remarks:
     *   语言
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.languages
     *
     * @mbg.generated
     */
    private String languages;

    /**
     * Database Column Remarks:
     *   头像
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.headimgurl
     *
     * @mbg.generated
     */
    private String headimgurl;

    /**
     * Database Column Remarks:
     *   用户关注时间
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.subcribe_time
     *
     * @mbg.generated
     */
    private Date subcribeTime;

    /**
     * Database Column Remarks:
     *   备注
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * Database Column Remarks:
     *   分组ID
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.groupid
     *
     * @mbg.generated
     */
    private String groupid;

    /**
     * Database Column Remarks:
     *   用户被打上的标签ID列表
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.tagid_list
     *
     * @mbg.generated
     */
    private String tagidList;

    /**
     * Database Column Remarks:
     *   是否已删除：1.已删除，0.未删除
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.is_deleted
     *
     * @mbg.generated
     */
    private Boolean isDeleted;

    /**
     * Database Column Remarks:
     *   创建日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.gmt_create
     *
     * @mbg.generated
     */
    private Date gmtCreate;

    /**
     * Database Column Remarks:
     *   更新日期
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_wechat.gmt_modified
     *
     * @mbg.generated
     */
    private Date gmtModified;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table user_wechat
     *
     * @mbg.generated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.id
     *
     * @return the value of user_wechat.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.id
     *
     * @param id the value for user_wechat.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.subscribe
     *
     * @return the value of user_wechat.subscribe
     *
     * @mbg.generated
     */
    public String getSubscribe() {
        return subscribe;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.subscribe
     *
     * @param subscribe the value for user_wechat.subscribe
     *
     * @mbg.generated
     */
    public void setSubscribe(String subscribe) {
        this.subscribe = subscribe == null ? null : subscribe.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.openid
     *
     * @return the value of user_wechat.openid
     *
     * @mbg.generated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.openid
     *
     * @param openid the value for user_wechat.openid
     *
     * @mbg.generated
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.unionid
     *
     * @return the value of user_wechat.unionid
     *
     * @mbg.generated
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.unionid
     *
     * @param unionid the value for user_wechat.unionid
     *
     * @mbg.generated
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.nickname
     *
     * @return the value of user_wechat.nickname
     *
     * @mbg.generated
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.nickname
     *
     * @param nickname the value for user_wechat.nickname
     *
     * @mbg.generated
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.sex
     *
     * @return the value of user_wechat.sex
     *
     * @mbg.generated
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.sex
     *
     * @param sex the value for user_wechat.sex
     *
     * @mbg.generated
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.city
     *
     * @return the value of user_wechat.city
     *
     * @mbg.generated
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.city
     *
     * @param city the value for user_wechat.city
     *
     * @mbg.generated
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.country
     *
     * @return the value of user_wechat.country
     *
     * @mbg.generated
     */
    public String getCountry() {
        return country;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.country
     *
     * @param country the value for user_wechat.country
     *
     * @mbg.generated
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.province
     *
     * @return the value of user_wechat.province
     *
     * @mbg.generated
     */
    public String getProvince() {
        return province;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.province
     *
     * @param province the value for user_wechat.province
     *
     * @mbg.generated
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.languages
     *
     * @return the value of user_wechat.languages
     *
     * @mbg.generated
     */
    public String getLanguages() {
        return languages;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.languages
     *
     * @param languages the value for user_wechat.languages
     *
     * @mbg.generated
     */
    public void setLanguages(String languages) {
        this.languages = languages == null ? null : languages.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.headimgurl
     *
     * @return the value of user_wechat.headimgurl
     *
     * @mbg.generated
     */
    public String getHeadimgurl() {
        return headimgurl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.headimgurl
     *
     * @param headimgurl the value for user_wechat.headimgurl
     *
     * @mbg.generated
     */
    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl == null ? null : headimgurl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.subcribe_time
     *
     * @return the value of user_wechat.subcribe_time
     *
     * @mbg.generated
     */
    public Date getSubcribeTime() {
        return subcribeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.subcribe_time
     *
     * @param subcribeTime the value for user_wechat.subcribe_time
     *
     * @mbg.generated
     */
    public void setSubcribeTime(Date subcribeTime) {
        this.subcribeTime = subcribeTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.remark
     *
     * @return the value of user_wechat.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.remark
     *
     * @param remark the value for user_wechat.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.groupid
     *
     * @return the value of user_wechat.groupid
     *
     * @mbg.generated
     */
    public String getGroupid() {
        return groupid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.groupid
     *
     * @param groupid the value for user_wechat.groupid
     *
     * @mbg.generated
     */
    public void setGroupid(String groupid) {
        this.groupid = groupid == null ? null : groupid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.tagid_list
     *
     * @return the value of user_wechat.tagid_list
     *
     * @mbg.generated
     */
    public String getTagidList() {
        return tagidList;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.tagid_list
     *
     * @param tagidList the value for user_wechat.tagid_list
     *
     * @mbg.generated
     */
    public void setTagidList(String tagidList) {
        this.tagidList = tagidList == null ? null : tagidList.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.is_deleted
     *
     * @return the value of user_wechat.is_deleted
     *
     * @mbg.generated
     */
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.is_deleted
     *
     * @param isDeleted the value for user_wechat.is_deleted
     *
     * @mbg.generated
     */
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.gmt_create
     *
     * @return the value of user_wechat.gmt_create
     *
     * @mbg.generated
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.gmt_create
     *
     * @param gmtCreate the value for user_wechat.gmt_create
     *
     * @mbg.generated
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_wechat.gmt_modified
     *
     * @return the value of user_wechat.gmt_modified
     *
     * @mbg.generated
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_wechat.gmt_modified
     *
     * @param gmtModified the value for user_wechat.gmt_modified
     *
     * @mbg.generated
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}