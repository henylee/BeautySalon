package kr.co.tjenit.beautysalon.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.Calendar;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.datas.DesignCase;
import kr.co.tjenit.beautysalon.datas.Designer;
import kr.co.tjenit.beautysalon.datas.User;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        addDesigners();
        addUsers();
        adddesignCase();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent myIntent = new Intent(mContext, SelectLoginModeActivity.class);
                startActivity(myIntent);
                finish();
            }
        }, 2000);
        // postdelayed : 어떤 할 일을 재료1, 몇초후에 재료2
        // 할일=> new runnable
        // 재료2만큼의 시간이 지나면 할일을 실행
    }

    private void adddesignCase() {
        GlobalData.GlobalDesignCase.clear();
        GlobalData.GlobalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 5, GlobalData.designers.get(0), GlobalData.users.get(0),10000, "5점 드릴께요."));
        GlobalData.GlobalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 4, GlobalData.designers.get(0), GlobalData.users.get(1),20000, "4점 드릴께요."));
        GlobalData.GlobalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 3, GlobalData.designers.get(0), GlobalData.users.get(2),30000, "3점 드릴께요."));
        GlobalData.GlobalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 2, GlobalData.designers.get(0), GlobalData.users.get(3),20000, "2점 드릴께요."));
        GlobalData.GlobalDesignCase.add(new DesignCase(R.drawable.salon_logo, Calendar.getInstance(), 1, GlobalData.designers.get(0), GlobalData.users.get(4),50000, "1점 드릴께요."));

        Designer leekj = GlobalData.designers.get(0);

        for (DesignCase dc : GlobalData.GlobalDesignCase) {
            leekj.getPortFolio().add(dc);
        }

    }

    private void addUsers() {

        GlobalData.users.clear();
        GlobalData.users.add(new User("한상열", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/images.jpg"));
        GlobalData.users.add(new User("최종환", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/images+(1).jpg"));
        GlobalData.users.add(new User("이요한", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/14.jpg"));
        GlobalData.users.add(new User("이승헌", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/13731255_1566785090293996_693997005_n.jpg"));
        GlobalData.users.add(new User("손익상", 0, Calendar.getInstance(),new ArrayList<Designer>(), "https://s3.ap-northeast-2.amazonaws.com/slws3/imgs/tje_practice/11379757_445206435653478_1894580131_n.jpg"));

    }

    private void addDesigners() {
        GlobalData.designers.clear();
        GlobalData.designers.add(new Designer("이기자", 1, "KIJA", 40, 4.5f, new ArrayList<DesignCase>()));
        GlobalData.designers.add(new Designer("박승철", 0, "PSC", 20, 4.0f, new ArrayList<DesignCase>()));
        GlobalData.designers.add(new Designer("김정남", 1, "KJN", 30, 3.8f, new ArrayList<DesignCase>()));
        GlobalData.designers.add(new Designer("이승철", 0, "LSC", 50, 2.5f, new ArrayList<DesignCase>()));
        GlobalData.designers.add(new Designer("박준", 0, "PJ", 10, 4.8f, new ArrayList<DesignCase>()));
    }
}
