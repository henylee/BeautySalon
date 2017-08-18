package kr.co.tjenit.beautysalon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import kr.co.tjenit.beautysalon.R;

public class SelectLoginModeActivity extends BaseActivity {

    private Button userLoginBtn;
    private Button workerLoginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_login_mode);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        userLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                intent.putExtra("직원모드", false);
                startActivity(intent);
            }
        });

        workerLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, LoginActivity.class);
                intent.putExtra("직원모드", true);
                startActivity(intent);
            }
        });

    }

    @Override
    public void setValues() {
        super.setValues();

    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.workerLoginbtn = (Button) findViewById(R.id.workerLoginbtn);
        this.userLoginBtn = (Button) findViewById(R.id.userLoginBtn);
    }

}
