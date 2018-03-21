package com.gongyunhao.sims.Bean;

/**
 * _oo0oo_
 * 08888888o
 * 88" . "88
 * (| -_- |)
 * 0\  =  /0
 * <p>
 * 佛祖保佑代码无bug
 * <p>
 * <p>
 * Created by yuanlai on 2018/3/20.
 */

public class InterestIdAndInterestNameAndInterestCategoryIdBean {

    public InterestIdAndInterestNameAndInterestCategoryIdBean next = null;

    private String interestId;

    private String interestName;

    private String interestCategoryId;

    public InterestIdAndInterestNameAndInterestCategoryIdBean(String interestId, String interestName, String interestCategoryId){
        this.interestId = interestId;
        this.interestName = interestName;
        this.interestCategoryId = interestCategoryId;
    }

    public void setInterestId(String interestId){
        this.interestId = interestId;
    }

    public void setInterestCategoryId(String interestCategoryId){
        this.interestCategoryId = interestCategoryId;
    }

    public void setInterestName(String interestName){
        this.interestName = interestName;
    }

    public String getInterestId(){
        return interestId;
    }

    public String getInterestCategoryId(){
        return interestCategoryId;
    }

    public String getInterestName(){
        return interestName;
    }
}
