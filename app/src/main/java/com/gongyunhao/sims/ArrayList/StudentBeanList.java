package com.gongyunhao.sims.ArrayList;

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

public class StudentBeanList {

    StudentBean head = null;

    public void addStudentBean(String name, int sex, String grade, String IDnumber, String major){
        StudentBean studentBean = new StudentBean(name, sex, grade, IDnumber, major);

        if (head == null) {
            head = studentBean;
            return;
        }

        StudentBean temp = head;

        while(temp.next!=null) {
            temp=temp.next;
        }
        temp.next = studentBean;

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
        StudentBean preNode=head;
        StudentBean curNode=head.next;
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

    public StudentBean getStudentBean(int index){

        if (index<1||index>length()){
            return null;
        }
        if (index==1){
            return head;
        }
        int i=2;
        StudentBean curStudentBean = head.next;
        while(curStudentBean!=null){

            if (i==index){
                return curStudentBean;
            }

            curStudentBean = curStudentBean.next;
            i++;

        }
        return null;

    }

    public int findStudentBeanListByStudentName(String studentName){

        int index = 2;

        if (head.getStudentName().equals(studentName)){

            return 1;

        }

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (curStudentBean.getStudentName().equals(studentName)){
                return index;
            }

            curStudentBean = curStudentBean.next;

            index++;

        }
        return 0;

    }

    public boolean setStudentName(int index,String studentName){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setStudentName(studentName);
            return true;
        }

        int i = 2;

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (i==index){
                curStudentBean.setStudentName(studentName);
                return true;
            }
            curStudentBean = curStudentBean.next;
            i++;

        }
        return false;

    }

    public boolean setStudentNumber(int index,String studentNumber){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setStudentNumber(studentNumber);
            return true;
        }

        int i = 2;

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (i==index){
                curStudentBean.setStudentNumber(studentNumber);
                return true;
            }
            curStudentBean = curStudentBean.next;
            i++;

        }
        return false;

    }


    public boolean setStudentGrade(int index,String studentGrade){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setStudentGrade(studentGrade);
            return true;
        }

        int i = 2;

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (i==index){
                curStudentBean.setStudentGrade(studentGrade);
                return true;
            }
            curStudentBean = curStudentBean.next;
            i++;

        }
        return false;

    }

    public boolean setStudentMajor(int index,String studentMajor){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setStudentMajor(studentMajor);
            return true;
        }

        int i = 2;

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (i==index){
                curStudentBean.setStudentMajor(studentMajor);
                return true;
            }
            curStudentBean = curStudentBean.next;
            i++;

        }
        return false;

    }

    public boolean setStudentSex(int index,int studentSex){

        if(index<1||index>length()){
            return false;
        }

        if (index==1){
            head.setStudentSex(studentSex);
            return true;
        }

        int i = 2;

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (i==index){
                curStudentBean.setStudentSex(studentSex);
                return true;
            }
            curStudentBean = curStudentBean.next;
            i++;

        }
        return false;

    }

    public int findStudentBeanListByStudentNumber(String studentNumber){

        int index = 2;

        if (head.getStudentNumber().equals(studentNumber)){

            return 1;

        }

        StudentBean curStudentBean = head.next;

        while(curStudentBean!=null){

            if (curStudentBean.getStudentNumber().equals(studentNumber)){
                return index;
            }

            curStudentBean = curStudentBean.next;

            index++;

        }
        return 0;

    }


    public int length() {
        int length=0;
        StudentBean temp = head;
        while (temp!=null) {
            length++;
            temp=temp.next;
        }
        return length;
    }



}
