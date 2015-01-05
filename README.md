Android-ProgressDialogFragment
==============================
Sample
------
![Example image](https://raw.github.com/YuichiUchida/Android-ProgressDialogFragment/master/example.png)

Usage
-----

``` java
public class SampleFragment extends ProgressDialogFragment {
	// your code of fragment
}
```

or if you use [ActionBarSherlock](https://github.com/JakeWharton/ActionBarSherlock)

``` java
public class SampleFragment extends SherlockProgressDialogFragment {
	// your code of fragment
}
```

* Display of indeterminate progress indicator

``` java
setContentShown(false);
```

Gradle
------

ProgressDialogFragment (support-v4):
``` xml
dependencies {
    compile 'me.yuichi0301:pdfragment:1.1.+'
}
```

ProgressDialogFragment (native):
``` xml
dependencies {
    compile 'me.yuichi0301:pdfragment-native:1.1.+'
}
```

SherlockProgressDialogFragment:
``` xml
dependencies {
    compile 'com.android.support:support-v4:21.0.3'
    compile('me.yuichi0301:sherlockpdfragment:1.1.+') {
        exclude module: 'support-v4'
    }
}
```