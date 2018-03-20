package com.gongyunhao.sims.Utils;

import android.content.Context;
import android.util.Log;

import com.gongyunhao.sims.Bean.StudentBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
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
    private String LIKE_DATA="likeData";//学号对应的喜欢的情趣项的文件名
    private String BELONG_DATA="belongData";//存放兴趣编号和属于哪一个兴趣大类的文件名
    private String CATEGORY_DATA="categoryData";//存放兴趣大类的文件名


    /**
     * 读取学生信息完成。直接读出来成List。
     * @param context
     * @return
     */
    public List<StudentBean> readStudentData(Context context) {
        FileInputStream inputStream=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder(  );
        try {
            inputStream=context.openFileInput( STUDENT_DATA );
            reader=new BufferedReader( new InputStreamReader( inputStream ) );
            String line="";
            while ((line=reader.readLine())!=null){
                content.append( line );
            }
        } catch (IOException e) {
            e.printStackTrace( );
        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace( );
                }
            }
        }
        //此处content已经被还原成存储时的String格式,然后可以进行分割存入List中。
        String studentdatastr=content.toString();
        String[] studentdatadetail=studentdatastr.split( "\n" );
        List<StudentBean> studentBeans=new ArrayList<>(  );
        for (int j=0;j<studentdatadetail.length;j++){
            String[] detailitem=studentdatadetail[j].split( " " );
            studentBeans.add( new StudentBean( detailitem[0],Integer.parseInt( detailitem[1] ),detailitem[2],detailitem[3],detailitem[4] ) );
        }
        return studentBeans;
    }

    /**
     * 存储学生信息完成。
     * 每一项用空格分割。每一行用\n分割。
     * @param context
     * @param mlist
     */
    //存储格式如下：
    //张三 男 大二 201613137123 计科
    //李四 男 大一 201713137123 网络
    public void saveStudentDataToFile(Context context,List<StudentBean> mlist){
        //save to File
        FileOutputStream outputStream=null;
        BufferedWriter writer=null;
        try {
            outputStream=context.openFileOutput( STUDENT_DATA, Context.MODE_PRIVATE );
            writer=new BufferedWriter( new OutputStreamWriter( outputStream ) );
            String studentdata =parseStudentBeanToSave( mlist );
            writer.write( studentdata );
        } catch (IOException e) {
            e.printStackTrace( );
        } finally {
            try{
                if (writer!=null){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private String parseStudentBeanToSave(List<StudentBean> studentBeanList){
//        name;
//        sex;
//        grade;
//        IDnumber;
//        major;
        String datamydata =null;
        for (int i=0;i<studentBeanList.size();i++){
            StudentBean studentBean=studentBeanList.get( i );
            if (i<studentBeanList.size()-1){
                datamydata=datamydata+studentBean.getName()+" "+studentBean.getSex()+" "+
                        studentBean.getGrade()+" "+studentBean.getIDnumber()+" "+
                        studentBean.getMajor()+"\n";
            }else {
                datamydata=datamydata+studentBean.getName()+" "+studentBean.getSex()+" "+
                        studentBean.getGrade()+" "+studentBean.getIDnumber()+" "+studentBean.getMajor();
            }
        }
//        //json格式存储
//        datamydata=datamydata+"{"+"\"name\":\""+msbean.getName()+"\",\"sex\":\""+
//                msbean.getSex()+"\",\"grade\":\""+msbean.getGrade()+"\",\"IDnumber\":\""+
//                msbean.getIDnumber()+"\",\"major\":\""+msbean.getMajor()+"\"}";

        Log.d( "studentdata---------->",datamydata );
        return datamydata;
    }

}
