package com.gongyunhao.sims.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gongyunhao.sims.R;

public class ModifyActivity extends AppCompatActivity {
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_modify );
        position=getIntent().getIntExtra( "position",-1 );
    }
}
