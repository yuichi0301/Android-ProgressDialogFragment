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
