package com.atasoyh.marvelapidemoproject.ui.comics;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.atasoyh.marvelapidemoproject.R;
import com.atasoyh.marvelapidemoproject.model.Comic;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atasoyh on 30/06/2017.
 */

public class ComicListAdapter extends RecyclerView.Adapter<ComicListAdapter.ViewHolder> {

    List<Comic> comicList;
    OnItemClickListener onItemClickListener;

    public ComicListAdapter(List<Comic> comicList) {
        this.comicList = comicList;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_comic, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Comic item = getItem(position);
        holder.tv.setText(item.getTitle());
        holder.simpleDraweeView.setImageURI(item.getThumbnail().getUrl());
        if (onItemClickListener != null)
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(item);
                }
            });
    }

    public Comic getItem(int position) {
        return comicList.get(position);
    }

    @Override
    public int getItemCount() {
        if (comicList == null) return 0;
        return comicList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tv)
        TextView tv;
        @BindView(R.id.sdv)
        SimpleDraweeView simpleDraweeView;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Comic item);
    }
}
