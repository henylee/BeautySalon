package kr.co.tjenit.beautysalon.activity.worker_activity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.activity.BaseActivity;
import kr.co.tjenit.beautysalon.datas.DesignCase;

public class WorkerMainActivity extends BaseActivity {

    private android.widget.ListView reservationListview;
    private ArrayAdapter<DesignCase> reservationAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_main);

        bindViews();
        setupEvents();
        setValues();

    }

    @Override
    public void setupEvents() {
        super.setupEvents();
    }

    @Override
    public void setValues() {
        super.setValues();

        reservationAdapter = new ArrayAdapter<DesignCase>(mContext, android.R.layout.simple_list_item_1, GlobalData.GlobalDesignCase);
        reservationListview.setAdapter(reservationAdapter);

    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.reservationListview = (ListView) findViewById(R.id.reservationListview);
    }
}
