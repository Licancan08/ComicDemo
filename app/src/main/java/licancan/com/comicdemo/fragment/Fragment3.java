package licancan.com.comicdemo.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import licancan.com.comicdemo.HomeActivity;
import licancan.com.comicdemo.R;

/**
 * Created by robot on 2017/8/18.
 */

public class Fragment3 extends Fragment implements View.OnClickListener {

    private View view;
    private TextView tv_name;
    private SharedPreferences sp;
    private Button back_login;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = View.inflate(getActivity(), R.layout.fragment3,null);
        initView();
        sp = getActivity().getSharedPreferences("c", Context.MODE_PRIVATE);
        //把保存的名字取出来
        tv_name.setText( sp.getString("name", null));
        return view;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        tv_name = view.findViewById(R.id.tv_name);
        back_login = view.findViewById(R.id.back_login);
        back_login.setOnClickListener(this);
    }

    /**
     * 退出登录按钮的点击事件
    */
    @Override
    public void onClick(View view) {
        sp.edit().clear().commit();
        Intent intent=new Intent(getActivity(), HomeActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}
