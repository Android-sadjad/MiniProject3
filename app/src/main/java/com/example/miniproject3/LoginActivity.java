package com.example.miniproject3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    TextView txtHeader;
    TextView partnerTxt;
    TextView poweredTxt;
    Button loginBtn;
    TextInputEditText editPhone,editPass;
    View loginView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final int WIDTH=getResources().getDisplayMetrics().widthPixels;
        final int HEIGHT=getResources().getDisplayMetrics().heightPixels;

        findViews();
        setLayoutParams(WIDTH,HEIGHT);
        config();


    }




    private void findViews() {

        loginView=findViewById(R.id.v_one_login);
        txtHeader =findViewById(R.id.tv_one_login);
        partnerTxt=findViewById(R.id.partner_string);
        poweredTxt=findViewById(R.id.powered_by);
        loginBtn=findViewById(R.id.btn_login);
        editPass=findViewById(R.id.ed_pass);
        editPhone=findViewById(R.id.et_phone);

    }

    private void setLayoutParams(int width , int height){

        loginView.setLayoutParams(new ConstraintLayout.LayoutParams(width,height/3));
    }

    private void config(){

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(evaluate()){

                    Animation buttonAnimation= AnimationUtils.loadAnimation(LoginActivity.this,R.anim.button_animation);
                    loginBtn.startAnimation(buttonAnimation);

                    startActivity(new Intent(LoginActivity.this,MainActivity.class));


                    finish();
                }
            }
        });

    }

    private boolean evaluate(){


        return true;

    }

}