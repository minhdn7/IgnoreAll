package com.mkit.ignoreall.ui.activity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;

import com.mkit.ignoreall.R;
import com.mkit.ignoreall.app.model.MoreAppModel;
import com.mkit.ignoreall.ui.adapter.MoreAppAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MoreAppActivity extends BaseActivity {
    private List<MoreAppModel> moreAppModelList;
    private MoreAppAdapter moreAppAdapter;
    @BindView(R.id.gridView)
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_app);
        ButterKnife.bind(this);
        setTitle(getString(R.string.title_activity_more_app));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initData();
    }

    private void initData() {
        moreAppModelList = new ArrayList<>();
        for(int i = 0; i < 14; i++){
            MoreAppModel model = new MoreAppModel(i, "more app click me", "");
            moreAppModelList.add(model);
        }
        moreAppAdapter = new MoreAppAdapter(this, R.layout.custom_item_more_app, moreAppModelList);
        gridView.setAdapter(moreAppAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
