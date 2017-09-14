package licancan.com.comicdemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    private EditText et_pwd;
    private EditText et_name;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sp = getSharedPreferences("c",MODE_PRIVATE);
        initView();
        initRemember();
    }

    /**
     * 记住登录的方法
     */
    private void initRemember() {
        if(sp.getBoolean("login",false)==true)
        {
            //点击按钮跳转到成功页面
            Intent intent=new Intent(HomeActivity.this,LoginSuccActivity.class);
            startActivity(intent);
            finish();
        }
    }

    /**
     * 初始化控件
     */
    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_pwd = (EditText) findViewById(R.id.et_pwd);
    }


    /**
     * 登录按钮
     */
    public void login(View v) {
        String name = et_name.getText().toString();
        String pwd = et_pwd.getText().toString();

        if(name.equals("")||pwd.equals("")||et_name.getText().toString().toString().length()<=6)
        {
            Toast.makeText(this,"用户名或密码为空 用户名不能小于6位",Toast.LENGTH_SHORT).show();
        }

        else{

            sp.edit().putBoolean("login",true).commit();
            sp.edit().putString("name",name).commit();
            //点击按钮跳转到成功页面
            Intent intent=new Intent(HomeActivity.this,LoginSuccActivity.class);
            startActivity(intent);
            finish();
        }

    }
}
