package com.juyou.app.activity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.juyou.app.R;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LocalMerchantsActivity extends BaseActivity {


    @BindView(R.id.gv_merchants_type)
    GridView gvMerchantsType;
    @BindView(R.id.lv_more_shops)
    ListView lvMoreShops;

    private List<Integer> merchantsTypeList = new ArrayList<>();
    private List<Map<String, Object>> moreShopsList = new ArrayList<>();

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


        TypedArray merchantsTypsArray = this.getResources().obtainTypedArray(R.array.merchants_type_icons);
        for (int i = 0; i < merchantsTypsArray.length(); i++) {
            merchantsTypeList.add(merchantsTypsArray.getResourceId(i, R.mipmap.icon_fscd));
        }
        merchantsTypsArray.recycle();


        for (int i = 0; i < 10; i++) {
            Map<String, Object> itemMap = new HashMap<>();
            itemMap.put("img_shop", R.mipmap.shop_img);
            itemMap.put("shop_title", "小食后中餐厅");
            itemMap.put("shop_sub_title", "美食餐饮-中餐厅");
            itemMap.put("btn_shop", "券");
            itemMap.put("shop_address", "龙泉镇富民路32号（fdsafas ）");
            itemMap.put("shop_distance", "1.23km");
            moreShopsList.add(itemMap);
        }
    }

    @Override
    protected void initView() {
        setTitleBack(true, R.mipmap.back1);
        setTitleName(getString(R.string.local_merchants), Color.WHITE);
//        setTitleRightText("申请入驻", Color.WHITE);//右侧文字
        showTitleRes(R.id.title_scan_code, R.id.title_application_in);

        gvMerchantsType.setAdapter(new CommonAdapter<Integer>(this.getApplicationContext(), R.layout.item_list_merchants_type, merchantsTypeList) {
            @Override
            protected void convert(ViewHolder viewHolder, Integer item, int position) {
                viewHolder.setImageResource(R.id.img_merchants_type, item);
            }
        });


        lvMoreShops.setAdapter(new CommonAdapter<Map<String, Object>>(this.getApplicationContext(), R.layout.item_list_more_shops, moreShopsList) {
            @Override
            protected void convert(ViewHolder viewHolder, Map<String, Object> item, int position) {
                viewHolder.setImageResource(R.id.img_shop, Integer.valueOf(item.get("img_shop")+""));
                viewHolder.setText(R.id.tv_shop_title, item.get("shop_title")+"");
                viewHolder.setText(R.id.tv_shop_sub_title, item.get("shop_sub_title")+"");
                viewHolder.setText(R.id.btn_shop, item.get("btn_shop")+"");
                viewHolder.setText(R.id.tv_shop_address, item.get("shop_address")+"");
                viewHolder.setText(R.id.tv_shop_distance, item.get("shop_distance")+"");
            }
        });
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
        switch (item.getItemId()) {
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
