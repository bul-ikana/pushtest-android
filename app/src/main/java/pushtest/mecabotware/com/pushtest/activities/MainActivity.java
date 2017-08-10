package pushtest.mecabotware.com.pushtest.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.iid.FirebaseInstanceId;

import pushtest.mecabotware.com.pushtest.adapters.AnimalListAdapter;
import pushtest.mecabotware.com.pushtest.R;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private AnimalListAdapter adapter;
    private String[] values = new String[] {
            "Cat",
            "Cow",
            "Dog",
            "Duck",
            "Pig",
    };

    private TextView tokentxt;

    private int[] images = new int[] {
            R.drawable.cat,
            R.drawable.cow,
            R.drawable.dog,
            R.drawable.duck,
            R.drawable.pig,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        adapter = new AnimalListAdapter(this, values, images);

        listView.setAdapter(adapter);

        tokentxt = (TextView) findViewById(R.id.tokentxt);
        tokentxt.setText(FirebaseInstanceId.getInstance().getToken());
        Log.i("FCM", FirebaseInstanceId.getInstance().getToken());


    }
}
