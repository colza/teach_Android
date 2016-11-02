package com.example.kunyu.myyoubike;

import android.databinding.DataBindingUtil;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.example.kunyu.myyoubike.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mActivityMainBinding;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mActivityMainBinding.header.text1.setText("站名");
        mActivityMainBinding.header.text2.setText("地址");
        mActivityMainBinding.header.text3.setText("可用車輛");
        mActivityMainBinding.header.text4.setText("可還空位");


        mRecyclerViewAdapter = new RecyclerViewAdapter();

        mActivityMainBinding.recyclerView.setAdapter(mRecyclerViewAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mActivityMainBinding.recyclerView.setLayoutManager(linearLayoutManager);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,
                linearLayoutManager.getOrientation());
        mActivityMainBinding.recyclerView.addItemDecoration(dividerItemDecoration);

        String url = "http://data.taipei/youbike";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String responseStr = response.body().string();
                try {
                    JSONObject jsonObject = new JSONObject(responseStr);
                    JSONObject retVal = jsonObject.getJSONObject("retVal");
                    mRecyclerViewAdapter.setJSONObject(retVal);

                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mRecyclerViewAdapter.notifyDataSetChanged();
                        }
                    });
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
