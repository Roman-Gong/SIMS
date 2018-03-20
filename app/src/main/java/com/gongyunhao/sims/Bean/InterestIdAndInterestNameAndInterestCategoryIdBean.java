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

    private int interestId;

    private String interestName;

    private int interestCategoryId;

    public InterestIdAndInterestNameAndInterestCategoryIdBean(int interestId, String interestName, int interestCategoryId){
        this.interestId = interestId;
        this.interestName = interestName;
        this.interestCategoryId = interestCategoryId;
    }

    public void setInterestId(int interestId){
        this.interestId = interestId;
    }

    public void setInterestCategoryId(int interestCategoryId){
        this.interestCategoryId = interestCategoryId;
    }

    public void setInterestName(String interestName){
        this.interestName = interestName;
    }

    public int getInterestId(){
        return interestId;
    }

    public int getInterestCategoryId(){
        return interestCategoryId;
    }

    public String getInterestName(){
        return interestName;
    }
}
