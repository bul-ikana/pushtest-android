package pushtest.mecabotware.com.pushtest.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pushtest.mecabotware.com.pushtest.R;

public class AnimalListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final int[] imgid;

    public AnimalListAdapter(Activity context, String[] itemname, int[] imgid) {
        super(context, R.layout.list_element, itemname);

        this.context=context;
        this.itemname=itemname;
        this.imgid = imgid;
    }

    public View getView(final int position,View view,ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.list_element, null, true);
            TextView txtTitle = view.findViewById(R.id.elementText);
            ImageView imageView = view.findViewById(R.id.elementIcon);
            txtTitle.setText(itemname[position]);
            imageView.setImageResource(imgid[position]);

            Button btn = view.findViewById(R.id.elementButton);
            btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    String toastText = "";

                    switch (position) {
                        case 0: toastText = "Meow!";    break;
                        case 1: toastText = "Moo!";     break;
                        case 2: toastText = "Woof!";    break;
                        case 3: toastText = "Quack!";   break;
                        case 4: toastText = "Oink!";    break;
                    }

                    Toast.makeText(context, toastText , Toast.LENGTH_SHORT).show();
                }
            });
        }

        return view;

    }
}
