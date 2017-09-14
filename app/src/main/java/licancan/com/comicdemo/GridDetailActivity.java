package licancan.com.comicdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import licancan.com.comicdemo.adapter.DetailGridAdapter;
import licancan.com.comicdemo.bean.Detail;
import licancan.com.comicdemo.requestUtils.RequestNews;

public class GridDetailActivity extends AppCompatActivity {

    //请求列表的网络地址
    //String url="http://japi.juhe.cn/comic/book?key=3e09796970b04508f16de756d36d4bb8";
    private GridView detail_gv_list;
    private DetailGridAdapter detailAdapter;
    private List<Detail.ResultBean.BookListBean> detail_list;
    private TextView title;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_detail);
        initView();
        Intent in=getIntent();
        String name = in.getStringExtra("name");
        title.setText(name);

        StringBuffer url=new StringBuffer();
        try {
            url.append("http://japi.juhe.cn/comic/book?name=&type=")
                    .append(URLEncoder.encode(name,"UTF-8"))
                    .append("&skip=&finish=&key=d192b5ffd1e46182d3bb38b96b6ee81a");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("url = " + url.toString());
        new MyAsyncTask().execute(url.toString());
    }

    /**
     * 初始化控件
     */
    private void initView() {
        detail_gv_list = (GridView) findViewById(R.id.detail_gv_list);
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GridDetailActivity.this.finish();
            }
        });
    }


    class MyAsyncTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            String news = RequestNews.getNews(strings[0]);
            return news;
        }

        /**
         * 请求完数据进行解析的方法
         * @param s
         */
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            getJson(s);
        }
    }

    /**
     * 解析json串的方法
     * @param s
     */
    private void getJson(String s) {
        Gson gson=new Gson();
        Detail detail = gson.fromJson(s, Detail.class);
        detail_list = detail.getResult().getBookList();
        for (Detail.ResultBean.BookListBean d: detail_list) {
            System.out.println("detail======="+d.getName()+"  "+d.getCoverImg());
        }

        detailAdapter = new DetailGridAdapter(this, detail_list);
        detail_gv_list.setAdapter(detailAdapter);
        detail_gv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //跳转到xlist详情页
                Intent intent=new Intent(GridDetailActivity.this,XlistDetailActivity.class);
                intent.putExtra("name",detail_list.get(i).getName());
                startActivity(intent);
            }
        });

    }
}
