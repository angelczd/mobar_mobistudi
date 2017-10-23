package czd.mobistudi.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import czd.mobistudi.R;
import czd.mobistudi.circlerefresh.CircleRefreshLayout;

/**
 * Created by thugwar on 2017/10/16.
 */

public class MobarFragment extends Fragment {
    private CircleRefreshLayout mRefreshLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mobar_frgment_content,container,false);

        mRefreshLayout = (CircleRefreshLayout) view.findViewById(R.id.refresh_layout);
        ListView mList = (ListView) view.findViewById(R.id.list);

        String[] strs = {
                "The", "Canvas", "class", "holds", "the", "draw", "calls", ".", "To",
                "draw", "something,", "you", "need", "4 basic", "components","Bitmap"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, strs);
        mList.setAdapter(adapter);

        mRefreshLayout.setOnRefreshListener(
                new CircleRefreshLayout.OnCircleRefreshListener() {
                    @Override
                    public void refreshing() {
                        // do something when refresh starts
                        new Handler().postDelayed(new Runnable() {
                            public void run() {
                                mRefreshLayout.finishRefreshing();
                            }
                        }, 2000);
                    }

                    @Override
                    public void completeRefresh() {
                        // do something when refresh complete
                        Toast.makeText(getContext(),"Refresh Complete",Toast.LENGTH_SHORT).show();
                    }
                });

        return view;
    }
}
