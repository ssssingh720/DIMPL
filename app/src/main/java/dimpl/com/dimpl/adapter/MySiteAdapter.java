package dimpl.com.dimpl.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import dimpl.com.dimpl.R;
import dimpl.com.dimpl.activities.ActivityPropertySiteDetail;
import dimpl.com.dimpl.models.FeedParams;
import dimpl.com.dimpl.models.MySiteDetailVo;


/**
 * Created by Sudhir Singh on 27,March,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class MySiteAdapter extends RecyclerView.Adapter<MySiteAdapter.MyViewHolder> {

    private Context mContext;
    private List<MySiteDetailVo> albumList;

    public MySiteAdapter(Context mContext, List<MySiteDetailVo> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_site_adapter, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MySiteDetailVo album = albumList.get(position);

        holder.txtTripName.setText(album.getSiteCode());
        holder.txtTripLocation.setText(album.getAddress());
//        holder.txtMediaOwnerName.setText(album.getMediaOwner());
        holder.txtTripDate.setText(album.getObservedDate());

        holder.imgJury.setTag(position);
        if (album.getImage() != null && album.getImage().length() > 0) {
            Picasso.get().load(album.getImage()).fit().placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(holder.imgJury);
        }else{
            Picasso.get().load(R.drawable.placeholder).into(holder.imgJury);
        }

        holder.imgStatus.setTag(position);
        Picasso.get().load(album.getFlexIcon()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgStatus);


        holder.imgDisplayIcon.setTag(position);
        Picasso.get().load(album.getDisplayIcon()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgDisplayIcon);

        holder.imgLightIcon.setTag(position);
        Picasso.get().load(album.getLightingIcon()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgLightIcon);

        holder.lnrSpeakerDetail.setTag(position);
        holder.lnrSpeakerDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int positionClicked = (Integer) view.getTag();

                MySiteDetailVo album = albumList.get(positionClicked);
                Intent propertyDetail = new Intent(mContext, ActivityPropertySiteDetail.class);
                propertyDetail.putExtra(FeedParams.PROPERTY_DETAIL, album);
                propertyDetail.putExtra(FeedParams.IS_OFFLINE_MODE, false);
                mContext.startActivity(propertyDetail);

//                showPopupMenu(holder.overflow);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTripName, txtTripLocation, txtMediaOwnerName, txtTripDate;
        private ImageView imgJury,imgLocationIcon,imgStatus,imgDisplayIcon,imgLightIcon;
        private LinearLayout lnrSpeakerDetail;

        public MyViewHolder(View view) {
            super(view);
            txtTripName = (TextView) view.findViewById(R.id.txtTripName);
            txtTripLocation = (TextView) view.findViewById(R.id.txtTripLocation);
            txtMediaOwnerName = (TextView) view.findViewById(R.id.txtMediaOwnerName);
            txtTripDate = (TextView) view.findViewById(R.id.txtTripDate);
            imgJury = (ImageView) view.findViewById(R.id.imgJury);
            imgLocationIcon = (ImageView) view.findViewById(R.id.imgLocationIcon);
            imgStatus = (ImageView) view.findViewById(R.id.imgStatus);
            imgDisplayIcon = (ImageView) view.findViewById(R.id.imgDisplayIcon);
            imgLightIcon = (ImageView) view.findViewById(R.id.imgLightIcon);
            lnrSpeakerDetail = (LinearLayout) view.findViewById(R.id.lnrSpeakerDetail);
        }
    }
}
