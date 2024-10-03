package DataBaseSystem;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.contact.Javabean.Record;
import com.example.contact.R;

import java.util.List;

public class RecordAdapter extends ArrayAdapter<Record> {

    private List<Record> records;

    //TODO:id等待修改为对应文本框id
    public RecordAdapter(Context context, List<Record> records) {
        super(context, R.layout.activity_main, records);
        this.records = records;
    }

    //显示备忘录列表的内容
    public View GetView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.activity_main, parent, false);
        }
        //TODO:id等待修改为对应文本框id
        TextView title = convertView.findViewById(R.id.txt_id);
        TextView context = convertView.findViewById(R.id.txt_id);
        TextView time = convertView.findViewById(R.id.txt_id);

        Record record = records.get(position);
        title.setText(record.getTitle());
        context.setText(record.getContext());
        time.setText(record.getTime());

        return convertView;
    }


}
