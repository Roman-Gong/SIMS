package com.gongyunhao.sims.ArrayList;

import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;

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

public class InterestIdAndInterestNameAndInterestCategoryIdBeanList {

    InterestIdAndInterestNameAndInterestCategoryIdBean head = null;

    public void addInterestIdAndInterestNameAndInterestCategoryIdBean(int interestId, String interestName, int interestCategoryId){

        InterestIdAndInterestNameAndInterestCategoryIdBean interestIdAndInterestNameAndInterestCategoryIdBean = new InterestIdAndInterestNameAndInterestCategoryIdBean(interestId,interestName,interestCategoryId);

        if (head == null) {
            head = interestIdAndInterestNameAndInterestCategoryIdBean;
            return;
        }

        InterestIdAndInterestNameAndInterestCategoryIdBean temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next = interestIdAndInterestNameAndInterestCategoryIdBean;


    }

    //通过兴趣id找兴趣名
    public String getInterestName(int interestsId){

        if (head.getInterestId()==interestsId){
            return head.getInterestName();
        }
        InterestIdAndInterestNameAndInterestCategoryIdBean curInterestIdAndInterestNameAndInterestCatergory = head.next;
        while(curInterestIdAndInterestNameAndInterestCatergory!=null){

            if (curInterestIdAndInterestNameAndInterestCatergory.getInterestId()==interestsId){
                return curInterestIdAndInterestNameAndInterestCatergory.getInterestName();
            }

            curInterestIdAndInterestNameAndInterestCatergory = curInterestIdAndInterestNameAndInterestCatergory.next;


        }
        return null;
    }

    public int getInterestId(String interestName){

        if(head.getInterestName().equals(interestName)){
            return head.getInterestId();
        }
        InterestIdAndInterestNameAndInterestCategoryIdBean curInterestIdAndInterestNameAndInterestCatergory = head.next;
        while(curInterestIdAndInterestNameAndInterestCatergory!=null){

            if (curInterestIdAndInterestNameAndInterestCatergory.getInterestName().equals(interestName)){
                return curInterestIdAndInterestNameAndInterestCatergory.getInterestId();
            }

            curInterestIdAndInterestNameAndInterestCatergory = curInterestIdAndInterestNameAndInterestCatergory.next;
        }

        return 0;

    }

    public boolean setInterestId(int index,int studentInterestId){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setInterestId(studentInterestId);
            return true;
        }

        int i = 2;

        InterestIdAndInterestNameAndInterestCategoryIdBean curStudentAndInterestBean = head.next;

        while(curStudentAndInterestBean!=null){

            if (i==index){
                curStudentAndInterestBean.setInterestId(studentInterestId);
                return true;
            }
            curStudentAndInterestBean = curStudentAndInterestBean.next;
            i++;

        }
        return false;

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

        InterestIdAndInterestNameAndInterestCategoryIdBean curStudentAndInterestBean = head.next;

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

    public boolean setInterestName(int index,String interestName){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setInterestName(interestName);
            return true;
        }

        int i = 2;

        InterestIdAndInterestNameAndInterestCategoryIdBean curStudentAndInterestBean = head.next;

        while(curStudentAndInterestBean!=null){

            if (i==index){
                curStudentAndInterestBean.setInterestName(interestName);
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
        InterestIdAndInterestNameAndInterestCategoryIdBean preNode=head;
        InterestIdAndInterestNameAndInterestCategoryIdBean curNode=head.next;
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
        InterestIdAndInterestNameAndInterestCategoryIdBean temp = head;
        while (temp!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }

}
