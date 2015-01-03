package me.yuichi0301.pdfragment.sample;

import android.app.Activity;
import android.os.Bundle;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SampleFragment fragment = new SampleFragment();
        getFragmentManager().beginTransaction().add(android.R.id.content, fragment).commit();
    }

}
