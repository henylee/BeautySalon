package kr.co.tjenit.beautysalon.Utiles;

import java.util.ArrayList;

import kr.co.tjenit.beautysalon.datas.DesignCase;
import kr.co.tjenit.beautysalon.datas.Designer;
import kr.co.tjenit.beautysalon.datas.User;

/**
 * Created by the on 2017-07-27.
 */

public class GeneralUtil {
    // 앱에서 공동적으로 사용되는 데이터를 임시 저장하는 클래스
    // 대부분

    public static ArrayList<DesignCase> GlobalDesignCase = new ArrayList<DesignCase>();
    public static ArrayList<Designer> designers = new ArrayList<Designer>();
    public static ArrayList<User> users = new ArrayList<User>();

}
