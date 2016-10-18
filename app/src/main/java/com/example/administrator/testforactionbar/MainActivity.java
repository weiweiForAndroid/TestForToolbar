package com.example.administrator.testforactionbar;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author xuweiwei
 */
public class MainActivity extends AppCompatActivity {


  @BindView(R.id.toolbar)
  Toolbar toolbar;
  @BindView(R.id.recyclerView)
  RecyclerView recyclerView;
  @BindView(R.id.main_fab)
  FloatingActionButton mainFab;
  @BindView(R.id.backdrop)
  ImageView backdrop;
  @BindView(R.id.collapsing_toolbar)
  CollapsingToolbarLayout collapsingToolbar;
  @BindView(R.id.app_bar_layout)
  AppBarLayout appBarLayout;
  @BindView(R.id.activity_main)
  CoordinatorLayout activityMain;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    setSupportActionBar(toolbar);
    recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(new RecyclerViewAdapter());
    mainFab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Snackbar.make(v, "知道了", Snackbar.LENGTH_INDEFINITE)
          .setAction("真的知道了", new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
          }).show();
      }
    });
    collapsingToolbar.setTitle("toolbar系列操作");
    collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBar);
    collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBar);
    collapsingToolbar.setExpandedTitleTextAppearance(R.style.ExpandedAppBarPlus1);
    collapsingToolbar.setCollapsedTitleTextAppearance(R.style.CollapsedAppBarPlus1);
    ActionBar bar = getSupportActionBar();
    bar.setHomeAsUpIndicator(R.drawable.ic_menu);
    bar.setDisplayHomeAsUpEnabled(true);
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }

  class RecyclerViewAdapter extends RecyclerView.Adapter {

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View v = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.item, parent, false);
      return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
      MyViewHolder viewHolder = (MyViewHolder) holder;
      viewHolder.textView.setText("测试");
    }

    @Override
    public int getItemCount() {
      return 1000;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
      @BindView(R.id.textView)
      TextView textView;

      public MyViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
      }
    }
  }
}
