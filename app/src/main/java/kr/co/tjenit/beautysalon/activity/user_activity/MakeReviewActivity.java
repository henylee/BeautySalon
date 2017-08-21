package kr.co.tjenit.beautysalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.activity.BaseActivity;

public class MakeReviewActivity extends BaseActivity {

    private android.widget.EditText reviewEditTxt;
    private android.widget.Button reviewOkBtn;
    private android.widget.RadioButton gpa1;
    private android.widget.RadioButton gpa2;
    private android.widget.RadioButton gpa3;
    private android.widget.RadioButton gpa4;
    private android.widget.RadioButton gpa5;
    private android.widget.RadioGroup GPAGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reviewactivity);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        reviewOkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("리뷰내용", reviewEditTxt.getText().toString());
                intent.putExtra("평점선택", GPAGroup.getCheckedRadioButtonId());
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

        this.reviewOkBtn = (Button) findViewById(R.id.reviewOkBtn);
        this.reviewEditTxt = (EditText) findViewById(R.id.reviewEditTxt);
        this.GPAGroup = (RadioGroup) findViewById(R.id.GPAGroup);
        this.gpa5 = (RadioButton) findViewById(R.id.gpa5);
        this.gpa4 = (RadioButton) findViewById(R.id.gpa4);
        this.gpa3 = (RadioButton) findViewById(R.id.gpa3);
        this.gpa2 = (RadioButton) findViewById(R.id.gpa2);
        this.gpa1 = (RadioButton) findViewById(R.id.gpa1);
    }

}
