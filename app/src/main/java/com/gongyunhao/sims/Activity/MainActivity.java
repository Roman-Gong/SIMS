package com.gongyunhao.sims.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.gongyunhao.sims.AddStudentActivity;
import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button addstudent,deletestudent,searchstudent,modifystudent;
    private Button addinterest,deleteinterest,modifyinterest;
    private List<StudentBean> mStudentList=new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( );
        initViews();
        initListeners();

    }

    @Override
    protected void onStart() {
        super.onStart( );
        FileHelper mfileHelper=new FileHelper();
        if (mfileHelper.readStudentData( MainActivity.this )!=null){
            mStudentList.clear();//如果不clear掉，每次返回都会addAll一次，导致list长度翻倍。
            mStudentList.addAll( mfileHelper.readStudentData( MainActivity.this ) );
        }
    }

    @Override
    public void setContentView() {
        setContentView( R.layout.activity_main );
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_add_student:
                startIntent( AddStudentActivity.class );
                break;
            case R.id.btn_add_interest:
                break;
            case R.id.btn_delete_student:
                if (mStudentList.size()<1){
                    showToast( "list长度为0，再删就到-1，越界了" );
                }else {
                    mStudentList.remove( mStudentList.size()-1 );
                    FileHelper fileHelper=new FileHelper();
                    fileHelper.saveStudentDataToFile( MainActivity.this,mStudentList );
                    showToast( "删除最后一个学生成功" );
                }
                break;
            case R.id.btn_delete_interest:
                break;
            case R.id.btn_modify_student:
                break;
            case R.id.btn_modify_interest:
                break;
            case R.id.btn_search_student:
                break;
            default:
                break;
        }
    }
    @Override
    public void initViews() {
        addstudent=findViewById( R.id.btn_add_student );
        addinterest=findViewById( R.id.btn_add_interest );
        deletestudent=findViewById( R.id.btn_delete_student );
        deleteinterest=findViewById( R.id.btn_delete_interest );
        modifystudent=findViewById( R.id.btn_modify_student );
        modifyinterest=findViewById( R.id.btn_modify_interest );
        searchstudent=findViewById( R.id.btn_search_student );
    }
    @Override
    public void initListeners() {
        addstudent.setOnClickListener( this );
        addinterest.setOnClickListener( this );
        deletestudent.setOnClickListener( this );
        deleteinterest.setOnClickListener( this );
        modifystudent.setOnClickListener( this );
        modifyinterest.setOnClickListener( this );
        searchstudent.setOnClickListener( this );
    }
    @Override
    public void initData() {

    }
}
