package licancan.com.comicdemo.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import licancan.com.comicdemo.R;
import licancan.com.comicdemo.bean.Book;

/**
 * Created by robot on 2017/8/19.
 */

public class MyoneAdapter extends BaseAdapter{
    private static final  int atype=0;//a布局
    private static final  int btype=1;//b布局
    private static final  int num_type=2;//总布局
    Context context;
    List<Book.Result.BookList> list;
    public MyoneAdapter(Context context, List<Book.Result.BookList> list) {
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
    public int getItemViewType(int position) {
//  奇偶数 if(position%2==0)
//        {
//            return atype;
//        }
//        else{
//            return btype;
//        }
        if(list.get(position).area.equals("国漫"))
        {
            return atype;
        }
        else{
            return btype;
        }

    }

    @Override
    public int getViewTypeCount() {
        return num_type;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder1 holder1=null;
        ViewHolder2 holder2=null;
        int type=getItemViewType(i);
        if(view==null)
        {
            switch (type)
            {
                case atype:
                    holder1=new ViewHolder1();
                    view= View.inflate(context, R.layout.item1,null);
                    holder1.tv_name1=view.findViewById(R.id.tv_name1);
                    holder1.iv_img1=view.findViewById(R.id.iv_img1);
                    holder1.tv_area1=view.findViewById(R.id.tv_area1);

                    holder1.tv_name1.setText(list.get(i).name);
                    holder1.tv_area1.setText(list.get(i).area);
                    ImageLoader.getInstance().displayImage(list.get(i).coverImg,holder1.iv_img1);
                    view.setTag(holder1);
                    break;
                case btype:
                    holder2=new ViewHolder2();
                    view= View.inflate(context,R.layout.item2,null);
                    holder2.tv_name2=view.findViewById(R.id.tv_name2);
                    holder2.iv_img2=view.findViewById(R.id.iv_img2);
                    holder2.tv_area2=view.findViewById(R.id.tv_area2);

                    holder2.tv_name2.setText(list.get(i).name);
                    holder2.tv_area2.setText(list.get(i).area);
                    ImageLoader.getInstance().displayImage(list.get(i).coverImg,holder2.iv_img2);
                    view.setTag(holder2);
                    break;
            }
        }
        else{
            switch (type)
            {
                case atype:
                    holder1= (ViewHolder1) view.getTag();
                    holder1.tv_name1.setText(list.get(i).name);
                    holder1.tv_area1.setText(list.get(i).area);
                    ImageLoader.getInstance().displayImage(list.get(i).coverImg,holder1.iv_img1);
                    break;
                case btype:
                    holder2= (ViewHolder2) view.getTag();
                    holder2.tv_name2.setText(list.get(i).name);
                    holder2.tv_area2.setText(list.get(i).area);
                    ImageLoader.getInstance().displayImage(list.get(i).coverImg,holder2.iv_img2);
                    break;
            }
        }


        return view;
    }
    class ViewHolder1 {
        ImageView iv_img1;
        TextView tv_area1;
        TextView tv_name1;
    }
    class ViewHolder2 {
        ImageView iv_img2;
        TextView tv_area2;
        TextView tv_name2;
    }
}
