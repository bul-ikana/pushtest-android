package pushtest.mecabotware.com.pushtest;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

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

    public View getView(int position,View view,ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            view = inflater.inflate(R.layout.list_element, null, true);
            TextView txtTitle = view.findViewById(R.id.elementText);
            ImageView imageView = view.findViewById(R.id.elementIcon);
            txtTitle.setText(itemname[position]);
            imageView.setImageResource(imgid[position]);
        }

        return view;

    }
}
