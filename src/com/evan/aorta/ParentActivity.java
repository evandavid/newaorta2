package com.evan.aorta;

import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Window;

public class ParentActivity extends Activity{
	protected Typeface type;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
    	requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.type = Typeface.createFromAsset(this.getAssets(),"Nexa.otf");
	}

}
