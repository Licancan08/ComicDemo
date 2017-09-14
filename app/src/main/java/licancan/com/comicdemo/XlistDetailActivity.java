package licancan.com.comicdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

import licancan.com.comicdemo.adapter.ReaderAdapter;
import licancan.com.comicdemo.bean.Reader;
import licancan.com.comicdemo.requestUtils.RequestNews;
import view.xlistview.XListView;

public class XlistDetailActivity extends AppCompatActivity implements XListView.IXListViewListener {

    private XListView detail_xlist;

    //String url="http://japi.juhe.cn/comic/chapter?comicName=%E7%81%AB%E5%BD%B1%E5%BF%8D%E8%80%85&key=3e09796970b04508f16de756d36d4bb8";

    private List<Reader.ResultBean.ChapterListBean> reader_list;
    private String name;
    private TextView title;
    private ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xlist_detail);
        initView();
        Intent in=getIntent();
        name = in.getStringExtra("name");
        System.out.println("name ============== " + name);
        title.setText(name);
        //追加参数
        StringBuffer url = new StringBuffer();
        try {
            url.append("http://japi.juhe.cn/comic/chapter?comicName=")
                    .append(URLEncoder.encode(name,"UTF-8"))
                    .append("&skip=&key=d192b5ffd1e46182d3bb38b96b6ee81a");
        } catch (Exception e) {
            e.printStackTrace();
        }

        /*http://japi.juhe.cn/comic/chapter
        请求参数：comicName=%E7%9B%97%E5%A2%93%E8%BF%B7%E5%BD%B1&skip=&key=3e09796970b04508f16de756d36d4bb8*/
        /*url.append("http://japi.juhe.cn/comic/book?name=&type=")
                .append(URLEncoder.encode(name,"UTF-8"))
                .append("&skip=&finish=&key=3e09796970b04508f16de756d36d4bb8");*/

        new MyAsyncTask().execute(url.toString());

    }

    /**
     * 初始化控件
     */
    private void initView() {
        detail_xlist = (XListView) findViewById(R.id.detail_xlist);
        detail_xlist.setXListViewListener(this);
        detail_xlist.setPullRefreshEnable(true);
        detail_xlist.setPullLoadEnable(true);
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                XlistDetailActivity.this.finish();
            }
        });
    }

    @Override
    public void onRefresh() {
        detail_xlist.stopRefresh();
    }

    @Override
    public void onLoadMore() {
        detail_xlist.stopLoadMore();
    }

    class MyAsyncTask extends AsyncTask<String,Integer,String>{

        @Override
        protected String doInBackground(String... strings) {

            String xlist = RequestNews.getNews(strings[0]);

            return xlist;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

             getList(s);

        }
    }

    /**
     * 解析json串
     * @param s
     */
    private void getList(String s) {
        Gson gson=new Gson();
        Reader reader = gson.fromJson(s, Reader.class);
        reader_list = reader.getResult().getChapterList();
        for (Reader.ResultBean.ChapterListBean r:reader_list)
        {
            int id = r.getId();
            System.out.println("id=================="+id);
            System.out.println("reader===="+r.getName());
        }

        ReaderAdapter readerAdapter=new ReaderAdapter(this,reader_list);
        detail_xlist.setAdapter(readerAdapter);
        detail_xlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(XlistDetailActivity.this,ImgActivity.class);
                intent.putExtra("name",name);
                intent.putExtra("id",reader_list.get(i-1).getId());
                System.out.println("ssss"+reader_list.get(i-1).getId());
                intent.putExtra("book",reader_list.get(i-1).getName());
                startActivity(intent);
            }
        });
    }
}
