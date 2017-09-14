package licancan.com.comicdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import licancan.com.comicdemo.R;
import licancan.com.comicdemo.XlistDetailActivity;
import licancan.com.comicdemo.adapter.FragmentAdapter;

import licancan.com.comicdemo.adapter.MyoneAdapter;
import licancan.com.comicdemo.bean.Book;
import licancan.com.comicdemo.mysql.MySql;
import licancan.com.comicdemo.requestUtils.RequestNews;
import view.xlistview.XListView;

/**
 * Created by robot on 2017/8/18.
 */

public class Fragment1 extends Fragment implements ViewPager.OnPageChangeListener, XListView.IXListViewListener {

    int[] imgs={R.drawable.a,R.drawable.b,R.drawable.c};
    //创建原点图片的集合
    List<ImageView> dot_list=new ArrayList<ImageView>();
    private ViewPager vp;
    private XListView xlist;

    private View view;
    private LinearLayout f1_ll;

    /**
     * 自动轮播
     */
   private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if(msg.what==100)
            {
                int c=vp.getCurrentItem();
                c++;
                vp.setCurrentItem(c);

            }
            handler.sendEmptyMessageDelayed(100,2000);
        }
    };
    private MyoneAdapter adapter;
    private Book book;
    private List<Book.Result.BookList> list;
    private MySql dao;

    String url="http://japi.juhe.cn/comic/book?name=&type=&key=d192b5ffd1e46182d3bb38b96b6ee81a";
    private ViewPager vp1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view = View.inflate(getActivity(), R.layout.fragment1,null);
        initView();
        initDot();
        FragmentAdapter adapter=new FragmentAdapter(getActivity());
        vp.setAdapter(adapter);
        vp.setOnPageChangeListener(this);
        handler.sendEmptyMessageDelayed(100,2000);
        new Thread(new Runnable() {
            @Override
            public void run() {
                String result = RequestNews.getNews(url);
                //把json字符串添加进数据库
                dao.insert(result);
                //查询字符串
                String select = dao.select();
                System.out.println("json=============="+select);
                System.out.println("result=============="+result.toString());
                getJson(result);

            }
        }).start();

        return view;
    }

    /**
     * 初始化
     */
    private void initView() {
        xlist=view.findViewById(R.id.xlist);
        f1_ll = view.findViewById(R.id.f1_ll);
        //header
        View inflate = LayoutInflater.from(getActivity()).inflate(R.layout.item_view, null);
        vp = inflate.findViewById(R.id.vp);
        f1_ll=inflate.findViewById(R.id.f1_ll);
        xlist.addHeaderView(inflate);

        adapter = new MyoneAdapter(getActivity(),list);
        dao = new MySql(getActivity());

        xlist.setXListViewListener(this);
        //支持上拉加载和下拉刷新
        xlist.setPullLoadEnable(true);
        xlist.setPullRefreshEnable(true);
        xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(getActivity(), XlistDetailActivity.class);
                intent.putExtra("name",list.get(i).name);
                startActivity(intent);
            }
        });
    }



    /**
     * 设置原点
     */
    private void initDot() {
        //imgs存放图片的数组
        for (int i = 0; i <imgs.length ; i++) {
            ImageView iv=new ImageView(getActivity());
            if(i==0)
            {
                iv.setImageResource(R.drawable.red);
            }
            else{
                iv.setImageResource(R.drawable.bule);
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(10,10);
            params.setMargins(10,5,10,5);
            f1_ll.addView(iv,params);
            dot_list.add(iv);
        }
    }

    /**
     * 设置ViewPager的监听事件
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i <dot_list.size() ; i++) {
            if(i==position%imgs.length)
            {
                dot_list.get(i).setImageResource(R.drawable.red);
            }else{
                dot_list.get(i).setImageResource(R.drawable.bule);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    /**
     * 解析json数据
     */
    public void getJson(String result) {
        Gson gson=new Gson();
        book = gson.fromJson(result, Book.class);

        list = book.result.bookList;
        for (Book.Result.BookList b:list) {
            Log.i("json===================",b.area+"  "+b.name+"  "+b.coverImg);
        }
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter = new MyoneAdapter(getActivity(),list);
                xlist.setAdapter(adapter);
            }
        });


        /*//设置适配器的方法
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                setAdapter();
            }
        });*/
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {

        //重新关联适配器
        xlist.setAdapter(adapter);

        xlist.stopLoadMore();
        xlist.stopRefresh();
    }

    /**
     * 上拉加载更多
     */
    @Override
    public void onLoadMore() {
        list.addAll(list);
        //刷新适配器
        adapter.notifyDataSetChanged();
        xlist.stopLoadMore();
        xlist.stopRefresh();
    }

    /**
     * 设置适配器的方法
     */
    /*public void setAdapter()
    {
        if(adapter==null)
        {
            adapter = new ListAdapter(getActivity(),list);
            xlist.setAdapter(adapter);
        }
    }*/
}