package kr.co.tjenit.beautysalon.activity.user_activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.activity.BaseActivity;
import kr.co.tjenit.beautysalon.activity.ReqPraticeActivity;
import kr.co.tjenit.beautysalon.adapters.DesignerAdapter;

public class MainActivity extends BaseActivity {

    private int REQUEST_FOR_DESIGNER_FILTER=1;
    private int REQ_FOR_TEST=2;

    private android.widget.ListView deignerListView;
    DesignerAdapter mAdapter;
    private android.widget.ImageView filterBtn;

    boolean manSelect = true;
    boolean womanSelect = false;

    private android.widget.Button reqTestBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindViews();
        setupEvents();
        setValues();
    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        deignerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(mContext, ViewDeignerDetailActivity.class);
                intent.putExtra("designer", GlobalData.designers.get(position));
                startActivity(intent);
            }
        });

        reqTestBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ReqPraticeActivity.class);
                startActivityForResult(intent, REQ_FOR_TEST);
            }
        });


        filterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, DesignerFilterActivity.class);
//                startActivity(intent);
                // 데이터를 돌려받기 위한 startActivity
                startActivityForResult(intent, REQUEST_FOR_DESIGNER_FILTER);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQ_FOR_TEST) {
            if (resultCode == RESULT_OK) {
//                기본형 변수 : int, double -> 첨부되지 않는 경웽 쓸 기본값 세팅
//                참조형 변수 : string,데이터클래스 -> 기본값X null로 들어감.
                String tempStr = data.getStringExtra("EditText");
                Toast.makeText(mContext, tempStr, Toast.LENGTH_SHORT).show();
            }
        }
    }

    //    언젠가될진 모르지만 언젠가 데이터를 돌려받는다.
//    돌려받는 이벤트에 대응되는 메쏘드를 구현.


//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
////        어떤 요청이었는지.
//        if (requestCode==1) {
////            성별 필터에 달아놓았던 1번 인텐트 요청.
//            if (resultCode==RESULT_OK) {
//                Toast.makeText(mContext, "성별 필터에서 돌아왔다.", Toast.LENGTH_SHORT).show();
//                boolean manOk = data.getBooleanExtra("남자선택여부", true);
//                boolean womanOk = data.getBooleanExtra("여자선택여부", false);
//                Toast.makeText(mContext, "남자 : "+  manOk + ", 여자 : " + womanOk, Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    @Override
    public void setValues() {
        super.setValues();
        mAdapter = new DesignerAdapter(mContext, GlobalData.designers);
        deignerListView.setAdapter(mAdapter);
    }

    @Override
    public void bindViews() {
        super.bindViews();

        this.deignerListView = (ListView) findViewById(R.id.deignerListView);
        this.filterBtn = (ImageView) findViewById(R.id.filterBtn);
        this.reqTestBtn = (Button) findViewById(R.id.reqTestBtn);
    }
}
