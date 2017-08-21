package kr.co.tjenit.beautysalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.activity.BaseActivity;
import kr.co.tjenit.beautysalon.adapters.PortfolioAdapter;
import kr.co.tjenit.beautysalon.datas.DesignCase;
import kr.co.tjenit.beautysalon.datas.Designer;

public class ViewDeignerDetailActivity extends BaseActivity {

    Designer mDesigner = null;
    final int REQUEST_FOR_REVIEW = 1;

    private TextView nameTxt;
    private TextView genderTxt;
    private TextView nickTxt;
    private TextView majorTxt;
    private TextView avgTxt;
    private ImageView star1;
    private ImageView star2;
    private ImageView star3;
    private ImageView star4;
    private ImageView star5;
    private ListView portfolioView;
    private Button reservationBtn;

    ArrayList<ImageView> stars = new ArrayList<ImageView>();

    PortfolioAdapter mAdapter;
    private Button reviewBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_deigner_detail);

        mDesigner = (Designer) getIntent().getSerializableExtra("디자이너데이터");
        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        reviewBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MakeReviewActivity.class);
                startActivityForResult(intent, REQUEST_FOR_REVIEW);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_FOR_REVIEW) {
            if (resultCode == RESULT_OK) {
                String reviewContent = data.getStringExtra("리뷰내용");
                // 이 화면에 나타난 디자이너의 리뷰목록을 하나 추가해주고 그 리스트뷰를 새로고침.
                DesignCase tempCase = new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 3, mDesigner, GlobalData.loginUser, 15000, reviewContent);
                mDesigner.getPortFolio().add(tempCase);
                mAdapter.notifyDataSetChanged();
                // 애니메이션을 이용해 마지막칸으로 이동시켜주는 기능.
                portfolioView.smoothScrollToPosition(mDesigner.getPortFolio().size() - 1);
            }
        }
    }

    @Override
    public void setValues() {
        super.setValues();

        nameTxt.setText(mDesigner.getName());
        if (mDesigner.getGender() == 1) {
            genderTxt.setText("여자");
        } else if (mDesigner.getGender() == 0) {
            genderTxt.setText("남자");
        }

        nickTxt.setText(mDesigner.getNickName());
        String majorAge = String.format(Locale.KOREA, "%d대", mDesigner.getMajorAge());
        majorTxt.setText(majorAge);
        avgTxt.setText(mDesigner.getAvgRating()+"");

        int index = (int) mDesigner.getAvgRating();
        for (int i = 0; i < index; i++) {
            stars.get(i).setVisibility(View.VISIBLE);
        }

        mAdapter = new PortfolioAdapter(mContext, mDesigner.getPortFolio());
        portfolioView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.reservationBtn = (Button) findViewById(R.id.reservationBtn);
        this.reviewBtn = (Button) findViewById(R.id.reviewBtn);
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
