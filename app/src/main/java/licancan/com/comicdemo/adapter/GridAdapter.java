package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import licancan.com.comicdemo.R;

/**
 * Created by robot on 2017/8/19.
 */

public class GridAdapter extends BaseAdapter {

    Context context;
    List<String> list;
    public GridAdapter(Context context, List<String> list) {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View view1=View.inflate(context, R.layout.gv_item,null);

        TextView tv_book=view1.findViewById(R.id.tv_book);
        tv_book.setText(list.get(i));
        return view1;
    }
}
