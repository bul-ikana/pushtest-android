package pushtest.mecabotware.com.pushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

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
    }
}
