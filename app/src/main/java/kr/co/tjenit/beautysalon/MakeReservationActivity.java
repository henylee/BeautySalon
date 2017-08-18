package kr.co.tjenit.beautysalon;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.tjenit.beautysalon.Utiles.DateTimeUtil;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.datas.DesignCase;
import kr.co.tjenit.beautysalon.datas.Designer;
import kr.co.tjenit.beautysalon.datas.User;

public class MakeReservationActivity extends BaseActivity {

    private android.widget.TextView dateTxt;
    private android.widget.Button selectDateBtn;
    Calendar mReservation = Calendar.getInstance();
    private TextView timeTxt;
    private Button selectTimeBtn;
    private Button confirmBtn;
    private android.widget.Spinner hairStyleSpinner;
    ArrayList<String> hairStyles = new ArrayList<>();
    ArrayAdapter<String> hairAdapter;
    private Spinner largetag;

    private Designer mDesigner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_make_reservation);

        bindViews();
        setupEvents();
        setValues();
        addhairStyles(0);
    }

    private void addhairStyles(int categolyIndex) {
        hairStyles.clear();
        if (categolyIndex==0) {
            hairStyles.add("반삭");
            hairStyles.add("투블럭");
            hairStyles.add("샤기컷");
            hairStyles.add("울프컷");

        }
        else if (categolyIndex == 1) {
            hairStyles.add("매직");
            hairStyles.add("다운펌");
            hairStyles.add("가르마");
        }
        else if(categolyIndex==2) {
            hairStyles.add("빨강");
            hairStyles.add("파랑");
            hairStyles.add("갈색");
        }

        hairAdapter.notifyDataSetChanged();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();

        largetag.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                addhairStyles(position);
//                Toast.makeText(mContext, position + "번 줄을 선택했습니다.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GlobalData.GlobalDesignCase.add(new DesignCase(-1, mReservation, -1, mDesigner, new User(),-1, null));

                Log.d("미용사례개수", GlobalData.GlobalDesignCase.size() + "개");

                Toast.makeText(mContext, R.string.complete_reservation, Toast.LENGTH_SHORT).show();
                finish();
            }
        });

        selectDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(mContext, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        mReservation.set(Calendar.YEAR, year);
                        mReservation.set(Calendar.MONTH, month);
                        mReservation.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        dateTxt.setText(DateTimeUtil.getDateString(mReservation));

                    }
                }, mReservation.get(Calendar.YEAR), mReservation.get(Calendar.MONTH), mReservation.get(Calendar.DAY_OF_MONTH)).show();
            }
        }); // 이벤트 핸들링, 이벤트 처리.

        selectTimeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new TimePickerDialog(mContext, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mReservation.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        mReservation.set(Calendar.MINUTE, minute);

                        timeTxt.setText(DateTimeUtil.getTimeString(mReservation));
                    }
                }, mReservation.get(Calendar.HOUR_OF_DAY), mReservation.get(Calendar.MINUTE), false).show();
            }
        });

    }

    @Override
    public void setValues() {
        super.setValues();

        mDesigner = (Designer) getIntent().getSerializableExtra("designer");

        hairAdapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, hairStyles);
        hairStyleSpinner.setAdapter(hairAdapter);

        String dateString = DateTimeUtil.getDateString(mReservation);
        dateTxt.setText(dateString);

        String timeString = DateTimeUtil.getTimeString(mReservation);
        timeTxt.setText(timeString);

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.confirmBtn = (Button) findViewById(R.id.confirmBtn);
        this.selectTimeBtn = (Button) findViewById(R.id.selectTimeBtn);
        this.timeTxt = (TextView) findViewById(R.id.timeTxt);
        this.selectDateBtn = (Button) findViewById(R.id.selectDateBtn);
        this.dateTxt = (TextView) findViewById(R.id.dateTxt);
        this.hairStyleSpinner = (Spinner) findViewById(R.id.hairStyleSpinner);
        this.largetag = (Spinner) findViewById(R.id.largetag);
    }
}
