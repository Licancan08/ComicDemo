package licancan.com.comicdemo;

import android.app.Fragment;
import android.app.FragmentManager;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import licancan.com.comicdemo.fragment.Fragment1;
import licancan.com.comicdemo.fragment.Fragment2;
import licancan.com.comicdemo.fragment.Fragment3;

public class LoginSuccActivity extends AppCompatActivity {

    private ImageView iv_one;
    private ImageView iv_two;
    private ImageView iv_three;
    private FrameLayout fl;
    private TextView tv_one;
    private TextView tv_two;
    private TextView tv_three;
    private Fragment1 f1;
    private Fragment2 f2;
    private Fragment3 f3;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginsucc);
        initView();
        initData();
        initFragment();
        //默认显示第一个页面
        getSupportFragmentManager().beginTransaction().show(f1).commit();
        getSupportFragmentManager().beginTransaction().hide(f3).commit();
        getSupportFragmentManager().beginTransaction().hide(f2).commit();

        iv_one.setImageResource(R.drawable.tab_main_select);
        tv_one.setTextColor(Color.GREEN);
    }

    /**
     * 添加Fragment
     */
    private void initFragment() {
        getSupportFragmentManager().beginTransaction().add(R.id.fl,f1).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,f2).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.fl,f3).commit();
    }


    /**
     * 初始化控件
     */
    private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        iv_one = (ImageView) findViewById(R.id.iv_one);
        iv_two = (ImageView) findViewById(R.id.iv_two);
        iv_three = (ImageView) findViewById(R.id.iv_three);
        tv_one = (TextView) findViewById(R.id.tv_one);
        tv_two = (TextView) findViewById(R.id.tv_two);
        tv_three = (TextView) findViewById(R.id.tv_three);
        title = (TextView) findViewById(R.id.frag_title);

    }


    /**
     * 初始化数据
     */
    private void initData() {
        f1 = new Fragment1();
        f2 = new Fragment2();
        f3 = new Fragment3();
    }


    /**
     * 图片的点击事件的点击事件
     */
    public void iv_one(View v)
    {
        title.setText("推荐");
        getSupportFragmentManager().beginTransaction().show(f1).commit();
        getSupportFragmentManager().beginTransaction().hide(f3).commit();
        getSupportFragmentManager().beginTransaction().hide(f2).commit();
        iv_one.setImageResource(R.drawable.tab_main_select);
        iv_two.setImageResource(R.drawable.tab_category_normal);
        iv_three.setImageResource(R.drawable.tab_me_normal);
        tv_one.setTextColor(Color.GREEN);
        tv_two.setTextColor(Color.GRAY);
        tv_three.setTextColor(Color.GRAY);
    }
    public void iv_two(View v)
    {
        title.setText("目录");
        getSupportFragmentManager().beginTransaction().show(f2).commit();
        getSupportFragmentManager().beginTransaction().hide(f1).commit();
        getSupportFragmentManager().beginTransaction().hide(f3).commit();
        iv_one.setImageResource(R.drawable.tab_main_normal);
        iv_two.setImageResource(R.drawable.tab_catefory_select);
        iv_three.setImageResource(R.drawable.tab_me_normal);
        tv_one.setTextColor(Color.GRAY);
        tv_two.setTextColor(Color.GREEN);
        tv_three.setTextColor(Color.GRAY);
    }
    public void iv_three(View v)
    {
        title.setText("我的");
        getSupportFragmentManager().beginTransaction().show(f3).commit();
        getSupportFragmentManager().beginTransaction().hide(f1).commit();
        getSupportFragmentManager().beginTransaction().hide(f2).commit();
        iv_one.setImageResource(R.drawable.tab_main_normal);
        iv_two.setImageResource(R.drawable.tab_category_normal);
        iv_three.setImageResource(R.drawable.tab_me_select);
        tv_one.setTextColor(Color.GRAY);
        tv_two.setTextColor(Color.GRAY);
        tv_three.setTextColor(Color.GREEN);
    }
}
