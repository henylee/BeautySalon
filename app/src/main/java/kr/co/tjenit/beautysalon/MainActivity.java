package kr.co.tjenit.beautysalon;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.adapters.DesignerAdapter;
import kr.co.tjenit.beautysalon.datas.Designer;

public class MainActivity extends BaseActivity {


    private android.widget.ListView designerListView;
    private DesignerAdapter designerAdapter;

    // 일반 사용자가 로그인했을때 나타나는 화면


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setValues();
        setupEvents();
    }



    @Override
    public void setupEvents() {
        super.setupEvents();
        designerListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Designer tempDesigner = GlobalData.designers.get(position);
                Intent myIntent = new Intent(mContext,  ViewDeignerDetailActivity.class);
                myIntent.putExtra("deigner", tempDesigner);
                startActivity(myIntent);
//                Toast.makeText(mContext, designers.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void setValues() {
        super.setValues();
        designerAdapter = new DesignerAdapter(mContext, GlobalData.designers);
        designerListView.setAdapter(designerAdapter);
    }

    @Override
    public void bindViews() {
        super.bindViews();
        this.designerListView = (ListView) findViewById(R.id.deignerListView);
    }
}
