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
import dimpl.com.dimpl.activities.ObservationDetailActivity;
import dimpl.com.dimpl.models.FeedParams;
import dimpl.com.dimpl.models.ObservationDetail;

/**
 * Created by Sudhir Singh on 19,September,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ObservationAdapter extends RecyclerView.Adapter<ObservationAdapter.MyViewHolder> {

    private Context mContext;
    private List<ObservationDetail> albumList;

    public ObservationAdapter(Context mContext, List<ObservationDetail> albumList) {
        this.mContext = mContext;
        this.albumList = albumList;
    }

    @Override
    public ObservationAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.observation_adapter, parent, false);

        return new ObservationAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ObservationAdapter.MyViewHolder holder, int position) {
        ObservationDetail album = albumList.get(position);

        holder.txtObserDate.setText("Date : " + album.getObservedDate());
        holder.txtObsFlexStatus.setText("Flex Status : " + album.getFlexStatus());
        holder.txtObsDisplay.setText("Display : " + album.getDisplay());
        holder.txtObsLighting.setText("Lighting : " + album.getLighting());

        holder.imgObsJury.setTag(position);
        if (album.getGallery() != null && album.getGallery().size() > 0) {
            Picasso.get().load(album.getGallery().get(0).getImage()).fit().placeholder(R.drawable.placeholder)
                    .error(R.drawable.placeholder)
                    .into(holder.imgObsJury);
        } else {
            Picasso.get().load(R.drawable.placeholder).into(holder.imgObsJury);
        }

        holder.imgObsStatus.setTag(position);
        Picasso.get().load(album.getFlexIcon()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgObsStatus);


        holder.imgObsDisplayIcon.setTag(position);
        Picasso.get().load(album.getDisplayIcon()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgObsDisplayIcon);

        holder.imgObsLightIcon.setTag(position);
        Picasso.get().load(album.getLightingIcon()).placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(holder.imgObsLightIcon);

        holder.lnrSpeakerDetail.setTag(position);
        holder.lnrSpeakerDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int positionClicked = (Integer) view.getTag();

                ObservationDetail album = albumList.get(positionClicked);
                Intent propertyDetail = new Intent(mContext, ObservationDetailActivity.class);
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
        private TextView txtObserDate, txtObsFlexStatus, txtObsDisplay, txtObsLighting;
        private ImageView imgObsJury, imgObsLocationIcon, imgObsStatus, imgObsDisplayIcon, imgObsLightIcon;
        private LinearLayout lnrSpeakerDetail;

        public MyViewHolder(View view) {
            super(view);
            txtObserDate = (TextView) view.findViewById(R.id.txtObserDate);
            txtObsFlexStatus = (TextView) view.findViewById(R.id.txtObsFlexStatus);
            txtObsDisplay = (TextView) view.findViewById(R.id.txtObsDisplay);
            txtObsLighting = (TextView) view.findViewById(R.id.txtObsLighting);
            imgObsJury = (ImageView) view.findViewById(R.id.imgObsJury);

            imgObsLocationIcon = (ImageView) view.findViewById(R.id.imgObsLocationIcon);
            imgObsStatus = (ImageView) view.findViewById(R.id.imgObsStatus);
            imgObsDisplayIcon = (ImageView) view.findViewById(R.id.imgObsDisplayIcon);
            imgObsLightIcon = (ImageView) view.findViewById(R.id.imgObsLightIcon);
            lnrSpeakerDetail = (LinearLayout) view.findViewById(R.id.lnrSpeakerDetail);
        }
    }
}
