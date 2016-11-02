package com.example.kunyu.myyoubike;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.kunyu.myyoubike.databinding.ItemViewBinding;

import org.json.JSONException;
import org.json.JSONObject;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder> {
    private JSONObject mJSONObject;

    public JSONObject getJSONObject() {
        return mJSONObject;
    }

    public void setJSONObject(JSONObject JSONObject) {
        mJSONObject = JSONObject;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewBinding itemViewBinding = DataBindingUtil.inflate(
                LayoutInflater.from(parent.getContext()),
                R.layout.item_view,
                parent,
                false);
        return new ItemViewHolder(itemViewBinding);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        String zeroPadding = String.format("%04d", position);
        Log.i("LOG","zero padd = " + zeroPadding);
        try {
            JSONObject jsonObject = (JSONObject) mJSONObject.get(zeroPadding);
            holder.mItemViewBinding.text1.setText(jsonObject.getString("sna"));
            holder.mItemViewBinding.text2.setText(jsonObject.getString("ar"));
            holder.mItemViewBinding.text3.setText(jsonObject.getString("sbi"));
            holder.mItemViewBinding.text4.setText(jsonObject.getString("bemp"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        if(mJSONObject == null)
            return 0;
        else
            return mJSONObject.length();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        public ItemViewBinding mItemViewBinding;

        public ItemViewHolder(ItemViewBinding itemViewBinding) {
            super(itemViewBinding.getRoot());
            mItemViewBinding = itemViewBinding;
        }
    }
}
