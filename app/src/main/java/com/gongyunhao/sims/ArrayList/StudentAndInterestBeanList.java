package com.gongyunhao.sims.ArrayList;

import com.gongyunhao.sims.Bean.StudentAndInterestBean;
import com.gongyunhao.sims.Bean.StudentBean;

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

public class StudentAndInterestBeanList {

    StudentAndInterestBean head = null;

    public void addStudentAndInterestBean (String studentNumber,String interestId){

        StudentAndInterestBean studentAndInterestBean = new StudentAndInterestBean(studentNumber, interestId);

        if (head == null) {
            head = studentAndInterestBean;
            return;
        }

        StudentAndInterestBean temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next = studentAndInterestBean;

    }

//    public int[] findByStudentNumber(String studentNumber){

//        int interests[] = new int[50];
//
//        int index = 0;
//
//        if (head.getStudentNumber().equals(studentNumber)){
//            interests[index] = head.getInterestId();
//            index++;
//        }
//
//        StudentAndInterestBean curStudentAndInterestBean = head.next;
//
//        while(curStudentAndInterestBean != null){
//            if (curStudentAndInterestBean.getStudentNumber().equals(studentNumber)){
//                interests[index] = head.getInterestId();
//                index++;
//            }
//        }
//        return interests;

//    }

    public String[] findByStudentInterestId(String interestId){

        String studentNumber[] = new String[50];

        int index = 0;

        if (head.getInterestId()==interestId){
            studentNumber[index] = head.getStudentNumber();
            index++;
        }

        StudentAndInterestBean curStudentAndInterestBean = head.next;

        while(curStudentAndInterestBean != null){
            if (curStudentAndInterestBean.getInterestId()==interestId){
                studentNumber[index] = head.getStudentNumber();
                index++;
            }
        }
        return studentNumber;

    }

    public boolean setStudentInterestId(int index,String studentInterestId){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setInterestId(studentInterestId);
            return true;
        }

        int i = 2;

        StudentAndInterestBean curStudentAndInterestBean = head.next;

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

    public boolean deleteStudentBean(int index) {

        if (index<1||index>length()) {
            return false;
        }
        if (index==1) {
            head=head.next;
            return true;
        }
        int i=1;
        StudentAndInterestBean preNode=head;
        StudentAndInterestBean curNode=head.next;
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
        StudentAndInterestBean temp = head;
        while (temp!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }

}
