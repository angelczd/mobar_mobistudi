package czd.mobistudi.activity;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import czd.mobistudi.R;
import czd.mobistudi.fragment.FirstRecyclerViewFragment;
import czd.mobistudi.fragment.RecyclerViewFragment;

/**
 * Created by ChenZedong on 2017/10/2.
 */

public class MobarActivity extends AppCompatActivity {

    private MaterialViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acticity_mobar);
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager);

        Toolbar toolbar = mViewPager.getToolbar();
        if (toolbar != null) {
            setSupportActionBar(toolbar);

            ActionBar actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
//            actionBar.setHomeAsUpIndicator(R.drawable.......);
            actionBar.setDisplayShowTitleEnabled(false);
            actionBar.setDisplayUseLogoEnabled(false);
            actionBar.setHomeButtonEnabled(true);
        }

        mViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {

            @Override
            public Fragment getItem(int position) {
                switch (position % 4) {
                    case 0:
                        return FirstRecyclerViewFragment.newInstance();
                    //case 1:
                    //    return FirstRecyclerViewFragment.newInstance();
                    //case 2:
                    //    return WebViewFragment.newInstance();
                    default:
                        return RecyclerViewFragment.newInstance();
                }
            }

            @Override
            public int getCount() {
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position % 4) {
                    case 0:
                        return "Popular";
                    case 1:
                        return "Recommend";
                    case 2:
                        return "ALL";
                    case 3:
                        return "MyPosts";
                }
                return "";
            }
        });

        mViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                switch (page) {
                    case 0:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.green,
                                ResourcesCompat.getDrawable(getResources(),R.drawable.mobaar_header_pic1_640x400,null)
                                );
                    case 1:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.blue,
                                ResourcesCompat.getDrawable(getResources(),R.drawable.mobaar_header_pic2_600x400,null)
                                );
                    case 2:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.cyan,
                                ResourcesCompat.getDrawable(getResources(),R.drawable.mobaar_header_pic3_901x750,null)
                                );
                    case 3:
                        return HeaderDesign.fromColorResAndDrawable(
                                R.color.red,
                                ResourcesCompat.getDrawable(getResources(),R.drawable.mobaar_header_pic4_900x700,null)
                                );
                }

                //execute others actions if needed (ex : modify your header logo)

                return null;
            }
        });

        mViewPager.getViewPager().setOffscreenPageLimit(mViewPager.getViewPager().getAdapter().getCount());
        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());

        final View logo = findViewById(R.id.logo_white);
        if (logo != null) {
            logo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.notifyHeaderChanged();
                    Toast.makeText(getApplicationContext(), "The title is clickable", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}
