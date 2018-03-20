package com.gongyunhao.sims.Utils;

import android.content.Context;

import com.gongyunhao.sims.Bean.InterestBean;
import com.gongyunhao.sims.Bean.StudentBean;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.List;

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
public class FileHelper {
    private String STUDENT_DATA="studentData";//学生信息存储文件夹名
    private String INTEREST_DATA_STUDENT="interestforstudent";//与学生对应的兴趣信息文件名
    private String INTEREST_DATA="interestData";//存放兴趣大类的文件名

    public List<StudentBean> readStudentData() {
        return null;
    }

    public void saveStudentDataToFile(Context context,List<StudentBean> mlist){
        //save to File
        FileOutputStream outputStream=null;
        BufferedWriter writer=null;
        try {
            outputStream=context.openFileOutput( STUDENT_DATA, Context.MODE_PRIVATE );
            writer=new BufferedWriter( new OutputStreamWriter( outputStream ) );
            String studentdata =parseStudentBean( mlist );
            writer.write( studentdata );
        } catch (IOException e) {
            e.printStackTrace( );
        }
    }

    private String parseStudentBean(List<StudentBean> studentBeanList){
//        name;
//        sex;
//        grade;
//        IDnumber;
//        major;
        String datamydata =null;
        for (int i=0;i<studentBeanList.size();i++){
            StudentBean msbean=studentBeanList.get( i );
            if (i==0){
                datamydata="[";
            }
            if (i<studentBeanList.size()){
                //json格式存储
                datamydata=datamydata+"{"+"\"name\":\""+msbean.getName()+"\",\"sex\":\""+
                        msbean.getSex()+"\",\"grade\":\""+msbean.getGrade()+"\",\"IDnumber\":\""+
                        msbean.getIDnumber()+"\",\"major\":\""+msbean.getMajor()+"\"}";
            }

            if (i==studentBeanList.size()-1){
                datamydata+="]";
            }

            if (i<studentBeanList.size()-1){
                datamydata+=",";
            }
        }
        return datamydata;
    }

    public List<InterestBean> readInterestData(){
        return null;
    }

    public void addInterestDataToFile(){

    }

    public void addAllInterestDataToFile(){

    }

}
