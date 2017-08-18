package kr.co.tjenit.beautysalon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.activity.user_activity.MainActivity;
import kr.co.tjenit.beautysalon.activity.worker_activity.WorkerMainActivity;

public class LoginActivity extends BaseActivity {

    boolean isWorkerMode = false; // 직원모드인지 아닌지 판별해주는 변수.

    private TextView modeTxt;
    private EditText idEdit;
    private Button loginbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        isWorkerMode = getIntent().getBooleanExtra("직원모드", false);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                if (isWorkerMode==true) {
                    intent = new Intent(mContext, WorkerMainActivity.class);
                }
                else {
                    intent = new Intent(mContext, MainActivity.class);
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void setValues() {
        super.setValues();
        if (isWorkerMode==true) {
            modeTxt.setVisibility(View.VISIBLE);
        }
        else {
            modeTxt.setVisibility(View.GONE);
        }
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.loginbtn = (Button) findViewById(R.id.loginbtn);
        this.idEdit = (EditText) findViewById(R.id.idEdit);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);
    }
}
