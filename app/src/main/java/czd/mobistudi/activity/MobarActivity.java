package czd.mobistudi.activity;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import czd.mobistudi.R;
import czd.mobistudi.circlerefresh.CircleRefreshLayout;

/**
 * Created by ChenZedong on 2017/10/2.
 */

public class MobarActivity extends AppCompatActivity {

    private CircleRefreshLayout mRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mobar_frgment_content);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }
}
