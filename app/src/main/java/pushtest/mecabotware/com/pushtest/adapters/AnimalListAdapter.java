package pushtest.mecabotware.com.pushtest.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pushtest.mecabotware.com.pushtest.R;

public class AnimalListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] itemname;
    private final int[] imgid;
    private OkHttpClient client;

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
            client = new OkHttpClient();

            Button btn = view.findViewById(R.id.elementButton);
            btn.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    final ProgressDialog pd = new ProgressDialog(context);;
                    pd.setMessage("Enviando...");
                    pd.setCancelable(false);
                    pd.setIndeterminate(true);
                    pd.show();

                    String animal = "";

                    switch (position) {
                        case 0: animal = "cat";    break;
                        case 1: animal = "cow";    break;
                        case 2: animal = "dog";    break;
                        case 3: animal = "duck";   break;
                        case 4: animal = "pig";    break;
                    }

                    HttpUrl url = HttpUrl.parse(context.getResources().getString(R.string.url))
                            .newBuilder()
                            .addQueryParameter("animal", animal)
                            .addQueryParameter("token", FirebaseInstanceId.getInstance().getToken())
                            .build();

                    Request request = new Request.Builder()
                            .url(url)
                            .build();

                    client.newCall(request).enqueue(new Callback() {
                        @Override public void onFailure(Call call, IOException e) {
                            e.printStackTrace();
                        }

                        @Override
                        public void onResponse(Call call, final Response response) throws IOException {
                            if (response.code() == 200) {
                                context.runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(context, "Notification sent" , Toast.LENGTH_SHORT).show();
                                        pd.dismiss();
                                    }
                                });
                            }
                        }
                    });
                }
            });
        }

        return view;
    }
}
