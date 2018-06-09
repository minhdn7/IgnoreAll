package com.mkit.ignoreall.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.mkit.ignoreall.R;
import com.mkit.ignoreall.app.LineApplication;
import com.mkit.ignoreall.app.model.MoreAppModel;
import com.mkit.ignoreall.ui.adapter.MoreAppAdapter;

import org.greenrobot.eventbus.EventBus;

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
        if(isConnectedNetwork()){
            showProgressBar();
            getDataFireBase();
        }else{
            showDialogCheckInternet(getString(R.string.str_no_internet));
        }
        initData();
    }

    private void initData() {
//        moreAppModelList = new ArrayList<>();
//        for(int i = 0; i < 14; i++){
//            MoreAppModel model = new MoreAppModel(String.valueOf(i), "more app click me", "");
//            moreAppModelList.add(model);
//        }
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

    public void showDialogCheckInternet(String contentDialog) {
        MaterialDialog dialog = new MaterialDialog.Builder(this).title(R.string.str_thong_bao).content(contentDialog).positiveText(R.string.str_reload).dismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        }).show();
    }

    public void getDataFireBase() {
        moreAppModelList = new ArrayList<>();
        Firebase.setAndroidContext(this);
        Firebase firebaseRef = new Firebase(LineApplication.apiFireBaseUrl);
        firebaseRef.child("danh sach app").addValueEventListener(new com.firebase.client.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                hideProgressBar();
                if(dataSnapshot.getChildren() != null){
                    for(DataSnapshot danhSachApp : dataSnapshot.getChildren()){
                        MoreAppModel moreAppModel = new MoreAppModel();
                        if(danhSachApp.child("id") != null && danhSachApp.child("id").getValue() != null) {
                            moreAppModel.setId(danhSachApp.child("id").getValue().toString());
                        }
                        if(danhSachApp.child("name") != null && danhSachApp.child("name").getValue() != null) {
                            moreAppModel.setName(danhSachApp.child("name").getValue().toString());
                        }
                        if(danhSachApp.child("url") != null && danhSachApp.child("url").getValue() != null) {
                            moreAppModel.setUrl(danhSachApp.child("url").getValue().toString());
                        }
                        moreAppModelList.add(moreAppModel);
                    }
                    moreAppAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
                hideProgressBar();
                Toast.makeText(MoreAppActivity.this, "errorr", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
