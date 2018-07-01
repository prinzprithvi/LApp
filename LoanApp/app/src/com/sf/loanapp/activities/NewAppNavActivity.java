package com.sf.loanapp.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.sf.loanapp.R;
import com.sf.loanapp.fragments.ApplicantDetailsFragment;
import com.sf.loanapp.fragments.ApplicationDetailsFragment;
import com.sf.loanapp.fragments.VerificationFragment;
import com.sf.loanapp.springindicator.ModelPagerAdapter;
import com.sf.loanapp.springindicator.PagerModelManager;
import com.sf.loanapp.springindicator.SpringIndicator;
import com.sf.loanapp.springindicator.viewpager.ScrollerViewPager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NewAppNavActivity extends AppCompatActivity {

    ScrollerViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_app_nav);

        viewPager = (ScrollerViewPager) findViewById(R.id.view_pager);
        SpringIndicator springIndicator = (SpringIndicator) findViewById(R.id.indicator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        PagerModelManager manager = new PagerModelManager();
        //manager.addCommonFragment(GuideFragment.class, getBgRes(), getTitles());
        manager.addFragment(new ApplicationDetailsFragment(),"1");
        manager.addFragment(new VerificationFragment(),"2");
        manager.addFragment(new ApplicantDetailsFragment(),"3");
        manager.addFragment(new ApplicationDetailsFragment(),"4");
        ModelPagerAdapter adapter = new ModelPagerAdapter(getSupportFragmentManager(), manager);
        viewPager.setAdapter(adapter);
        viewPager.fixScrollSpeed();

        // just set viewPager
        springIndicator.setViewPager(viewPager);

    }

    private List<String> getTitles(){
        return new ArrayList<String>(Arrays.asList("1", "2", "3", "4"));

    }

    private List<Integer> getBgRes(){
        return new ArrayList<Integer>(Arrays.asList(R.drawable.bg1, R.drawable.bg2, R.drawable.bg3, R.drawable.bg4));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        /*if (id == R.id.action_about) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

}
