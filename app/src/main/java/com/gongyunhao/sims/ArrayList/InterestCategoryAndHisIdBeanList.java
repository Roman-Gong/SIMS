package com.gongyunhao.sims.ArrayList;

import com.gongyunhao.sims.Bean.InterestCategoryAndHisIdBean;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;

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

public class InterestCategoryAndHisIdBeanList {

    InterestCategoryAndHisIdBean head = null;

    public void addInterestCategoryAndHisIdBean(String interestCategoryName,int interestCategoryId){

        InterestCategoryAndHisIdBean interestCategoryAndHisIdBean = new InterestCategoryAndHisIdBean(interestCategoryId,interestCategoryName);


        if (head == null) {
            head = interestCategoryAndHisIdBean;
            return;
        }

        InterestCategoryAndHisIdBean temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next = interestCategoryAndHisIdBean;

    }

    public boolean setInterestCategoryId(int index,int studentCategoryId){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setInterestCategoryId(studentCategoryId);
            return true;
        }

        int i = 2;

        InterestCategoryAndHisIdBean curStudentAndInterestBean = head.next;

        while(curStudentAndInterestBean!=null){

            if (i==index){
                curStudentAndInterestBean.setInterestCategoryId(studentCategoryId);
                return true;
            }
            curStudentAndInterestBean = curStudentAndInterestBean.next;
            i++;

        }
        return false;

    }

    public boolean setInterestCategoryName(int index,String studentCategoryName){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setInterestCategoryName(studentCategoryName);
            return true;
        }

        int i = 2;

        InterestCategoryAndHisIdBean curStudentAndInterestBean = head.next;

        while(curStudentAndInterestBean!=null){

            if (i==index){
                curStudentAndInterestBean.setInterestCategoryName(studentCategoryName);
                return true;
            }
            curStudentAndInterestBean = curStudentAndInterestBean.next;
            i++;

        }
        return false;

    }

    public boolean deleteStudentBean(int index) {

        if (index<1||index>length()) {
            return false;
        }
        if (index==1) {
            head=head.next;
            return true;
        }
        int i=1;
        InterestCategoryAndHisIdBean preNode=head;
        InterestCategoryAndHisIdBean curNode=head.next;
        while(curNode!=null) {
            if(i==index) {
                preNode.next=curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }

        return false;

    }

    public int length() {
        int length=0;
        InterestCategoryAndHisIdBean temp = head;
        while (temp!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }

}
