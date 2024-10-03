package DataBaseSystem;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.contact.Javabean.Record;
import com.example.contact.Javabean.User;

import java.util.ArrayList;
import java.util.List;

public class MySqliteOpenHelper extends SQLiteOpenHelper {
    private static final String dbName = "User_SQLite.db";
    private static final String dbCreate_User = "create table user(" +
            "account varchar(32)," +
            "password varchar(32)," +
            "name varchar(32)," +
            "sex integer," +
            "phone varchar(32)" +
            ")";
    private static final String dbCreate_Record = "create table record(" +
            "uid varchar(32)," +
            "id varchar(32)," +
            "title varchar(50)," +
            "context text," +
            "time varchar(32)" +
            ")";

    public MySqliteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(dbCreate_User);
        sqLiteDatabase.execSQL(dbCreate_Record);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    //点击注册按钮时，数据库进行插入操作
    public long Register(User u) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("account", u.getUserAccount());
        @SuppressLint("Recycle") Cursor cursor = db.query("user", null, "account like ?", new String[]{u.getUserAccount()}, null, null, null);
        if(cursor != null)
        {
            return -1;//用户名重复
        }
        cv.put("password", u.getUserPassword());
        cv.put("name", u.getUserName());
        cv.put("sex", u.getSex());
        cv.put("phone", u.getUserPhone());
        return db.insert("user",null, cv);
    }

    //点击登陆按钮时，数据库进行查询操作
    public boolean Login(String account, String password) {
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor u = db.query("user", null, "account like ?", new String[]{account}, null, null, null);
        if(u != null) {
            while (u.moveToNext()) {
                String ps = u.getString(1);
                return ps.equals(password);
            }
        }
        return false;
    }

    //显示备忘录列表的内容，读取数据库内容
    public List<Record> ShowRecord()
    {
        SQLiteDatabase db = getReadableDatabase();
        List<Record> toShowRecord = new ArrayList<>();
        @SuppressLint("Recycle") Cursor record = db.query("record", null, null, null, null, null, null);
        while (record.moveToNext())
        {
            toShowRecord.add(new Record(record.getString(0),record.getString(1),record.getString(2),record.getString(3),record.getString(4)));
        }
        return toShowRecord;
    }

    //删除备忘录，对数据库记录进行删除
    public void DeleteRecord(String uid, String id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete("record", "uid = ? and id = ?", new String[]{uid, id});
    }

    //保存备忘录信息，对数据库记录进行更新
    public void SaveRecord(Record record) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("title", record.getTitle());
        cv.put("context", record.getContext());
        cv.put("time", record.getTime());
        db.update("record", cv, "uid = ? and id = ?", new String[]{record.getUid(), record.getId()});
    }

}
