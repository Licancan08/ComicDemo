package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.content.SharedPreferences;
import android.media.Image;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import licancan.com.comicdemo.GridDetailActivity;
import licancan.com.comicdemo.R;
import licancan.com.comicdemo.bean.Detail;

/**
 * Created by robot on 2017/8/21.
 */

public class DetailGridAdapter extends BaseAdapter {

    Context context;
    List<Detail.ResultBean.BookListBean> detail_list;

    public DetailGridAdapter(Context context,List<Detail.ResultBean.BookListBean> detail_list) {
        this.context = context;
        this.detail_list=detail_list;
    }

    @Override
    public int getCount() {
        return detail_list.size();
    }

    @Override
    public Object getItem(int i) {
        return detail_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View corvertview, ViewGroup viewGroup) {

        View view=View.inflate(context, R.layout.detail_gv_item,null);
        ImageView detail_iv_img=view.findViewById(R.id.detail_iv_img);
        TextView detail_name=view.findViewById(R.id.detail_name);

        detail_name.setText(detail_list.get(i).getName());
        ImageLoader.getInstance().displayImage(detail_list.get(i).getCoverImg(),detail_iv_img);
        return view;
        
    }
}
