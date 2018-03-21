package com.gongyunhao.sims.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.gongyunhao.sims.ArrayList.InterestIdAndInterestNameAndInterestCategoryIdBeanList;
import com.gongyunhao.sims.ArrayList.StudentAndInterestBeanList;
import com.gongyunhao.sims.ArrayList.StudentBeanList;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.Bean.StudentAndInterestBean;
import com.gongyunhao.sims.Bean.StudentBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.List;

public class SearchActivity extends AppCompatActivity {


    private StudentBeanList studentBeanList;
    private StudentAndInterestBeanList studentAndInterestBeanList;
    private InterestIdAndInterestNameAndInterestCategoryIdBeanList interestIdAndInterestNameAndInterestCategoryIdBeanList;
    private TextView textViewSearch;
    private ImageView imageViewCancle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        studentBeanList = new StudentBeanList();
        studentAndInterestBeanList = new StudentAndInterestBeanList();
        interestIdAndInterestNameAndInterestCategoryIdBeanList = new InterestIdAndInterestNameAndInterestCategoryIdBeanList();
        textViewSearch = (TextView)findViewById(R.id.search_text);
        imageViewCancle = (ImageView)findViewById(R.id.search_cancle);
        textViewSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(!textViewSearch.getText().toString().isEmpty()){
                    imageViewCancle.setVisibility(View.VISIBLE);
                }else{
                    imageViewCancle.setVisibility(View.GONE);
                }




            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        imageViewCancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewSearch.setText("");
            }
        });

        FileHelper fileHelper = new FileHelper();

        if (fileHelper.readStudentData(SearchActivity.this)!=null){
            List<StudentBean> tempStudentList = fileHelper.readStudentData(SearchActivity.this);
            for (int i=0;i<tempStudentList.size();i++){
               studentBeanList.addStudentBean(tempStudentList.get(i).getStudentName(),tempStudentList.get(i).getStudentSex(),tempStudentList.get(i).getStudentGrade(),tempStudentList.get(i).getStudentNumber(),tempStudentList.get(i).getStudentMajor());
            }
        }

        if (fileHelper.readStudentAInterestData(SearchActivity.this)!=null){
            List<StudentAndInterestBean> tempStudentAndInterestList = fileHelper.readStudentAInterestData(SearchActivity.this);
            for (int i=0;i<tempStudentAndInterestList.size();i++){
                studentAndInterestBeanList.addStudentAndInterestBean(tempStudentAndInterestList.get(i).getStudentNumber(),tempStudentAndInterestList.get(i).getInterestId());
            }
        }

        if (fileHelper.readIIAINAICData(SearchActivity.this)!=null){
            List<InterestIdAndInterestNameAndInterestCategoryIdBean> interestIdAndInterestNameAndInterestCategoryIdBeans = fileHelper.readIIAINAICData(SearchActivity.this);
            for (int i=0;i<interestIdAndInterestNameAndInterestCategoryIdBeans.size();i++){
                interestIdAndInterestNameAndInterestCategoryIdBeanList.addInterestIdAndInterestNameAndInterestCategoryIdBean(interestIdAndInterestNameAndInterestCategoryIdBeans.get(i).getInterestId(),interestIdAndInterestNameAndInterestCategoryIdBeans.get(i).getInterestName(),interestIdAndInterestNameAndInterestCategoryIdBeans.get(i).getInterestCategoryId());
            }
        }

        public void searchByStudentName(String studentName){

            int tempIndex = studentBeanList.findStudentBeanListByStudentName(studentName);
            StudentBean studentBean = studentBeanList.getStudentBean(tempIndex);

        }

        public void searchByStudentNumber(String studentNumber){

            int tempIndex = studentBeanList.findStudentBeanListByStudentNumber(studentNumber);
            StudentBean studentBean = studentBeanList.getStudentBean(tempIndex);

        }

        public void searchByInterestName(String interestName){

            int tempInterestId = interestIdAndInterestNameAndInterestCategoryIdBeanList.getInterestId(interestName);
            String []tempStudentNumbers = studentAndInterestBeanList.findByStudentInterestId(tempInterestId);
            for (int i=0;i<tempStudentNumbers.length;i++){

                int tempIndex = studentBeanList.findStudentBeanListByStudentNumber(tempStudentNumbers[i]);
                StudentBean studentBean = studentBeanList.getStudentBean(tempIndex);

            }

        }



    }
}

