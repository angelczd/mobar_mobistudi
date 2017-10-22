package czd.mobistudi.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import czd.mobistudi.R;

public class FirstViewAdapter extends RecyclerView.Adapter<FirstViewAdapter.MyViewHolder> {

    private List<Object> contents;
    private Context mContext;

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_CELL = 1;
    private boolean isGridLayout = false;

    static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;

        ImageView Image;
        TextView Name;

        MyViewHolder(View view) {
        super(view);
        cardView = (CardView) view;
        Image = (ImageView) view.findViewById(R.id.hot_course_image);
        Name = (TextView) view.findViewById(R.id.hot_course_name);
        }
    }

    public FirstViewAdapter(List<Object> contents, boolean isGridLayout) {
        this.contents = contents;
        this.isGridLayout = isGridLayout;
    }

    @Override
    public int getItemViewType(int position) {
        if(isGridLayout){
            switch (position) {
                case 0:case 1:
                    return TYPE_HEADER;
                default:
                    return TYPE_CELL;
            }
        }else{
            switch (position) {
                case 0:
                    return TYPE_HEADER;
                default:
                    return TYPE_CELL;
            }
        }
    }

    @Override
    public int getItemCount() {
        return contents.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view;

        if (mContext == null) {
            mContext = parent.getContext();
        }

        switch (viewType) {
            case TYPE_HEADER: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.hot_courses_item_card_big, parent, false);
                return new MyViewHolder(view) {
                };
            }
            case TYPE_CELL: {
                view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.hot_courses_item_card_small, parent, false);
                return new MyViewHolder(view) {
                };
            }
        }
        return null;
    }


    @Override
    public void onBindViewHolder(FirstViewAdapter.MyViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                break;
            case TYPE_CELL:
                break;
        }
    }
}