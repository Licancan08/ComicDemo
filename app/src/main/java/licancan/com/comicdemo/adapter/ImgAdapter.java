package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import licancan.com.comicdemo.ImgActivity;
import licancan.com.comicdemo.R;
import licancan.com.comicdemo.bean.Img;

/**
 * Created by robot on 2017/8/21.
 */

public class ImgAdapter extends BaseAdapter {

    Context context;
    List<Img.ResultBean.ImageListBean> img_list;

    public ImgAdapter(Context context, List<Img.ResultBean.ImageListBean> img_list) {
        this.context = context;
        this.img_list=img_list;
    }

    @Override
    public int getCount() {
        return img_list.size();
    }

    @Override
    public Object getItem(int i) {
        return img_list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View covertView, ViewGroup viewGroup) {

        View view=View.inflate(context, R.layout.img_item,null);
        ImageView img_detail=view.findViewById(R.id.img_detail);
        ImageLoader.getInstance().displayImage(img_list.get(i).getImageUrl(),img_detail);
        System.out.println("img_url========================="+img_list.get(i).getImageUrl());
        return view;
    }
}
