package com.gongyunhao.sims.Activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.gongyunhao.sims.R;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private Button addstudent,deletestudent,searchstudent,modifystudent;
    private Button addinterest,deleteinterest,modifyinterest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( );
        initViews();
        initListeners();

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
