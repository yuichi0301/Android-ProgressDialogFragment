package me.yuichi0301.sherlockpdfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.actionbarsherlock.app.SherlockFragment;

/**
 * @author Yuichi Uchida
 */
public class SherlockProgressDialogFragment extends SherlockFragment {

    private TextView mProgressText;
    private View mProgressContainer;
    private View mContentContainer;
    private View mContentView;
    private boolean mContentShown;

    public SherlockProgressDialogFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_progress, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ensureContent();
    }

    @Override
    public void onDestroyView() {
        mContentShown = false;
        mContentView = null;
        mProgressContainer = mContentContainer = null;
        mProgressText = null;
        super.onDestroyView();
    }

    public View getContentView() {
        ensureContent();
        return mContentView;
    }

    public void setContentView(int layoutResId) {
        LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
        View contentView = layoutInflater.inflate(layoutResId, null);
        setContentView(contentView);
    }

    public void setContentView(View view) {
        ensureContent();
        if (view == null) {
            throw new IllegalArgumentException("Content view can't be null");
        }
        ViewGroup contentContainer = (ViewGroup) mContentContainer;
        if (mContentView == null) {
            contentContainer.addView(view);
        } else {
            int index = contentContainer.indexOfChild(mContentView);
            contentContainer.removeView(mContentView);
            contentContainer.addView(view, index);
        }
        mContentView = view;
    }

    public void setProgressText(int resId){
        setProgressText(getString(resId));
    }

    public void setProgressText(CharSequence text){
        ensureContent();
        if (mProgressText != null) {
            mProgressText.setText(text);
        } else {
            throw new IllegalStateException("Can't be used with a progress text view");
        }
    }

    public void setContentShown(boolean shown) {
        setContentShown(shown, true);
    }


    public void setContentShownNoAnimation(boolean shown) {
        setContentShown(shown, false);
    }


    private void setContentShown(boolean shown, boolean animate) {
        ensureContent();
        if (mProgressContainer == null) {
            throw new IllegalStateException("Can't be used with a custom content view");
        }
        if (mContentShown == shown) {
            return;
        }
        mContentShown = shown;
        if (shown) {
            if (animate) {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out));
            } else {
                mProgressContainer.clearAnimation();
            }
            mProgressContainer.setVisibility(View.GONE);
        } else {
            if (animate) {
                mProgressContainer.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));
            } else {
                mProgressContainer.clearAnimation();
            }
            mProgressContainer.setVisibility(View.VISIBLE);
        }
    }

    private void ensureContent() {
        if (mContentContainer != null && mProgressContainer != null) {
            return;
        }
        View root = getView();
        if (root == null) {
            throw new IllegalStateException("Content view not yet created");
        }
        mProgressContainer = root.findViewById(R.id.progress_container);
        mProgressContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        mContentContainer = root.findViewById(R.id.content_container);
        mProgressText = (TextView)root.findViewById(R.id.progress_text);
        mContentShown = true;
        if (mContentView == null) {
            setContentShown(false, false);
        }
    }
}
