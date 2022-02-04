package com.feiyu.rv;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class GangedRvActivity extends AppCompatActivity implements CheckListener {

  private RecyclerView rvSort;
  private SortAdapter mSortAdapter;
  private SortDetailFragment mSortDetailFragment;
  private Context mContext;
  private LinearLayoutManager mLinearLayoutManager;
  private int targetPosition;//点击左边某一个具体的item的位置
  private boolean isMoved;
  private SortBean mSortBean;
  private String TAG = "GangedRvActivity";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_ganged_rv);
    mContext = this;
    initView();
    initData();
  }


  private void initData() {
    Bundle extras = getIntent().getExtras();
    mSortBean = (SortBean) extras.getSerializable(IIntent.DATA_TAG);
    List<SortBean.CategoryOneArrayBean> categoryOneArray = mSortBean.getCategoryOneArray();
    List<String> list = new ArrayList<>();
    //初始化左侧列表数据
    for (int i = 0; i < categoryOneArray.size(); i++) {
      list.add(categoryOneArray.get(i).getName());
    }
    mSortAdapter = new SortAdapter(mContext, list, new RvListener() {
      @Override
      public void onItemClick(int id, int position) {
        if (mSortDetailFragment != null) {
          isMoved = true;
          targetPosition = position;
          setChecked(position, true);
        }
      }
    });
    rvSort.setAdapter(mSortAdapter);
    createFragment();
  }

  public void createFragment() {
    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
    mSortDetailFragment = new SortDetailFragment();
    Bundle bundle = new Bundle();
    bundle.putSerializable(IIntent.DATA_RIGHT, mSortBean.getCategoryOneArray());
    mSortDetailFragment.setArguments(bundle);
    mSortDetailFragment.setListener(this);
    fragmentTransaction.add(R.id.lin_fragment, mSortDetailFragment);
    fragmentTransaction.commit();
  }

  private void setChecked(int position, boolean isLeft) {
    Log.d(TAG + "-------->p", String.valueOf(position));
    if (isLeft) {
      mSortAdapter.setCheckedPosition(position);
      //此处的位置需要根据每个分类的集合来进行计算
      int count = 0;
      for (int i = 0; i < position; i++) {
        count += mSortBean.getCategoryOneArray().get(i).getCategoryTwoArray().size();
      }
      count += position;
      mSortDetailFragment.setData(count);
      ItemHeaderDecoration.setCurrentTag(String.valueOf(targetPosition));//凡是点击左边，将左边点击的位置作为当前的tag
    } else {
      if (isMoved) {
        isMoved = false;
      }
      mSortAdapter.setCheckedPosition(position);
      ItemHeaderDecoration.setCurrentTag(String.valueOf(position));//如果是滑动右边联动左边，则按照右边传过来的位置作为tag

    }
    moveToCenter(position);

  }

  //将当前选中的item居中
  private void moveToCenter(int position) {
    //将点击的position转换为当前屏幕上可见的item的位置以便于计算距离顶部的高度，从而进行移动居中
    View childAt = rvSort
        .getChildAt(position - mLinearLayoutManager.findFirstVisibleItemPosition());
    if (childAt != null) {
      int y = (childAt.getTop() - rvSort.getHeight() / 2);
      rvSort.smoothScrollBy(0, y);
    }

  }


  private void initView() {
    rvSort = (RecyclerView) findViewById(R.id.rv_sort);
    mLinearLayoutManager = new LinearLayoutManager(mContext);
    rvSort.setLayoutManager(mLinearLayoutManager);
    DividerItemDecoration decoration = new DividerItemDecoration(mContext,
        DividerItemDecoration.VERTICAL);
    rvSort.addItemDecoration(decoration);

  }


  @Override
  public void check(int position, boolean isScroll) {
    setChecked(position, isScroll);

  }
}
