package com.gongyunhao.sims.Activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gongyunhao.sims.R;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private EditText name,number,major,grade;
    private boolean isboy,isselectedsex=false;
    private RadioGroup radioGroup;
    private Button btn_yes;
    private String sname,snumber,smajor,sgrade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_student );
        name=findViewById( R.id.et_add_student );
        number=findViewById( R.id.et_add_number );
        major=findViewById( R.id.et_add_major );
        grade=findViewById( R.id.et_add_grade );
        radioGroup=findViewById( R.id.radio_add_sex );
        btn_yes=findViewById( R.id.btn_add_yes );
        btn_yes.setOnClickListener( this );
        radioGroup.setOnCheckedChangeListener( this );
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_add_yes:
                sname=name.getText().toString();
                snumber=number.getText().toString();
                smajor=major.getText().toString();
                sgrade=grade.getText().toString();
                if (sname!=null&&snumber!=null&&smajor!=null&&sgrade!=null&&isselectedsex!=false){
                    //save to File
                    FileOutputStream outputStream=null;
                    BufferedWriter writer=null;
                    try {
                        outputStream=openFileOutput( "studentData", Context.MODE_PRIVATE );
                    } catch (FileNotFoundException e) {
                        e.printStackTrace( );
                    }
                }else {
                    Toast.makeText( AddStudentActivity.this,"请填写完整信息",Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }


    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radio_boy:
                isboy=true;
                isselectedsex=true;
                break;
            case R.id.radio_girl:
                isboy=false;
                isselectedsex=true;
                break;
            default:
                break;
        }
    }
}
