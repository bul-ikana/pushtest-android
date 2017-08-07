package pushtest.mecabotware.com.pushtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.list);

        String[] values = new String[] {
                "Cat",
                "Cow",
                "Dog",
                "Duck",
                "Pig",
        };

        adapter = new ArrayAdapter<> (this, R.layout.list_element, R.id.elementText, values);

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
