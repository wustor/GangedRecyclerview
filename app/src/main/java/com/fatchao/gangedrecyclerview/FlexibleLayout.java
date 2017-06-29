package com.fatchao.gangedrecyclerview;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


/**
 * author pangchao
 * created on 2017/5/20
 * email fat_chao@163.com.
 */

public abstract class FlexibleLayout extends LinearLayout {
    private View mLoadingView;
    private View mNetworkErrorView;
    private View mEmptyView;
    private ViewGroup mSuccessView;
    private ProgressBar mLoadingProgress;
    private TextView mLoadingText;
    private View title;


    public FlexibleLayout(Context context) {
        super(context);
        setOrientation(VERTICAL);
        setClipToPadding(true);
        setFitsSystemWindows(true);
        inflate(context, R.layout.layout_all, this);
        mSuccessView = initNormalView();
        title = mSuccessView.findViewWithTag("title");
        LayoutParams lp = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        addView(mSuccessView, lp);
        int childCount = mSuccessView.getChildCount();
        Log.d("count---", String.valueOf(childCount));
    }

    public abstract ViewGroup initNormalView();

    public void loadData() {
        showPageWithState(State.Loading);
        onLoad();
    }

    public abstract void onLoad();

    public void showPageWithState(State status) {
        if (status != State.Normal && title != null) {
            String tag = (String) getChildAt(0).getTag();
            if (TextUtils.equals(tag, "title")) {
                //已经有标题栏
            } else {
                mSuccessView.removeView(title);
                addView(title, 0);
            }

        }
        switch (status) {
            case Normal:
                mSuccessView.setVisibility(VISIBLE);
                int childCount = getChildCount();
                Log.d("count--->", String.valueOf(childCount));
                View childAt = mSuccessView.getChildAt(0);//有可能为空
                if (childAt != null) {
                    String tag = (String) childAt.getTag();
                    if (!TextUtils.equals(tag, "title") && null != title) {
                        removeView(title);
                        mSuccessView.addView(title, 0);
                    }
                }
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }
                invalidate();
                break;
            case Loading:
                mSuccessView.setVisibility(GONE);
                if (mEmptyView != null) {
                    mEmptyView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }
                if (mLoadingView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.vs_loading);
                    mLoadingView = viewStub.inflate();
                    mLoadingProgress = (ProgressBar) mLoadingView.findViewById(R.id.loading_progress);
                    mLoadingText = (TextView) mLoadingView.findViewById(R.id.loading_text);
                } else {
                    mLoadingView.setVisibility(VISIBLE);
                }
                mLoadingProgress.setVisibility(View.VISIBLE);
                mLoadingText.setText("正在加载");
                break;
            case Empty:
                mSuccessView.setVisibility(GONE);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mNetworkErrorView != null) {
                    mNetworkErrorView.setVisibility(GONE);
                }

                if (mEmptyView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.vs_end);
                    mEmptyView = viewStub.inflate();
                } else {
                    mEmptyView.setVisibility(VISIBLE);
                }
                break;
            case NetWorkError:
                mSuccessView.setVisibility(GONE);
                if (mLoadingView != null) {
                    mLoadingView.setVisibility(GONE);
                }

                if (mEmptyView != null) {
                    mEmptyView.setVisibility(GONE);
                }

                if (mNetworkErrorView == null) {
                    ViewStub viewStub = (ViewStub) findViewById(R.id.vs_error);
                    mNetworkErrorView = viewStub.inflate();
                    View btnRetry = mNetworkErrorView.findViewById(R.id.btn_retry);
                    btnRetry.setOnClickListener(new OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            onLoad();
                        }
                    });

                } else {
                    mNetworkErrorView.setVisibility(VISIBLE);
                }
                break;
            default:
                break;
        }
    }

    public enum State {
        Normal, Empty, Loading, NetWorkError
    }

}
