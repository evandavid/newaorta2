package com.evan.aorta;

import com.evan.aorta.utils.CustomButton;
import com.evan.aorta.utils.CustomEditText;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;

public class LoginActivity extends ParentActivity {
    @SuppressWarnings("unused")
	private CustomEditText usernameLogin, passwordLogin, usernameRegister, emailRegister, passwordRegister;
    @SuppressWarnings("unused")
	private CustomButton btnLogin, btnRegister, btnLoginFooter, btnRegisterFooter;
    private RelativeLayout loginBox, registerBox;
    private Animation anim1, anim2, anim3, anim4;
    private boolean isLogin, isRegister;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.isLogin = false;
        this.isRegister = true;
        initComponents();
    }
    
    public void initComponents(){
    	this.usernameLogin = (CustomEditText)findViewById(R.id.username);
        this.passwordLogin = (CustomEditText)findViewById(R.id.password);
        this.btnLogin = (CustomButton)findViewById(R.id.button);
        this.usernameRegister = (CustomEditText)findViewById(R.id.usernameRegister);
        this.passwordRegister = (CustomEditText)findViewById(R.id.passwordRegister);
        this.emailRegister = (CustomEditText)findViewById(R.id.emailRegister);
        this.btnRegister = (CustomButton)findViewById(R.id.buttonRegister);
        this.btnRegisterFooter = (CustomButton)findViewById(R.id.btnRegister);
        this.btnLoginFooter = (CustomButton)findViewById(R.id.btnLogin);
        this.loginBox = (RelativeLayout)findViewById(R.id.login);
        this.registerBox = (RelativeLayout)findViewById(R.id.register);
        //set on click listener
        this.btnLoginFooter.setOnClickListener(loginFooterOnClick);
        this.btnRegisterFooter.setOnClickListener(registerFooterOnClick);
        //animation
        this.initAnimation();
    }
    
    public void initAnimation(){
    	this.anim1 = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        this.anim1.setDuration(400);
        this.anim1.setAnimationListener(new Animation.AnimationListener(){
    	    @Override
    	    public void onAnimationStart(Animation arg0) {}           
    	    @Override
    	    public void onAnimationRepeat(Animation arg0) {}           
    	    @Override
    	    public void onAnimationEnd(Animation arg0) {
    	    	registerBox.setVisibility(View.GONE);
    	    	loginBox.setVisibility(View.VISIBLE);
    	    	loginBox.startAnimation(anim2);
    	    }
    	});
        this.anim2 = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        this.anim2.setDuration(400);
        this.anim3 = AnimationUtils.loadAnimation(this, R.anim.slide_down2);
        this.anim3.setDuration(400);
        this.anim3.setAnimationListener(new Animation.AnimationListener(){
    	    @Override
    	    public void onAnimationStart(Animation arg0) {}           
    	    @Override
    	    public void onAnimationRepeat(Animation arg0) {}           
    	    @Override
    	    public void onAnimationEnd(Animation arg0) {
    	    	loginBox.setVisibility(View.GONE);
    	    	registerBox.setVisibility(View.VISIBLE);
    	    	registerBox.startAnimation(anim4);
    	    }
    	});
        this.anim4 = AnimationUtils.loadAnimation(this, R.anim.slide_up2);
        this.anim4.setDuration(400);
    }
    
    View.OnClickListener loginFooterOnClick = new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			if(isLogin){
				btnRegisterFooter.setBackgroundColor(Color.parseColor("#096BC9"));
				btnLoginFooter.setBackground(getResources().getDrawable(R.drawable.active));		
				registerBox.startAnimation(anim1);
				isLogin = false;
				isRegister = true;
			}
		}
	};
	
	
	View.OnClickListener registerFooterOnClick = new View.OnClickListener() {
		@Override
		public void onClick(View arg0) {
			if(isRegister){
				btnLoginFooter.setBackgroundColor(Color.parseColor("#096BC9"));
				btnRegisterFooter.setBackground(getResources().getDrawable(R.drawable.active));
				loginBox.startAnimation(anim3);
				isRegister = false;
				isLogin = true;
			}
		}
	};
    
    @Override
    public void onResume(){
    	super.onResume();
    }
    
}
