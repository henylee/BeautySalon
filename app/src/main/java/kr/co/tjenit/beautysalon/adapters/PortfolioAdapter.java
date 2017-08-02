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

import java.util.ArrayList;

import kr.co.tjenit.beautysalon.R;
import kr.co.tjenit.beautysalon.Utiles.DateTimeUtil;
import kr.co.tjenit.beautysalon.datas.DesignCase;

/**
 * Created by the on 2017-07-28.
 */

public class PortfolioAdapter extends ArrayAdapter<DesignCase> {

    private Context mContext;
    private ArrayList<DesignCase> mList;
    private LayoutInflater inf;
    // 종종 써먹을데가 많으니 해놓으면 좋음.
    // 접근이 용이함.
    // 메모리 절약을 위해서 멤버변수로 빼냄.
    // 한번 생성하고, 재활용 계속 할려고.

    public PortfolioAdapter(Context context, ArrayList<DesignCase> list) {
        super(context, R.layout.portfolio_list_item, list);
        // 1. 어디서 표시할건지 - context
        // 2. 어떤 모양으로 보여줄건지 - layout에다가 xml 새로 만들어서 가져다 넣음
        // 3. 어떤 데이터들을 보여줄건지 - list

        // 생성자 만들고 super(3가지 파라미터)를 대응해줘야 에러가 안남.
        // 우선은 에러가 안나게 이 두가지 작업부터 코딩.
        // layout 필요해져서 res => layout => new => layout resource file 해준다.

        mContext = context;
        mList = list;
        inf = LayoutInflater.from(mContext);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        // 커스터마이징의 알파와오메가
        // 만들어둔 layout파일에 유효한 데이터를 출력시켜주는 부분.

        View row = convertView;

        if (row == null) {

            row = inf.inflate(R.layout.portfolio_list_item, null);
            // layoutinflate를 이용해 리스트뷰의 한줄을 그려내는 방법

        }

        DesignCase  myDS = mList.get(position);

        ImageView profileImage = (ImageView) row.findViewById(R.id.profileImage);
        Glide.with(mContext).load(myDS.getUser().getProfilePicture()).into(profileImage);

        TextView UserTxt = (TextView) row.findViewById(R.id.UserTxt);
        UserTxt.setText(myDS.getUser().getName());

        TextView createdOnTxt = (TextView) row.findViewById(R.id.createdOnTxt);
        createdOnTxt.setText(DateTimeUtil.getdateString2(myDS.getCreatedOn()));

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

        TextView reviewTxt = (TextView) row.findViewById(R.id.reviewTxt);
        reviewTxt.setText(myDS.getUserReivew());

        return row;

        // super.getview를 그대로 사용하면 원하는 위치에 원하는 데이터를 찍어내는게 불가능.
        // 커스터마이징 할때는 super문장을 전부 삭제, 처음부터 코딩.
    }
}
