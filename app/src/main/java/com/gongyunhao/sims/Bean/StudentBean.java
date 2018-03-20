package com.gongyunhao.sims.Bean;

//    ┏┓　   ┏┓  
// ┏━━┛┻━━━━━┛┻ ┓ 
// ┃　　　　　　 ┃  
// ┃　　　━　    ┃  
// ┃　＞　　＜　 ┃  
// ┃　　　　　　 ┃  
// ┃... ⌒ ...  ┃  
// ┃　　　　　 　┃  
// ┗━━━┓　　　┏━┛  
//     ┃　　　┃　  
//     ┃　　　┃  
//     ┃　　　┃  神兽保佑  
//     ┃　　　┃  代码无bug　　  
//     ┃　　　┃  
//     ┃　　　┗━━━━━━━━━┓
//     ┃　　　　　　　    ┣┓
//     ┃　　　　         ┏┛
//     ┗━┓ ┓ ┏━━━┳ ┓ ┏━┛
//       ┃ ┫ ┫   ┃ ┫ ┫
//       ┗━┻━┛   ┗━┻━┛
//
//  作者：棒棒小糖
//  來源：简书
//
//  Creste by GongYunHao on 2018/3/19
// 
public class StudentBean {

    public StudentBean next = null;

    private String studentName;           //姓名
    private int studentSex;               //性别,0表示女,1表示男
    private String studentGrade;          //年级
    private String studentNumber;       //学号
    private String studentMajor;          //专业

    public StudentBean(String studentName, int studentSex, String studentGrade, String studentNumber, String studentMajor) {
        this.studentName = studentNumber;
        this.studentSex = studentSex;
        this.studentGrade = studentGrade;
        this.studentNumber = studentNumber;
        this.studentMajor = studentMajor;
    }

    public String getStudentName() {

        return studentName;
    }

    public void setStudentName(String name) {
        this.studentName = name;
    }

    public int getStudentSex() {
        return studentSex;
    }

    public void setStudentSex(int sex) {
        this.studentSex = sex;
    }

    public String getStudentGrade() {
        return studentGrade;
    }

    public void setStudentGrade(String grade) {
        this.studentGrade = grade;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String IDnumber) {
        this.studentNumber = IDnumber;
    }

    public String getStudentMajor() {
        return studentMajor;
    }

    public void setStudentMajor(String major) {
        this.studentMajor = major;
    }
}
