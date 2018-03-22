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
import android.widget.ImageView;

import com.gongyunhao.sims.Adapter.StudentDataAdapter;
import com.gongyunhao.sims.AddStudentActivity;
import com.gongyunhao.sims.ArrayList.InterestIdAndInterestNameAndInterestCategoryIdBeanList;
import com.gongyunhao.sims.ArrayList.StudentAndInterestBeanList;
import com.gongyunhao.sims.ArrayList.StudentBeanList;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;
import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{

    private Button deletestudent,searchstudent,modifystudent;
    private Button deleteinterest,modifyinterest;

    private FloatingActionButton addstudent,addinterest;
    private List<StudentBean> mStudentList;
    private ImageView imageViewSearch;
    private RecyclerView mStudentRecycler;
    private StudentBeanList studentBeanList;
    private StudentAndInterestBeanList studentAndInterestBeanList;
    private InterestIdAndInterestNameAndInterestCategoryIdBeanList interestIdAndInterestNameAndInterestCategoryIdBeanList;
    private StudentDataAdapter studentDataAdapter;
    private boolean isSearching;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( );
        initViews();
        initListeners();
        mStudentList = new ArrayList<>();
        studentBeanList = new StudentBeanList();
        studentAndInterestBeanList = new StudentAndInterestBeanList();
        interestIdAndInterestNameAndInterestCategoryIdBeanList = new InterestIdAndInterestNameAndInterestCategoryIdBeanList();
        FileHelper fileHelper = new FileHelper();
        if (fileHelper.readStudentAInterestData(MainActivity.this)!=null){
            List<StudentAndInterestBean> tempStudentAndInterestList = fileHelper.readStudentAInterestData(MainActivity.this);
            for (int i=0;i<tempStudentAndInterestList.size();i++){
                studentAndInterestBeanList.addStudentAndInterestBean(tempStudentAndInterestList.get(i).getStudentNumber(),tempStudentAndInterestList.get(i).getInterestId());
            }
        }

        if (fileHelper.readIIAINAICData(MainActivity.this)!=null){
            List<InterestIdAndInterestNameAndInterestCategoryIdBean> interestIdAndInterestNameAndInterestCategoryIdBeans = fileHelper.readIIAINAICData(MainActivity.this);
            for (int i=0;i<interestIdAndInterestNameAndInterestCategoryIdBeans.size();i++){
                interestIdAndInterestNameAndInterestCategoryIdBeanList.addInterestIdAndInterestNameAndInterestCategoryIdBean(interestIdAndInterestNameAndInterestCategoryIdBeans.get(i).getInterestId(),interestIdAndInterestNameAndInterestCategoryIdBeans.get(i).getInterestName(),interestIdAndInterestNameAndInterestCategoryIdBeans.get(i).getInterestCategoryId());
            }
        }

        imageViewSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,SearchActivity.class);
                startActivity(intent);

            }
        });


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
                startIntent( AddInterestActivity.class );
                break;
            case R.id.btn_delete_interest:
                break;
            case R.id.btn_modify_interest:
                break;
            default:
                break;
        }
    }

    @Override
    public void initViews() {
        imageViewSearch = findViewById(R.id.search);
        addstudent = findViewById( R.id.btn_add_student );
        addinterest = findViewById( R.id.btn_add_interest );
        deleteinterest = findViewById( R.id.btn_delete_interest );
        modifyinterest = findViewById( R.id.btn_modify_interest );
        mStudentRecycler = findViewById(R.id.recycler_student_data);
        mStudentRecycler.setLayoutManager( new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL) );
    }

    @Override
    public void initListeners() {
        addstudent.setOnClickListener( this );
        addinterest.setOnClickListener( this );
        deleteinterest.setOnClickListener( this );
        modifyinterest.setOnClickListener( this );
    }

    @Override
    public void initData() {

    }




}
