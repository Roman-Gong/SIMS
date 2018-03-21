package com.gongyunhao.sims.Utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.gongyunhao.sims.Bean.InterestCategoryAndHisIdBean;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;
import com.gongyunhao.sims.Bean.StudentBean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
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
                String str = line + "\r\n";//手动换行，便于下面的分割。
                content.append( str );
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
        if (studentdatastr.length()<3){
            TextUtils.isEmpty( studentdatastr );
            return null;
        }
        Log.d( "readstudent--------->",studentdatastr );
        String[] studentdatadetail=studentdatastr.split( "\n" );
        List<StudentBean> studentBeans=new ArrayList<>(  );
        for (int j=0;j<studentdatadetail.length;j++){
            String[] detailitem=studentdatadetail[j].split( " " );
            studentBeans.add( new StudentBean( detailitem[0],Integer.parseInt( detailitem[1] ),detailitem[2],detailitem[3],detailitem[4] ) );
        }
        return studentBeans;
    }

    public List<StudentAndInterestBean> readStudentAInterestData(Context context){
        FileInputStream inputStream=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder(  );
        try {
            inputStream=context.openFileInput( LIKE_DATA );
            reader=new BufferedReader( new InputStreamReader( inputStream ) );
            String line="";
            while ((line=reader.readLine())!=null){
                String str = line + "\r\n";//手动换行，便于下面的分割。
                content.append( str );
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
        if (studentdatastr.length()<3){
            TextUtils.isEmpty( studentdatastr );
            return null;
        }
        Log.d( "readSAI--------->",studentdatastr );
        String[] studentdatadetail=studentdatastr.split( "\n" );
        List<StudentAndInterestBean> studentaInterestBeans=new ArrayList<>(  );
        for (int j=0;j<studentdatadetail.length;j++){
            String[] detailitem=studentdatadetail[j].split( " " );
            studentaInterestBeans.add( new StudentAndInterestBean(detailitem[0], detailitem[1] ) );
        }
        return studentaInterestBeans;
    }

    public List<InterestIdAndInterestNameAndInterestCategoryIdBean> readIIAINAICData(Context context){
        FileInputStream inputStream=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder(  );
        try {
            inputStream=context.openFileInput( BELONG_DATA );
            reader=new BufferedReader( new InputStreamReader( inputStream ) );
            String line="";
            while ((line=reader.readLine())!=null){
                String str = line + "\r\n";//手动换行，便于下面的分割。
                content.append( str );
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
        if (studentdatastr.length()<3){
            TextUtils.isEmpty( studentdatastr );
            return null;
        }
        Log.d( "readIIAINAIC--------->",studentdatastr );
        String[] studentdatadetail=studentdatastr.split( "\n" );
        List<InterestIdAndInterestNameAndInterestCategoryIdBean> studentaInterestBeans=new ArrayList<>(  );
        for (int j=0;j<studentdatadetail.length;j++){
            String[] detailitem=studentdatadetail[j].split( " " );

            studentaInterestBeans.add( new InterestIdAndInterestNameAndInterestCategoryIdBean( detailitem[0]  , detailitem[1] ,  detailitem[2] ) );
        }
        return studentaInterestBeans;
    }

    public List<InterestCategoryAndHisIdBean> readCategoryAndHisIdData(Context context){
        FileInputStream inputStream=null;
        BufferedReader reader=null;
        StringBuilder content=new StringBuilder(  );
        try {
            inputStream=context.openFileInput( CATEGORY_DATA );
            reader=new BufferedReader( new InputStreamReader( inputStream ) );
            String line="";
            while ((line=reader.readLine())!=null){
                String str = line + "\r\n";//手动换行，便于下面的分割。
                content.append( str );
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
        if (studentdatastr.length()<3){
            TextUtils.isEmpty( studentdatastr );
            return null;
        }
        Log.d( "readIIAINAIC--------->",studentdatastr );
        String[] studentdatadetail=studentdatastr.split( "\n" );
        List<InterestCategoryAndHisIdBean> studentaInterestBeans=new ArrayList<>(  );
        for (int j=0;j<studentdatadetail.length;j++){
            String[] detailitem=studentdatadetail[j].split( " " );
            studentaInterestBeans.add( new InterestCategoryAndHisIdBean(detailitem[0] ,detailitem[1]) );
        }
        return studentaInterestBeans;
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
            outputStream=context.openFileOutput( STUDENT_DATA, Context.MODE_PRIVATE );//覆盖模式
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

    /**
     * 存储学生和兴趣信息完成。
     * @param context
     * @param sailist
     */
    //存储格式如下：
    //201613137110 1
    //201613137111 3
    //201613137111 4
    public void saveStudentAndInterestToFile(Context context, List<StudentAndInterestBean> sailist){
        //save to File
        FileOutputStream outputStream=null;
        BufferedWriter writer=null;
        try {
            outputStream=context.openFileOutput( LIKE_DATA, Context.MODE_PRIVATE );//覆盖模式
            writer=new BufferedWriter( new OutputStreamWriter( outputStream ) );
            String studentdata =parseStudentAndInterestToSave( sailist );
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

    /**
     * 存储兴趣id，兴趣名称，兴趣类别完成。
     * @param context
     * @param iainaicblist
     */
    //存储格式如下：
    //1 足球 1
    //2 篮球 1
    //3 围棋 2
    public void saveIISINSICIB(Context context, List<InterestIdAndInterestNameAndInterestCategoryIdBean> iainaicblist){
        //save to File
        FileOutputStream outputStream=null;
        BufferedWriter writer=null;
        try {
            outputStream=context.openFileOutput( BELONG_DATA, Context.MODE_PRIVATE );//覆盖模式
            writer=new BufferedWriter( new OutputStreamWriter( outputStream ) );
            String studentdata =parseIISINSICIBBeanToSave( iainaicblist );
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

    /**
     * 存储兴趣id和兴趣名称完成。
     * @param context
     * @param interestCategoryAndHisIdBeanList
     */
    //存储格式如下：
    //1 球类
    //2 棋类
    public void saveInterestCategoryHisIdToFile(Context context, List<InterestCategoryAndHisIdBean> interestCategoryAndHisIdBeanList){
        //save to File
        FileOutputStream outputStream=null;
        BufferedWriter writer=null;
        try {
            outputStream=context.openFileOutput( CATEGORY_DATA, Context.MODE_PRIVATE );//覆盖模式
            writer=new BufferedWriter( new OutputStreamWriter( outputStream ) );
            String studentdata =parseICAHI( interestCategoryAndHisIdBeanList );
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

    private String parseICAHI(List<InterestCategoryAndHisIdBean> iCAHIdBList){

//        interestCategoryName;
//        interestCategoryId;

        String datamydata ="";
        for (int i=0;i<iCAHIdBList.size();i++){
            InterestCategoryAndHisIdBean saiBean=iCAHIdBList.get( i );
            if (i<iCAHIdBList.size()-1){
                datamydata=datamydata+saiBean.getInterestCategoryId()+" "+ saiBean.getInterestCategoryName()+" "+saiBean.getInterestCategoryId()+"\n";
            }else {
                datamydata=datamydata+saiBean.getInterestCategoryId()+" "+ saiBean.getInterestCategoryName()+" "+saiBean.getInterestCategoryId();
            }
        }

        Log.d( "saveICAHI------>",datamydata );
        return datamydata;
    }

    private String parseIISINSICIBBeanToSave(List<InterestIdAndInterestNameAndInterestCategoryIdBean> miainaicblist){

//        interestId;
//        interestName;
//        interestCategoryId;

        String datamydata ="";
        for (int i=0;i<miainaicblist.size();i++){
            InterestIdAndInterestNameAndInterestCategoryIdBean saiBean=miainaicblist.get( i );
            if (i<miainaicblist.size()-1){
                datamydata=datamydata+saiBean.getInterestId()+" "+ saiBean.getInterestName()+" "+saiBean.getInterestCategoryId()+"\n";
            }else {
                datamydata=datamydata+saiBean.getInterestId()+" "+ saiBean.getInterestName()+" "+saiBean.getInterestCategoryId();
            }
        }

        Log.d( "saveIISINSICIB------>",datamydata );
        return datamydata;
    }

    private String parseStudentAndInterestToSave(List<StudentAndInterestBean> studentAndInterestBeanList){
//        studentNumber;
//        interestId;
        String datamydata ="";
        for (int i=0;i<studentAndInterestBeanList.size();i++){
            StudentAndInterestBean saiBean=studentAndInterestBeanList.get( i );
            if (i<studentAndInterestBeanList.size()-1){
                datamydata=datamydata+saiBean.getStudentNumber()+" "+ saiBean.getInterestId()+"\n";
            }else {
                datamydata=datamydata+saiBean.getStudentNumber()+saiBean.getInterestId();
            }
        }

        Log.d( "saveSAI---------->",datamydata );
        return datamydata;
    }

    private String parseStudentBeanToSave(List<StudentBean> studentBeanList){
//        name;
//        sex;
//        grade;
//        IDnumber;
//        major;
        String datamydata ="";
        for (int i=0;i<studentBeanList.size();i++){
            StudentBean studentBean=studentBeanList.get( i );
            if (i<studentBeanList.size()-1){
                datamydata=datamydata+studentBean.getStudentName()+" "+studentBean.getStudentSex()+" "+
                        studentBean.getStudentGrade()+" "+studentBean.getStudentNumber()+" "+
                        studentBean.getStudentMajor()+"\n";
            }else {
                datamydata=datamydata+studentBean.getStudentName()+" "+studentBean.getStudentSex()+" "+
                        studentBean.getStudentGrade()+" "+studentBean.getStudentNumber()+" "+studentBean.getStudentMajor();
            }
        }
//        //json格式存储
//        datamydata=datamydata+"{"+"\"name\":\""+msbean.getName()+"\",\"sex\":\""+
//                msbean.getSex()+"\",\"grade\":\""+msbean.getGrade()+"\",\"IDnumber\":\""+
//                msbean.getIDnumber()+"\",\"major\":\""+msbean.getMajor()+"\"}";

        Log.d( "savestudent---------->",datamydata );
        return datamydata;
    }

}
