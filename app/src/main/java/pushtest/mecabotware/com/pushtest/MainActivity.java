package pushtest.mecabotware.com.pushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;



//<div>Icons made by <a href="http://www.freepik.com" title="Freepik">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon">www.flaticon.com</a> is licensed by <a href="http://creativecommons.org/licenses/by/3.0/" title="Creative Commons BY 3.0" target="_blank">CC 3.0 BY</a></div>

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String toastText = "";

                switch (position) {
                    case 0: toastText = "Meow!";    break;
                    case 1: toastText = "Moo!";     break;
                    case 2: toastText = "Woof!";    break;
                    case 3: toastText = "Quack!";   break;
                    case 4: toastText = "Oink!";    break;
                }

                Toast.makeText(getApplicationContext(), toastText , Toast.LENGTH_SHORT).show();

            }
        });
    }
}
