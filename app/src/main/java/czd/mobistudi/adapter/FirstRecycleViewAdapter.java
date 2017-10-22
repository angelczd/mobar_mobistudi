package czd.mobistudi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import czd.mobistudi.R;
import czd.mobistudi.activity.BlankActivity;
import czd.mobistudi.bean.HotCourse;

public class FirstRecycleViewAdapter extends RecyclerView.Adapter<FirstRecycleViewAdapter.MyViewHolder> {

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

    public FirstRecycleViewAdapter(List<Object> contents, boolean isGridLayout) {
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
        View mView;

        if (mContext == null) {
            mContext = parent.getContext();
        }

        switch (viewType) {
            case TYPE_HEADER:
                mView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.hot_courses_item_card_big, parent, false);
                break;
            case TYPE_CELL:
            default:
                mView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.hot_courses_item_card_small, parent, false);
                break;
        }

        final MyViewHolder mViewHolder = new MyViewHolder(mView);
        mViewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int position = mViewHolder.getAdapterPosition();
                //HotCourse hotCourse = mHotCourseList.get(position);
                Intent intent = new Intent(mContext, BlankActivity.class);
                //intent.putExtra(, hotCourse.getName());
                //intent.putExtra(, hotCourse.getImageId());
                mContext.startActivity(intent);

            }
        });

        return new MyViewHolder(mView);
    }

    @Override
    public void onBindViewHolder(FirstRecycleViewAdapter.MyViewHolder holder, int position) {
        HotCourse hotCourse;
        switch (getItemViewType(position)) {
            case TYPE_HEADER:
                hotCourse = (HotCourse)contents.get(position);
                holder.Name.setText(hotCourse.getName());
                Glide.with(mContext).load(hotCourse.getImageId()).into(holder.Image);
                break;
            case TYPE_CELL:default:
                hotCourse = (HotCourse)contents.get(position);
                holder.Name.setText(hotCourse.getName());
                Glide.with(mContext).load(hotCourse.getImageId()).into(holder.Image);
                break;
        }
    }
}