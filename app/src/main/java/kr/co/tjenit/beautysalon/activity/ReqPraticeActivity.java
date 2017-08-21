package kr.co.tjenit.beautysalon.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import kr.co.tjenit.beautysalon.R;

public class ReqPraticeActivity extends BaseActivity {

    private android.widget.Button okBtn;
    private android.widget.EditText contentTxt;
    private SeekBar ratingSeekBar;
    private Button ratingBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_req_pratice);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        ratingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("선택된평점", ratingSeekBar.getProgress());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
        
        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("EditText", contentTxt.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
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

        this.ratingBtn = (Button) findViewById(R.id.ratingBtn);
        this.ratingSeekBar = (SeekBar) findViewById(R.id.ratingSeekBar);
        this.okBtn = (Button) findViewById(R.id.okBtn);
        this.contentTxt = (EditText) findViewById(R.id.contentTxt);
    }
}
