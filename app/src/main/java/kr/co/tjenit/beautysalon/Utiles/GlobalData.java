package kr.co.tjenit.beautysalon.Utiles;

import java.util.ArrayList;
import java.util.List;

import kr.co.tjenit.beautysalon.datas.DesignCase;
import kr.co.tjenit.beautysalon.datas.Designer;
import kr.co.tjenit.beautysalon.datas.User;

/**
 * Created by the on 2017-07-27.
 */

public class GlobalData {
    // 앱에서 공동적으로 사용되는 데이터를 임시 저장하는 클래스
    // 대부분

    public static List<DesignCase> GlobalDesignCase = new ArrayList<DesignCase>();
    public static List<Designer> designers = new ArrayList<Designer>();
    public static List<User> users = new ArrayList<User>();

    // 로그인한 사용자의 데이터(임시로 생성)
    public static User loginUser = new User();

}
