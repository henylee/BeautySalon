package kr.co.tjenit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.co.tjenit.beautysalon.adapters.PortfolioAdapter;
import kr.co.tjenit.beautysalon.datas.Designer;

public class ViewDeignerDetailActivity extends BaseActivity {

    private Designer mDesigner;
    private android.widget.TextView nameTxt;
    private android.widget.TextView genderTxt;
    private android.widget.TextView nickTxt;
    private android.widget.TextView majorTxt;
    private android.widget.TextView avgTxt;
    private android.widget.ImageView star1;
    private android.widget.ImageView star2;
    private android.widget.ImageView star3;
    private android.widget.ImageView star4;
    private android.widget.ImageView star5;
    ArrayList<ImageView> stars = new ArrayList<ImageView>();
    private Button checkSchedualBtn;
    private Button reservationBtn;
    private android.widget.ListView portfolioView;
    PortfolioAdapter portfolioAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_deigner_detail);

        bindViews();
        mDesigner = (Designer) getIntent().getSerializableExtra("deigner");
        setValues();
        setupEvents();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        // 일정확인 버튼을 누르면, 준비중입니다. 토스트 띄어주기
        // 예약하러가기 버튼 => MakeReservation 생성후 넘기기

        checkSchedualBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, R.string.preparing_massage, Toast.LENGTH_SHORT).show();

            }
        });


        reservationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(mContext, MakeReservationActivity.class);
                myintent.putExtra("designer", mDesigner);
                startActivity(myintent);
            }
        });

    }

    @Override
    public void setValues() {
        super.setValues();

        portfolioAdapter = new PortfolioAdapter(mContext, mDesigner.getPortFolio());
        portfolioView.setAdapter(portfolioAdapter);

        nameTxt.setText(mDesigner.getName());
        if (mDesigner.getGender()==0) {
            genderTxt.setText(R.string.man);
        }
        else {
            genderTxt.setText(R.string.woman);
        }
        nickTxt.setText(mDesigner.getNickName());
        majorTxt.setText(mDesigner.getMajorAge()+"대");
        avgTxt.setText(mDesigner.getAvgRating()+"");

        int index = (int) mDesigner.getAvgRating();
        for (int i=0; i<index; i++) {
            stars.get(i).setVisibility(View.VISIBLE);
        }

    }
    // setText에 스트링이외의 자료형을 넣으면
    // 코드 작성시에는 에러가안남.
    // 하지만 실행중엔 앱이 멈춤.
    // string외에 자료형을 넣을땐 => 변수 + ""
    // for문을 이용해 3점대면 별 3개만 표시, 별 2점대면 2개만 표시.

    @Override
    public void bindViews() {
        super.bindViews();
        this.reservationBtn = (Button) findViewById(R.id.reservationBtn);
        this.checkSchedualBtn = (Button) findViewById(R.id.checkSchedualBtn);
        this.portfolioView = (ListView) findViewById(R.id.portfolioView);
        this.star5 = (ImageView) findViewById(R.id.star5);
        this.star4 = (ImageView) findViewById(R.id.star4);
        this.star3 = (ImageView) findViewById(R.id.star3);
        this.star2 = (ImageView) findViewById(R.id.star2);
        this.star1 = (ImageView) findViewById(R.id.star1);
        this.avgTxt = (TextView) findViewById(R.id.avgTxt);
        this.majorTxt = (TextView) findViewById(R.id.majorTxt);
        this.nickTxt = (TextView) findViewById(R.id.nickTxt);
        this.genderTxt = (TextView) findViewById(R.id.genderTxt);
        this.nameTxt = (TextView) findViewById(R.id.nameTxt);

        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

    }
}
