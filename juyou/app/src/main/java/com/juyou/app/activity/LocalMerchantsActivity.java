package com.juyou.app.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.juyou.app.R;

public class LocalMerchantsActivity extends BaseActivity {


    @Override
    protected int setLayoutId() {
        return R.layout.activity_local_merchants;
    }

    @Override
    protected void initImmersionBar() {
        super.initImmersionBar();
        mImmersionBar.statusBarView(R.id.top_view)
                .navigationBarColor(R.color.colorPrimary)
                .fullScreen(true)
                .addTag("PicAndColor")  //给上面参数打标记，以后可以通过标记恢复
                .init();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        setTitleBack(true, R.mipmap.back1);
        setTitleName(getString(R.string.local_merchants), Color.WHITE);
//        setTitleRightText("申请入驻", Color.WHITE);//右侧文字
        showTitleRes(R.id.title_scan_code, R.id.title_application_in);
    }

    @Override
    protected void setListener() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.base_toolbar_menu, menu);//加载menu文件到布局
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.title_scan_code://扫描
                Toast.makeText(this, "点击了扫描", Toast.LENGTH_SHORT).show();
                break;
            case R.id.title_application_in://申请入驻
                Toast.makeText(this, "点击了申请入驻", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(this, LoginActivity.class));
                break;
        }
        return super.onMenuItemClick(item);
    }
}
