package com.charon.www.younghawkdemo.ui.Activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.charon.www.younghawkdemo.R;

import static com.charon.www.younghawkdemo.model.Constant.PLAN_PLAN;
import static com.charon.www.younghawkdemo.model.Constant.PLAN_SUMMARY;

/**
 * Created by Charon on 2017/5/3.
 */

public class FabPlanActivity extends AppCompatActivity {
    private EditText mEtSummary,mEtPlan;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fab_plan);
        initView();
    }

    private void initView() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.fab_plan_toolbar);
        mEtSummary = (EditText) findViewById(R.id.fab_plan_et_summary);
        mEtPlan = (EditText) findViewById(R.id.fab_plan_et_plan);

        mToolbar.setTitle("总结与计划");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mEtSummary.setText(getIntent().getStringExtra(PLAN_SUMMARY));
        mEtSummary.setSelection(mEtSummary.getText().toString().length());
        mEtPlan.setText(getIntent().getStringExtra(PLAN_PLAN));
        mEtPlan.setSelection(mEtPlan.getText().toString().length());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.fab_home_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.fab_home_release) {
            Toast.makeText(this, "总结：" + mEtSummary.getText()+"计划："+mEtPlan.getText(), Toast.LENGTH_SHORT).show();
            //上传
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
