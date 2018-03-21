package com.gongyunhao.sims.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Button;

import com.gongyunhao.sims.Adapter.StudentDataAdapter;
import com.gongyunhao.sims.AddStudentActivity;
import com.gongyunhao.sims.ArrayList.InterestIdAndInterestNameAndInterestCategoryIdBeanList;
import com.gongyunhao.sims.ArrayList.StudentAndInterestBeanList;
import com.gongyunhao.sims.ArrayList.StudentBeanList;
import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button deletestudent,searchstudent,modifystudent;
    private Button addinterest,deleteinterest,modifyinterest;
    private FloatingActionButton addstudent;
    private List<StudentBean> mStudentList=new ArrayList<>(  );
    private RecyclerView mStudentRecycler;
    private StudentDataAdapter studentDataAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( );
        initViews();
        initListeners();
        studentDataAdapter = new StudentDataAdapter(MainActivity.this,mStudentList);
        mStudentRecycler.setAdapter(studentDataAdapter);
        studentDataAdapter.setmOnItemClickListener( new StudentDataAdapter.OnItemClickListener( ) {
            @Override
            public void onItemClick(View view, int position) {
                Intent intent=new Intent( MainActivity.this,ModifyActivity.class );
                intent.putExtra( "position",position );
                startActivity( intent );
            }

            @Override
            public void onItemLongClick(View view,int position) {
                final int mposition=position;
                AlertDialog.Builder dialog=new AlertDialog.Builder( MainActivity.this );
                dialog.setTitle( "提示" );
                dialog.setMessage( "确定要删除该学生？" );
                dialog.setCancelable( false );
                dialog.setPositiveButton( "确定", new DialogInterface.OnClickListener( ) {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        mStudentList.remove( mposition );
                        FileHelper fileHelper=new FileHelper();
                        fileHelper.saveStudentDataToFile( MainActivity.this,mStudentList );
                        showToast( "删除第"+mposition+"个学生成功" );
                        studentDataAdapter.notifyDataSetChanged();
                    }
                } );
                dialog.setNegativeButton( "取消", new DialogInterface.OnClickListener( ) {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                } );
                dialog.show();

            }
        } );
    }

    @Override
    protected void onResume() {
        super.onResume();
        FileHelper mfileHelper=new FileHelper();
        if (mfileHelper.readStudentData( MainActivity.this )!=null){
            mStudentList.clear();//如果不clear掉，每次返回都会addAll一次，导致list长度翻倍。
            mStudentList.addAll( mfileHelper.readStudentData( MainActivity.this ) );

            studentDataAdapter.notifyDataSetChanged();

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
        mStudentRecycler = findViewById(R.id.recycler_student_data);
        mStudentRecycler.setLayoutManager( new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) );
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

    public void searchByStudentName(String studentName){

        StudentBeanList studentBeanList = new StudentBeanList();
        int tempIndex = studentBeanList.findStudentBeanListByStudentName(studentName);
        StudentBean studentBean = studentBeanList.getStudentBean(tempIndex);


    }

    public void searchByStudentNumber(String studentNumber){

        StudentBeanList studentBeanList = new StudentBeanList();
        int tempIndex = studentBeanList.findStudentBeanListByStudentNumber(studentNumber);
        StudentBean studentBean = studentBeanList.getStudentBean(tempIndex);

    }

    public void searchByInterestName(String interestName){

        StudentBeanList studentBeanList = new StudentBeanList();
        StudentAndInterestBeanList studentAndInterestBeanList = new StudentAndInterestBeanList();
        InterestIdAndInterestNameAndInterestCategoryIdBeanList interestIdAndInterestNameAndInterestCategoryIdBeanList = new InterestIdAndInterestNameAndInterestCategoryIdBeanList();
        int tempInterestId = interestIdAndInterestNameAndInterestCategoryIdBeanList.getInterestId(interestName);
        String []tempStudentNumbers = studentAndInterestBeanList.findByStudentInterestId(tempInterestId);
        for (int i=0;i<tempStudentNumbers.length;i++){

            int tempIndex = studentBeanList.findStudentBeanListByStudentNumber(tempStudentNumbers[i]);
            StudentBean studentBean = studentBeanList.getStudentBean(tempIndex);

        }

    }
}
