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

}
