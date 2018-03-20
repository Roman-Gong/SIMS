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

public class StudentAndInterestBean {

    public StudentAndInterestBean next = null;

    private String studentNumber;

    private int interestId;

    public StudentAndInterestBean(String studentNumber,int interestId){
        this.studentNumber = studentNumber;
        this.interestId = interestId;
    }

    public void setStudentNumber(String studentNumber){
        this.studentNumber = studentNumber;
    }

    public String getStudentNumber(){
        return studentNumber;
    }

    public void setInterestId(int interestId){
        this.interestId = interestId;
    }

    public int getInterestId(){
        return interestId;
    }



}
