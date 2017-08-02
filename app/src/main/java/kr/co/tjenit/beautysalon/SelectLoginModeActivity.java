package kr.co.tjenit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Set;

public class SelectLoginModeActivity extends BaseActivity {

    public static SelectLoginModeActivity activity;
    // 어느 클래스나 접근가능
    // 객체화 하지 않아도 접근 가능하게
    // 자료형 자체한테 접근허가 하려고.

    private android.widget.Button userLoginBtn;
    private android.widget.Button workerLoginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_mode);
        activity = this;
        bindViews();
        setupEvents();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // userlogicbtn이 눌리면 실행될 일
                Intent myIntent = new Intent(mContext, LoginActivity.class);
                myIntent.putExtra("workerMode", false);
                startActivity(myIntent);
            }
        });

        workerLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, LoginActivity.class);
                myIntent.putExtra("workerMode", true);
                startActivity(myIntent);
            }
        });

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.workerLoginbtn = (Button) findViewById(R.id.workerLoginbtn);
        this.userLoginBtn = (Button) findViewById(R.id.userLoginBtn);
    }
}
