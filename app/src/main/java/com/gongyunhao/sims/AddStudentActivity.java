package com.gongyunhao.sims;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class AddStudentActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private EditText name,number,major,grade;
    private boolean isboy,isselectedsex=false;
    private RadioGroup radioGroup;
    private Button btn_yes;
    private String sname,snumber,smajor,sgrade;
    private List<StudentBean> mStudentList=new ArrayList<>(  );

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
        FileHelper mfileHelper=new FileHelper();
        if (mfileHelper.readStudentData( AddStudentActivity.this )!=null){
            mStudentList.addAll( mfileHelper.readStudentData( AddStudentActivity.this ) );
        }

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
                    mStudentList.add( new StudentBean( sname,isboy?1:0,sgrade,snumber,smajor ) );
                    //save to File
                    FileHelper fileHelper=new FileHelper();
                    fileHelper.saveStudentDataToFile( AddStudentActivity.this,mStudentList );
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
