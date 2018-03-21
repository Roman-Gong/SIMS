package com.gongyunhao.sims.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gongyunhao.sims.Bean.InterestCategoryAndHisIdBean;
import com.gongyunhao.sims.Bean.InterestIdAndInterestNameAndInterestCategoryIdBean;
import com.gongyunhao.sims.R;
import com.gongyunhao.sims.Utils.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class AddInterestActivity extends AppCompatActivity {
    private EditText et_add_interest_category,et_add_interest_item,et_id;
    private Button yes_btn;
    private FileHelper fileHelper;
    private List<InterestCategoryAndHisIdBean> interestCategoryAndHisIdBeans=new ArrayList<>(  );
    private List<InterestIdAndInterestNameAndInterestCategoryIdBean> interestIdAndInterestNameAndInterestCategoryIdBeans=new ArrayList<>(  );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_add_interest );
        et_add_interest_category=findViewById( R.id.et_add_interest_category );
        et_add_interest_item=findViewById( R.id.et_add_interest_item );
        et_id=findViewById( R.id.et_add_interest_category_id );
        yes_btn=findViewById( R.id.btn_add_interest_yes );
        final FileHelper fileHelper=new FileHelper();
        if (fileHelper.readIIAINAICData( AddInterestActivity.this )!=null){
            interestIdAndInterestNameAndInterestCategoryIdBeans.addAll( fileHelper.readIIAINAICData( AddInterestActivity.this ) );
        }
        if (fileHelper.readCategoryAndHisIdData( AddInterestActivity.this )!=null){
            interestCategoryAndHisIdBeans.addAll( fileHelper.readCategoryAndHisIdData( AddInterestActivity.this ));
        }

        yes_btn.setOnClickListener( new View.OnClickListener( ) {
            @Override
            public void onClick(View view) {
                String category =et_add_interest_category.getText().toString();
                String id= et_id.getText().toString();
                String[] item=et_add_interest_item.getText().toString().split( " " );
                List<Integer> id_item=new ArrayList<>(  );
                for (int i=0;i<item.length;i++){
                    id_item.add( Integer.parseInt( item[i].split( "," )[0] ) );
                    interestIdAndInterestNameAndInterestCategoryIdBeans.add( new InterestIdAndInterestNameAndInterestCategoryIdBean( item[i].split( "," )[0] ,item[i].split( "," )[1],id ));
                }
                interestCategoryAndHisIdBeans.add( new InterestCategoryAndHisIdBean( id,category ) );
                fileHelper.saveIISINSICIB( AddInterestActivity.this,interestIdAndInterestNameAndInterestCategoryIdBeans );
                fileHelper.saveInterestCategoryHisIdToFile( AddInterestActivity.this, interestCategoryAndHisIdBeans);
                Toast.makeText( AddInterestActivity.this,"添加兴趣项成功",Toast.LENGTH_SHORT ).show();
                finish();
            }
        } );

    }
}
