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

import com.bumptech.glide.Glide;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.GlobalData;
import kr.co.tjenit.beautysalon.datas.DesignCase;
import kr.co.tjenit.beautysalon.datas.Designer;

/**
 * Created by the on 2017-08-21.
 */

public class PortfolioAdapter extends ArrayAdapter<DesignCase> {

    Context mContext;
    List<DesignCase> mList;
    LayoutInflater inf;

    public PortfolioAdapter(Context context, List<DesignCase> list) {
        super(context, R.layout.portfolio_list_item, list);

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View row = convertView;

        if (row==null) {
            row = inf.inflate(R.layout.portfolio_list_item, null);
        }

        DesignCase  myDS = mList.get(position);

        ImageView profileImage = (ImageView) row.findViewById(R.id.profileImage);
        TextView UserTxt = (TextView) row.findViewById(R.id.UserTxt);
        TextView createdOnTxt = (TextView) row.findViewById(R.id.createdOnTxt);
        ImageView star1 = (ImageView) row.findViewById(R.id.star1);
        ImageView star2 = (ImageView) row.findViewById(R.id.star2);
        ImageView star3 = (ImageView) row.findViewById(R.id.star3);
        ImageView star4 = (ImageView) row.findViewById(R.id.star4);
        ImageView star5 = (ImageView) row.findViewById(R.id.star5);
        TextView reviewTxt = (TextView) row.findViewById(R.id.reviewTxt);

        // 다형성 : 여러가지 형태로 존재할 수 있다.
        // 1. overLoading
        // 2. 부모는 자식을 담아둘 수 있다.

        // 라이브러리 : 인터넷 이미지 불러오기 : 이미지 로더
        // 라이브러리2 : 등그란 이미지뷰 => circleImageView
        // 개발의 폭이 매우 넓어진다. -> 라이브러리 : 다양한 종류의 레고 블럭.

        // 라이브러리 단점 : 깊이가 안길어진다.
        // 라이브러리 공부 - 분석
        Glide.with(mContext).load(myDS.getUser().getProfilePicture()).into(profileImage);
        UserTxt.setText(myDS.getUser().getName());
        reviewTxt.setText(myDS.getUserReivew());

        //  날짜를 string으로 출력하고자 할때, simpledateformat
        // 생성자에 원하는 출력형태를 넣어주면 된다.
        // 만들어진 날짜형태를 이용해 string을 만들어준다. dateFormat.format(원하는 calender.getTime())
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr = dateFormat.format(myDS.getCreatedOn().getTime());
        createdOnTxt.setText(dateStr);

        ArrayList<View> stars = new ArrayList<View>();
        stars.add(row.findViewById(R.id.star1));
        stars.add(row.findViewById(R.id.star2));
        stars.add(row.findViewById(R.id.star3));
        stars.add(row.findViewById(R.id.star4));
        stars.add(row.findViewById(R.id.star5));

        for (View v : stars) {
            v.setVisibility(View.GONE);
        }

        for (int i=0; i<myDS.getUserRating(); i++) {
            stars.get(i).setVisibility(View.VISIBLE);
        }

        return row;
    }
}
