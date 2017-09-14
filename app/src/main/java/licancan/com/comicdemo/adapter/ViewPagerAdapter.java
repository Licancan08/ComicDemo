package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import licancan.com.comicdemo.R;

/**
 * Created by robot on 2017/8/17.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private int[] img={R.drawable.guide_1,R.drawable.guide_2,R.drawable.guide_3,R.drawable.guide_4};
    private Context context;
    public ViewPagerAdapter(Context context) {
        super();
        this.context = context;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=View.inflate(context, R.layout.vp_item,null);
        ImageView iv_img = (ImageView) view.findViewById(R.id.iv_img);
        //给img设置值
        iv_img.setImageResource(img[position%img.length]);
        //铺满
        iv_img.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //把资源加载到img上
        container.addView(view);
        return view;
    }
}
