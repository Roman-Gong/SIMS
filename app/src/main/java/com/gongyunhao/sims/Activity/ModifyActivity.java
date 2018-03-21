package com.gongyunhao.sims.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gongyunhao.sims.AddStudentActivity;
import com.gongyunhao.sims.Bean.InterestCategoryAndHisIdBean;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;
import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private int position;
    private Spinner mspinner;
    private EditText name,number,major,grade;
    private boolean isboy,isselectedsex=false;
    private RadioGroup radioGroup;
    private Button btn_yes;
    private String sname,snumber,smajor,sgrade;
    private StudentBean studentBean;
    //定义一个String类型的List数组作为数据源
    private List<String> dataList;
    //定义一个ArrayAdapter适配器作为spinner的数据适配器
    private ArrayAdapter<String> adapter;
    private List<StudentBean> mStudentList=new ArrayList<>(  );
    private List<StudentAndInterestBean> studentAndInterestBeans=new ArrayList<>(  );
    private List<InterestCategoryAndHisIdBean> interestCategoryAndHisIdBeans=new ArrayList<>(  );
    private List<InterestIdAndInterestNameAndInterestCategoryIdBean> interestIdAndInterestNameAndInterestCategoryIdBeans=new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_modify );
        position=getIntent().getIntExtra( "position",-1 );
        name=findViewById( R.id.et_modify_student );
        number=findViewById( R.id.et_modify_number );
        major=findViewById( R.id.et_modify_major );
        grade=findViewById( R.id.et_modify_grade );
        radioGroup=findViewById( R.id.radio_modify_sex );
        btn_yes=findViewById( R.id.btn_modify_yes);
        mspinner=findViewById( R.id.spinner_modify_interest );
        btn_yes.setOnClickListener( this );
        radioGroup.setOnCheckedChangeListener( this );

        FileHelper mfileHelper=new FileHelper();
        if (mfileHelper.readStudentData( ModifyActivity.this )!=null){
            mStudentList.addAll( mfileHelper.readStudentData( ModifyActivity.this ) );
            studentBean=mStudentList.get( position );
        }
        if (mfileHelper.readIIAINAICData( ModifyActivity.this )!=null){
            interestIdAndInterestNameAndInterestCategoryIdBeans.addAll( mfileHelper.readIIAINAICData( ModifyActivity.this ) );
        }
        if (mfileHelper.readCategoryAndHisIdData( ModifyActivity.this )!=null){
            interestCategoryAndHisIdBeans.addAll( mfileHelper.readCategoryAndHisIdData( ModifyActivity.this ));
        }
        if (mfileHelper.readStudentAInterestData( ModifyActivity.this )!=null){
            studentAndInterestBeans.addAll( mfileHelper.readStudentAInterestData( ModifyActivity.this ) );
        }

        name.setText( studentBean.getStudentName() );
        number.setText( studentBean.getStudentNumber() );
        major.setText( studentBean.getStudentMajor() );
        grade.setText( studentBean.getStudentGrade() );
        if (studentBean.getStudentSex()==1){
            isboy=true;
            isselectedsex=true;
        }else {
            isboy=false;
        }
        //为dataList赋值，将下面这些数据添加到数据源中
        dataList = new ArrayList<String>();
        for (int i=0;i<interestCategoryAndHisIdBeans.size();i++){
            dataList.add(interestCategoryAndHisIdBeans.get( i ).getInterestCategoryName());
        }

        /*为spinner定义适配器，也就是将数据源存入adapter，这里需要三个参数
        1. 第一个是Context（当前上下文），这里就是this
        2. 第二个是spinner的布局样式，这里用android系统提供的一个样式
        3. 第三个就是spinner的数据源，这里就是dataList*/
        adapter = new ArrayAdapter<String>(ModifyActivity.this,android.R.layout.simple_spinner_item,dataList);

        //为适配器设置下拉列表下拉时的菜单样式。
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        //为spinner绑定我们定义好的数据适配器
        mspinner.setAdapter(adapter);
        //为spinner绑定监听器，这里我们使用匿名内部类的方式实现监听器
        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                textView.setText("您当前选择的是："+adapter.getItem(position));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                textView.setText("请选择兴趣类别");
            }
        });

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

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_modify_yes:
                sname=name.getText().toString();
                snumber=number.getText().toString();
                smajor=major.getText().toString();
                sgrade=grade.getText().toString();
                if (sname!=null&&snumber!=null&&smajor!=null&&sgrade!=null&&isselectedsex!=false){
                    mStudentList.add( new StudentBean( sname,isboy?1:0,sgrade,snumber,smajor ) );
                    //save to File
                    FileHelper fileHelper=new FileHelper();
                    fileHelper.saveStudentDataToFile( ModifyActivity.this,mStudentList );



                    Toast.makeText( ModifyActivity.this,"修改成功!",Toast.LENGTH_SHORT ).show();
                    finish();
                }else {
                    Toast.makeText( ModifyActivity.this,"请填写完整信息",Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }

}
