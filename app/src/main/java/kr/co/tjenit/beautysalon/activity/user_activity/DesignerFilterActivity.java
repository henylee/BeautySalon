package kr.co.tjenit.beautysalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.Locale;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.activity.BaseActivity;

public class DesignerFilterActivity extends BaseActivity {

    private android.widget.ToggleButton manSelectToggleBtn;
    private android.widget.ToggleButton womanSelectToggleBtn;
    private android.widget.Button okBtn;
    private android.widget.TextView minRatingTxt;
    private SeekBar minRatingSeekBar;
    private android.widget.EditText nickNameTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_designer_filter);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        minRatingSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = String.format(Locale.KOREA, "%d", progress);
                minRatingTxt.setText(str);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        okBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent finishIntent = new Intent();
                // 남자 포함 여부 첨부
                finishIntent.putExtra("남자선택여부",  manSelectToggleBtn.isChecked());
                // 여자 포함 여부 첨부
                finishIntent.putExtra("여자선택여부", womanSelectToggleBtn.isChecked());
                // 최소평점 첨부
                finishIntent.putExtra("선택된평점", minRatingSeekBar.getProgress());
                // 입력된 닉네임 첨부
                finishIntent.putExtra("디자이너닉네임", nickNameTxt.getText().toString());
                // 결과 설정(확인, 첨부데이터)
                setResult(RESULT_OK, finishIntent);
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

        this.nickNameTxt = (EditText) findViewById(R.id.nickNameTxt);
        this.minRatingTxt = (TextView) findViewById(R.id.minRatingTxt);
        this.minRatingSeekBar = (SeekBar) findViewById(R.id.minRatingSeekBar);
        this.womanSelectToggleBtn = (ToggleButton) findViewById(R.id.womanSelectToggleBtn);
        this.manSelectToggleBtn = (ToggleButton) findViewById(R.id.manSelectToggleBtn);
        this.okBtn = (Button) findViewById(R.id.okBtn);
    }
}
