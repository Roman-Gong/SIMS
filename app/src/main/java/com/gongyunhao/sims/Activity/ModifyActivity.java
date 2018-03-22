package com.gongyunhao.sims.Activity;

import android.content.Intent;
import android.provider.SearchRecentSuggestions;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.gongyunhao.sims.AddStudentActivity;
import com.gongyunhao.sims.Bean.InterestCategoryAndHisIdBean;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;
import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.FlowLayout;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class ModifyActivity extends AppCompatActivity implements View.OnClickListener,RadioGroup.OnCheckedChangeListener{
    private int position;
    private Spinner mspinner;
    private EditText name,number,major,grade;
    private boolean isboy;
    private FlowLayout mFlowLayout;
    private LayoutInflater mInflater;
    private RadioGroup radioGroup;
    private Button btn_yes;
    private String sname,snumber,smajor,sgrade;
    private RadioButton radio_boy,radio_girl;
    private StudentBean studentBean;
    private RecyclerView recycler_interest_detail_modify;
    //定义一个String类型的List数组作为数据源
    private List<String> dataList,dataList_detail;
    //定义一个ArrayAdapter适配器作为spinner的数据适配器
    private ArrayAdapter<String> adapter,madapter_detail;
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
        radio_boy=findViewById( R.id.radio_boy );
        radio_girl=findViewById( R.id.radio_girl );
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
        }else {
            isboy=false;
        }
        //为dataList赋值，将下面这些数据添加到数据源中
        dataList = new ArrayList<String>();
        for (int i=0;i<interestIdAndInterestNameAndInterestCategoryIdBeans.size();i++){
            dataList.add( interestIdAndInterestNameAndInterestCategoryIdBeans.get( i ).getInterestName() );
        }

        if (isboy){
            radio_boy.setChecked( true );
        }else {
            radio_girl.setChecked( true );
        }

        initFlowView();


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
        mspinner.setSelection( 0,true );
        mspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                textView.setText("您当前选择的是："+adapter.getItem(position));
                studentAndInterestBeans.add( new StudentAndInterestBean( studentBean.getStudentNumber(),interestIdAndInterestNameAndInterestCategoryIdBeans.get( position ).getInterestId() ) );
                final TextView tv = (TextView) mInflater.inflate(
                        R.layout.search_label_tv, mFlowLayout, false);
                tv.setText(interestIdAndInterestNameAndInterestCategoryIdBeans.get( position ).getInterestName());
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        mFlowLayout.removeView( view );
                        studentAndInterestBeans.remove( studentAndInterestBeans.size()-1 );
                    }
                });
                mFlowLayout.addView(tv);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
//                textView.setText("请选择兴趣类别");
            }
        });

    }

    private void initFlowView() {
        mInflater = LayoutInflater.from(this);
        mFlowLayout = (FlowLayout) findViewById(R.id.flowlayout);
        initData();
    }

    private void initData() {
        String mnumber=studentBean.getStudentNumber();
        List<String> mteststr=new ArrayList<>(  );
        for (int i=0;i<studentAndInterestBeans.size();i++){
            if (mnumber.equals( studentAndInterestBeans.get( i ).getStudentNumber() )){
                //找到了该学生所有的喜欢的兴趣的id编号
                mteststr.add( studentAndInterestBeans.get( i ).getInterestId() );
            }
        }

        for (int m=0;m<mteststr.size();m++){
            String test=mteststr.get( m );
            Log.d( "test--->",test );
            for (int k=0;k<interestIdAndInterestNameAndInterestCategoryIdBeans.size();k++){
                String testinterest=interestIdAndInterestNameAndInterestCategoryIdBeans.get( k ).getInterestId();
                Log.d( "testinterest--->",testinterest );

                if (test.trim().equals( testinterest.trim() )){

                    Log.d( "testModify--->",testinterest );
                    final TextView tv = (TextView) mInflater.inflate( R.layout.search_label_tv, mFlowLayout, false);
                    tv.setText(interestIdAndInterestNameAndInterestCategoryIdBeans.get( k ).getInterestName());
                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            mFlowLayout.removeView( view );
                            studentAndInterestBeans.remove( studentAndInterestBeans.size()-1 );
                        }
                    });
                    mFlowLayout.addView(tv);
                }


            }
        }

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (radioGroup.getCheckedRadioButtonId()){
            case R.id.radio_boy:
                isboy=true;
                break;
            case R.id.radio_girl:
                isboy=false;
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
                if (sname!=null&&snumber!=null&&smajor!=null&&sgrade!=null){
                    mStudentList.remove( position );
                    mStudentList.add( new StudentBean( sname,isboy?1:0,sgrade,snumber,smajor ) );
                    //save to File
                    FileHelper fileHelper=new FileHelper();
                    fileHelper.saveStudentDataToFile( ModifyActivity.this,mStudentList );
                    fileHelper.saveStudentAndInterestToFile( ModifyActivity.this,studentAndInterestBeans );

                    Toast.makeText( ModifyActivity.this,"修改成功!",Toast.LENGTH_SHORT ).show();
                    finish();
                }else {
                    Toast.makeText( ModifyActivity.this,"请填写完整信息",Toast.LENGTH_SHORT ).show();
                }
                break;
        }
    }

}
