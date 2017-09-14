package licancan.com.comicdemo.mysql;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by robot on 2017/8/22.
 */

public class NetState {
    private Context context;

    public NetState(Context context) {
        this.context = context;
    }
    public boolean NewWork(){

        // 1.获取系统服务
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        // 2.获取net信息
        NetworkInfo info = manager.getActiveNetworkInfo();
        // 3.判断网络是否可用
        if (info != null&&info.isConnected()) {
            return true;
        } else {
            return false;
        }


    }
}
