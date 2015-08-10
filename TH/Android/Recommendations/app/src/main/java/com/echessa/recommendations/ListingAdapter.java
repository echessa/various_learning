package com.echessa.recommendations;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.echessa.recommendations.model.ActiveListings;
import com.echessa.recommendations.model.Listing;
import com.squareup.picasso.Picasso;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by echessa on 7/25/15.
 */
public class ListingAdapter extends RecyclerView.Adapter<ListingAdapter.ListingHolder> implements Callback<ActiveListings> {

    private MainActivity mActivity;
    private LayoutInflater mInflater;
    private ActiveListings mActiveListings;

    public ListingAdapter(MainActivity activity) {
        mActivity = activity;
        mInflater = LayoutInflater.from(activity);
    }

    @Override
    public ListingHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ListingHolder(mInflater.inflate(R.layout.layout_listing, parent, false));
    }

    @Override
    public void onBindViewHolder(ListingHolder holder, int position) {
        final Listing listing = mActiveListings.results[position];
        holder.mTitleView.setText(listing.title);
        holder.mPriceView.setText(listing.price);
        holder.mShopNameView.setText(listing.Shop.shop_name);

        Picasso.with(holder.mImageView.getContext())
                .load(listing.Images[0].url_570xN)
                .into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        if (mActiveListings == null)
            return 0;

        if (mActiveListings.results == null)
            return 0;

        return mActiveListings.results.length;
    }

    @Override
    public void success(ActiveListings activeListings, Response response) {
        mActiveListings = activeListings;
        notifyDataSetChanged();
        mActivity.showList();
    }

    @Override
    public void failure(RetrofitError error) {
        mActivity.showError();
    }

    public ActiveListings getActiveListings() {
        return mActiveListings;
    }

    public class ListingHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTitleView;
        public TextView mShopNameView;
        public TextView mPriceView;

        public ListingHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.listing_image);
            mTitleView = (TextView)itemView.findViewById(R.id.listing_title);
            mShopNameView = (TextView)itemView.findViewById(R.id.listing_shop_name);
            mPriceView = (TextView)itemView.findViewById(R.id.listing_price);
        }
    }

}
