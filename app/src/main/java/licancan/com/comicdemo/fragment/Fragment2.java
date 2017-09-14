package licancan.com.comicdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.List;

import licancan.com.comicdemo.GridDetailActivity;
import licancan.com.comicdemo.R;
import licancan.com.comicdemo.adapter.GridAdapter;
import licancan.com.comicdemo.bean.Type;
import licancan.com.comicdemo.requestUtils.RequestNews;


/**
 * Created by robot on 2017/8/18.
 */

public class Fragment2 extends Fragment{

    String url="http://japi.juhe.cn/comic/category?key=d192b5ffd1e46182d3bb38b96b6ee81a";
    private View view;
    private GridView gv_list;
    private List<String> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment2,null);
        initView();
        initHttpurl();

        return view;
    }

    private void initHttpurl() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = RequestNews.getNews(url);
                System.out.println("_____________"+result);
                getjson(result);
            }
        }).start();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        gv_list = view.findViewById(R.id.gv_list);
        gv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //点击跳转到详情页
                Intent intent=new Intent(getActivity(), GridDetailActivity.class);
                intent.putExtra("name",list.get(i));
                startActivity(intent);
            }
        });
    }

    /**
     * 解析json字符串
     * @param result
     */
    private void getjson(String result) {
        Gson gson=new Gson();
        Type type = gson.fromJson(result, Type.class);
        list = type.getResult();
        System.out.println("result1 = " + list.size());
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                GridAdapter adapter=new GridAdapter(getActivity(),list);
                gv_list.setAdapter(adapter);
            }
        });

        }

}
