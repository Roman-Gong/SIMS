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

public class InterestCategoryAndHisIdBean {

    public InterestCategoryAndHisIdBean next = null;

    private String interestCategoryName;

    private int interestCategoryId;

    public InterestCategoryAndHisIdBean(String interestCategoryName,int interestCategoryId){
        this.interestCategoryName = interestCategoryName;
        this.interestCategoryId = interestCategoryId;
    }

    public int getInterestCategoryId(){
        return interestCategoryId;
    }

    public void setInterestCategoryId(int interestCategoryId){
        this.interestCategoryId = interestCategoryId;
    }

    public String getInterestCategoryName(){
        return interestCategoryName;
    }

    public void setInterestCategoryName(String interestCategoryName){
        this.interestCategoryName = interestCategoryName;
    }
}
