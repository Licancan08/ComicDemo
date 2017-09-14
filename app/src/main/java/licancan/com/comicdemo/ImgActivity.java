package licancan.com.comicdemo;

import android.content.Intent;
import android.media.Image;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import licancan.com.comicdemo.adapter.ImgAdapter;
import licancan.com.comicdemo.bean.Img;
import licancan.com.comicdemo.requestUtils.RequestNews;

public class ImgActivity extends AppCompatActivity {

    private List<Img.ResultBean.ImageListBean> img_list;
    private ListView img_lv_list;
    private ImageView back;
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        initView();
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int id = intent.getIntExtra("id",0);
        String book = intent.getStringExtra("book");
        title.setText(book);

        System.out.println("name====="+name+"  id======"+id);

        /*StringBuffer url=new StringBuffer();
        try {
            url.append("http://japi.juhe.cn/comic/chapterContent?&comicName=")
                    .append(URLEncoder.encode(name,"UTF-8"))
                    .append("&id="+id+"&key=d192b5ffd1e46182d3bb38b96b6ee81a");
            new MyAsyncTask().execute(url.toString());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }*/
        StringBuffer url=new StringBuffer();
        try {
            url.append("http://japi.juhe.cn/comic/chapterContent?&comicName=")
                    .append(URLEncoder.encode(name,"UTF-8"))
                    .append("&id="+id+"&key=d192b5ffd1e46182d3bb38b96b6ee81a");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        new MyAsyncTask().execute(url.toString());

    }

    /**
     * 初始化控件
     */
    private void initView() {
        img_lv_list = (ListView) findViewById(R.id.img_lv_list);
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImgActivity.this.finish();
            }
        });
    }

    class MyAsyncTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {
            String news = RequestNews.getNews(strings[0]);
            System.out.println("img_news============="+news);

            return news;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            getJson(s);
        }
    }

    /**
     * 解析json
     * @param s
     */
    private void getJson(String s) {
        Gson gson=new Gson();
        Img img = gson.fromJson(s, Img.class);
        img_list = img.getResult().getImageList();
        for (Img.ResultBean.ImageListBean i:img_list) {
            System.out.println("img========"+i.getImageUrl());
        }

        ImgAdapter adapter=new ImgAdapter(this,img_list);
        img_lv_list.setAdapter(adapter);
    }
}
