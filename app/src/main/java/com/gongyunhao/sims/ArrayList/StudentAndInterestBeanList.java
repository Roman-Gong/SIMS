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

    public void addStudentAndInterestBean (String studentNumber,int interestId){

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

}
