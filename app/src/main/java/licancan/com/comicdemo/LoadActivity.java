package licancan.com.comicdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import licancan.com.comicdemo.adapter.ViewPagerAdapter;

public class LoadActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private int[] img={R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3,R.drawable.guide_4};
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private Button click_into;
    int i=0;
    private LinearLayout ll;
    private List<ImageView> dotlist;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        sp = getSharedPreferences("config",MODE_PRIVATE);
        initView();
        initData();
        immersion();
        initDot();
        initRemenber();
    }

    /**
     * 记住引导页面
     */
    private void initRemenber() {
        if(sp.getBoolean("login",false)==true)
        {
            Intent intent=new Intent(LoadActivity.this,StartingActivity.class);
            startActivity(intent);
            finish();
        }

    }

    /**
     * 初始化控件
     */
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        click_into = (Button) findViewById(R.id.click_into);
        ll = (LinearLayout) findViewById(R.id.ll);

    }
    /**
     * 初始化数据
     */
    private void initData() {
        //创建原点图片的集合
        dotlist = new ArrayList<ImageView>();
        adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
    }
    /**
     * 设置沉浸式的方法
     */
    private void immersion() {
        View decorView=getWindow().getDecorView();
        int option=View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar=getSupportActionBar();
        actionBar.hide();
    }


    /**
     * 画圆的方法
     */
    private void initDot() {

        for (int i = 0; i <img.length ; i++) {
            ImageView iv=new ImageView(this);
            if(i==0)
            {
                iv.setImageResource(R.drawable.red);
            }
            else{
                iv.setImageResource(R.drawable.bule);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(25,25);
            params.setMargins(10,5,10,5);
            ll.addView(iv,params);
            dotlist.add(iv);
        }
    }


    public void click_into(View v)
    {
        sp.edit().putBoolean("login",true).commit();
        Intent intent=new Intent(LoadActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * View的点击事件
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        switch (position)
        {
            case 0:
                click_into.setVisibility(View.INVISIBLE);
                break;
            case 1:
                click_into.setVisibility(View.INVISIBLE);
                break;
            case 2:
                click_into.setVisibility(View.INVISIBLE);
                break;
            case 3:
                click_into.setVisibility(View.VISIBLE);
                break;

        }

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <dotlist.size() ; i++) {
            if(i==position)
            {
                dotlist.get(i).setImageResource(R.drawable.red);
            }
            else{
                dotlist.get(i).setImageResource(R.drawable.bule);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
