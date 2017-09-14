package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import licancan.com.comicdemo.R;
import licancan.com.comicdemo.XlistDetailActivity;
import licancan.com.comicdemo.bean.Reader;

/**
 * Created by robot on 2017/8/21.
 */

public class ReaderAdapter extends BaseAdapter {
    Context context;
    List<Reader.ResultBean.ChapterListBean> reader_list;
    public ReaderAdapter(Context context,List<Reader.ResultBean.ChapterListBean> reader_list) {
            this.context=context;
        this.reader_list=reader_list;
    }

    @Override
    public int getCount() {
        return reader_list.size();
    }

    @Override
    public Object getItem(int i) {
        return reader_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View corvertView, ViewGroup viewGroup) {
        View view=View.inflate(context, R.layout.reader_item,null);
        TextView reader_name=view.findViewById(R.id.reader_name);
        reader_name.setText("空章节");
        if(!reader_list.get(i).getName().equals("")||!reader_list.get(i).getName().equals(null))
        {
            reader_name.setText(reader_list.get(i).getName());
        }
        return view;
    }
}
