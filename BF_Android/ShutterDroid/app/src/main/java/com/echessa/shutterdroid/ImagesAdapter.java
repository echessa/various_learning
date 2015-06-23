package com.echessa.shutterdroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.echessa.shutterdroid.shutterstock.Image;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by echessa on 6/23/15.
 */
public class ImagesAdapter extends RecyclerView.Adapter<ImagesAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView mImageView;

        public ViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView;
        }
    }

    private List<Image> mImages;
    private Context mContext;

    public ImagesAdapter(Context context, List<Image> images) {
        mContext = context;
        mImages = images;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grid_image, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Image image = mImages.get(position);
        Picasso.with(mContext)
                .load(image.getLargeThumbnail())
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

}
