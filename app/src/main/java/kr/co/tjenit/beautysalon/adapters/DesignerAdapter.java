package kr.co.tjenit.beautysalon.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.datas.Designer;
import kr.co.tjenit.beautysalon.datas.Person;

/**
 * Created by the on 2017-08-18.
 */

public class DesignerAdapter extends ArrayAdapter<Designer> {

    Context mContext;
    List<Designer> mList;
    LayoutInflater inf;

    public DesignerAdapter(Context context, List<Designer> list) {
        super(context, R.layout.designer_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row == null) {
            row = inf.inflate(R.layout.designer_list_item, null);
        }

        Designer mDesigner = mList.get(position);

        // 리스트뷰의 필요한 아이템들을 아이디를 먹여 매핑하기.
        ImageView designerProfileImg = (ImageView) row.findViewById(R.id.designerProfileImg);
        TextView designerNameTxt = (TextView) row.findViewById(R.id.designerNameTxt);
        TextView majorAgeTxt = (TextView) row.findViewById(R.id.majorAgeTxt);
        TextView designerGenderTxt = (TextView) row.findViewById(R.id.designerGenderTxt);
        ImageView star1 = (ImageView) row.findViewById(R.id.star1);
        ImageView star2 = (ImageView) row.findViewById(R.id.star2);
        ImageView star3 = (ImageView) row.findViewById(R.id.star3);
        ImageView star4 = (ImageView) row.findViewById(R.id.star4);
        ImageView star5 = (ImageView) row.findViewById(R.id.star5);

        // 디자이너의 이름, 닉네임 표시.
        designerNameTxt.setText(mDesigner.getName() + " (" + mDesigner.getNickName() + ")");

        // 디자이너의 주력 연령대.
        String majorStr = String.format(Locale.KOREA, "주력분야 : %d대", mDesigner.getMajorAge());
        majorAgeTxt.setText(majorStr);

        // 디자이너의 성별.
        if (mDesigner.getGender() == 0) {
            designerGenderTxt.setText(R.string.man);
        } else {
            designerGenderTxt.setText(R.string.woman);
        }

        // 평점 표시.
        // 배열을 위한 데이터 세팅.
        List<ImageView> stars = new ArrayList<>();
        stars.add(star1);
        stars.add(star2);
        stars.add(star3);
        stars.add(star4);
        stars.add(star5);

        // 일단 별은 기본적으로 숨김처리 되도록 한다.
        for (ImageView iv : stars) {
            iv.setVisibility(View.GONE);
        }

        // 평점에 맞는 갯수만큼 별표를 다시 보여준다.
        // 평점에 맞는 갯수 -> int 형태로 구해져야.
        // 4.3 -> 4개, 3.8 -> 3개 소수점 버림 (캐스팅).
        // 이유 : 그래야 코딩도 화면 구현도 쉬움.
        int rating = (int) mDesigner.getAvgRating();

        for (int i = 0; i < rating; i++) {
            stars.get(i).setVisibility(View.VISIBLE);
        }

        return row;
    }

}
