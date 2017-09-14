package licancan.com.comicdemo.mysql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by robot on 2017/8/19.
 */

public class MySql {

    private final MySqliteOpenHelper helper;

    public MySql(Context context) {
        helper = new MySqliteOpenHelper(context);
    }

    /**
     * 添加的方法
     */
    public void insert(String json)
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("json",json);
        db.insert("robot",null,values);

        db.close();

    }

    public String select()
    {
        SQLiteDatabase db = helper.getWritableDatabase();
        Cursor cursor = db.query("robot", null, null, null, null, null, null);
        while(cursor.moveToNext()) {
            String json = cursor.getString(0);
            return json;
        }
        return null;
    }
}
