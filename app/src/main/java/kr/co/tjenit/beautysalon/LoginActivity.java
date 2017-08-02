package kr.co.tjenit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends BaseActivity {

    boolean isWorkerMode = false;
    private android.widget.TextView modeTxt;
    private android.widget.Button loginbtn;
    private EditText idEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        bindViews();
        isWorkerMode = getIntent().getBooleanExtra("workerMode", false);
        Log.d("workerMode", isWorkerMode +"");

        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();
        loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent;
                if (isWorkerMode) {
                    String inputid = idEdit.getText().toString();

                    if (inputid.equals("admin")) {
                        myIntent = new Intent(mContext, AdminMainActivity.class);
                    }
                    else {
                        myIntent = new Intent(mContext, WorkerMainActivity.class);
                    }
                }
                else {
                    myIntent = new Intent(mContext, MainActivity.class);
                }
                startActivity(myIntent);
                finish();
                SelectLoginModeActivity.activity.finish();
                // 로그인모드 선택화면도 종료.
            }
        });
    }
    // 로그인 버튼을 누르면 메인엑티비티로 이동하도록 만든다.

    @Override
    public void setValues() {
        super.setValues();
        if (isWorkerMode) {
            // 직원로그인 버튼을 눌러서 들어왔다면
            modeTxt.setVisibility(View.VISIBLE);
            // 직원모드라고 적힌 텍스트뷰를 표시해라.
        }
        else {
            modeTxt.setVisibility(View.GONE);
            // 사라지게 하기
        }
    }
    // select로그인 모드에서 사용자로그인, 직원로그인을 눌르면 로그인화면으로 넘어가는데
    // 사용자로그인으로 들어가면 직원모드라는 텍스트를 없애도록 코딩함.

    @Override
    public void bindViews() {
        super.bindViews();
        this.loginbtn = (Button) findViewById(R.id.loginbtn);
        this.idEdit = (EditText) findViewById(R.id.idEdit);
        this.modeTxt = (TextView) findViewById(R.id.modeTxt);
    }
}
