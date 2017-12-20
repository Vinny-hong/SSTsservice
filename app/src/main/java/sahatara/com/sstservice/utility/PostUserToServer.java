package sahatara.com.sstservice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

/**
 * Created by sst on 12/19/2017.
 */

public class PostUserToServer extends AsyncTask<String,Void,String>{
    // is communicate  user to host
    private Context context;

    public PostUserToServer(Context context) {

        this.context = context;

    }


    @Override
    protected String doInBackground(String... strings) {

        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            RequestBody requestBody = new FormEncodingBuilder()
                    .add("isAdd", "true")
                    .add("Name", strings[0])
                    .add("User", strings[1])
                    .add("Password", strings[2])
                    .build();
            // label address
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[3]).post(requestBody).build();

            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();


        }catch (Exception e){
            e.printStackTrace();
            return null;
        }



    }

} //  Main class
