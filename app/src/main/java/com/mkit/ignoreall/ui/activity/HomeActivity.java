package com.mkit.ignoreall.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.folioreader.Config;
import com.folioreader.FolioReader;
import com.folioreader.Font;
import com.folioreader.model.HighLight;
import com.folioreader.model.ReadPosition;
import com.folioreader.util.OnHighlightListener;
import com.folioreader.util.ReadPositionListener;
import com.mkit.ignoreall.R;
import com.mkit.ignoreall.app.model.CatalogModel;
import com.mkit.ignoreall.ui.adapter.CatalogAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HomeActivity extends BaseActivity implements OnHighlightListener, ReadPositionListener {

    @BindView(R.id.rcvDanhSach)
    RecyclerView rcvDanhSach;

    @BindView(R.id.container)
    RelativeLayout container;
    private TextView mTextMessage;
    private FolioReader folioReader;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<CatalogModel> dataList;
    private CatalogAdapter catalogAdapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        initControls();
        initData();
    }

    private void initData() {
        dataList = new ArrayList<>();
        CatalogModel item1 = new CatalogModel(1, "Phớt lờ tất cả - bơ đi mà sống", "Cái giá của việc làm Cừu là nhàm chán. Cái giá của việc làm Sói là cô đơn. Làm cừu hay làm sói, hãy cân nhắc kỹ đi!\n" +
                "\n" +
                "Quyển sách dành cho những ai mang trong mình một niềm đam mê sáng tạo chưa đủ can đảm khám phá!", R.mipmap.book_4);
        CatalogModel item2 = new CatalogModel(1, "Những quấn sách thay đổi cuộc đời", "Những quấn sách thay đổi cuộc đời", R.mipmap.gate_world);
        dataList.add(item1);
        dataList.add(item2);

        catalogAdapter = new CatalogAdapter(this, dataList, this);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rcvDanhSach.setLayoutManager(mLayoutManager);
        rcvDanhSach.setItemAnimator(new DefaultItemAnimator());
        rcvDanhSach.setAdapter(catalogAdapter);


    }

    private void initControls() {
        folioReader = FolioReader.getInstance(getApplicationContext())
                .setOnHighlightListener(this)
                .setReadPositionListener(this);
//        findViewById(R.id.btn_assest).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                folioReader.openBook("file:///android_asset/phot_lo_tat_ca_bo_di_ma_song.epub");
//
//            }
//        });
    }

    @Override
    public void onHighlight(HighLight highlight, HighLight.HighLightAction type) {

    }

    @Override
    public void saveReadPosition(ReadPosition readPosition) {

    }

    public void showDataEbook(){
        Config config = new Config.ConfigBuilder()
                .nightmode(true)
                .fontSize(1)
                .setShowTts(true)
//                .font(Font.ANDADA)
                .themeColor(R.color.grey_color)
                .build();

        folioReader.openBook("file:///android_asset/phot_lo_tat_ca_bo_di_ma_song.epub", config);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        // return true so that the menu pop up is opened
        return true;
    }
}
