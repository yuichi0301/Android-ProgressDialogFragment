package me.yuichi0301.sherlockpdfragmentsample;

import android.os.Bundle;

import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SampleFragment fragment = new SampleFragment();
        getSupportFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
    }

}
