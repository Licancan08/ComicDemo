package licancan.com.comicdemo;

import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class StartingActivity extends AppCompatActivity {

    int num=5;
    android.os.Handler handler=new android.os.Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            num--;
            if(num>0)
            {
                time_dot.setText(""+num);
            }else if(num==0)
            {
                time_dot.setText(""+num);
                //等于0就跳转页面
                Intent intent=new Intent(StartingActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();

            }
            //延时一秒跳转
            handler.sendEmptyMessageDelayed(0,1000);
        }

    };
    private TextView time_dot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);
        initView();
        immersion();
        handler.sendEmptyMessageDelayed(0,1000);
    }

    /**
     * 初始化控件
     */
    private void initView() {
        time_dot = (TextView) findViewById(R.id.time_dot);
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

    public void click(View v)
    {
        Intent intent=new Intent(StartingActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }


}
