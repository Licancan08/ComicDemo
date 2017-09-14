package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import licancan.com.comicdemo.R;

/**
 * Created by robot on 2017/8/18.
 */

public class FragmentAdapter extends PagerAdapter {

    int[] imgs={R.drawable.a,R.drawable.b,R.drawable.c};
    Context context;

    public FragmentAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
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
        View view=View.inflate(context, R.layout.vp_small,null);

        ImageView iv=view.findViewById(R.id.iv);
        iv.setImageResource(imgs[position%imgs.length]);
        container.addView(view);

        return view;
    }
}
