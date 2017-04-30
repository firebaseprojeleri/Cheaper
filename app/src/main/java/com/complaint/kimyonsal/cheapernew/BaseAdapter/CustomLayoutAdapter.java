
package com.complaint.kimyonsal.cheapernew.BaseAdapter;


import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.complaint.kimyonsal.cheapernew.Models.PostModel;
import com.complaint.kimyonsal.cheapernew.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;



/**
 * Created by kimyonsal on 19.04.2017.
 */


public class CustomLayoutAdapter extends BaseAdapter {

    private LayoutInflater mInflater = null;
    private List<PostModel> postListesi;






    public CustomLayoutAdapter(Activity activity, List<PostModel> list) {
        mInflater = (LayoutInflater) activity.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        this.postListesi = list;

    }

    public CustomLayoutAdapter(Context context) {
    }

    @Override
    public int getCount() {
        return postListesi.size();
    }

    @Override
    public Object getItem(int position) {
         return null
                 ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    Uri photoUrl;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vi;
        vi = mInflater.inflate(R.layout.custom_main_layout, null);
         PostModel model = postListesi.get(position);

        FirebaseUser frUser = FirebaseAuth.getInstance().getCurrentUser();

        TextView tvpostAdi = (TextView) vi.findViewById(R.id.tvPostAdi);

        tvpostAdi.setText(model.postIsim);

        TextView tvIcerik = (TextView) vi.findViewById(R.id.tvIcerik);

        tvIcerik.setText(model.postIcerik);







//
//        ImageView imageLikeMain = (ImageView) vi.findViewById(R.id.imageLikeBtn);
//        ImageView imageDisLikeMain = (ImageView) vi.findViewById(R.id.imageDislikeBtn);


        return vi;
    }
}

