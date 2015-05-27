package com.echessa.sounddroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.echessa.sounddroid.soundcloud.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by echessa on 5/25/15.
 */
public class TracksAdapter extends RecyclerView.Adapter<TracksAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final TextView titleTextView;
        private final ImageView thumbImageView;

        ViewHolder(View v) {
            super(v);
            titleTextView = (TextView)v.findViewById(R.id.track_title);
            thumbImageView = (ImageView)v.findViewById(R.id.track_thumbnail);
        }

        @Override
        public void onClick(View v) {
            if (mOnItemClickListener != null) {
                mOnItemClickListener.onItemClick(null, v, getAdapterPosition(), 0);
            }
        }
    }

    private List<Track> mTracks;
    private Context mContext;
    private AdapterView.OnItemClickListener mOnItemClickListener;

    TracksAdapter(Context context, List<Track> tracks) {
        mContext = context;
        mTracks = tracks;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.track_row, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        Track track = mTracks.get(i);
        viewHolder.titleTextView.setText(track.getTitle());
        Picasso.with(mContext).load(track.getAvatarURL()).into(viewHolder.thumbImageView);
    }

    @Override
    public int getItemCount() {
        return mTracks.size();
    }
}
