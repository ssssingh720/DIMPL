package dimpl.com.dimpl.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import dimpl.com.dimpl.R;
import dimpl.com.dimpl.adapter.SponsorsAdapter;
import dimpl.com.dimpl.models.FeedParams;
import dimpl.com.dimpl.models.ObservationDetail;

/**
 * Created by Sudhir Singh on 19,September,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ObservationDetailActivity extends AppBaseActivity implements View.OnClickListener {

    private Context context;

    private Uri mUri;
    private String IMAGE_NAME = "";

    private GridView grdObserImg;
    private ImageView imgAddSiteImage;

    private ObservationDetail mySiteDetailVo;
    private SponsorsAdapter chapterVideoAdapter;

    private ProgressDialog pDialog;
    private String mStoredImagePath = "";

    //    private Fused fused;
    private double longitude = 0;
    private double latitude = 0;
    private boolean isOffline = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.observation_image_detail);

        context = ObservationDetailActivity.this;

//        fused = new Fused(context, 1);
//        fused.onStart();
//        getLocation();

        grdObserImg = (GridView) findViewById(R.id.grdObserImg);


        imgAddSiteImage = (ImageView) findViewById(R.id.imgAddSiteImage);
        imgAddSiteImage.setVisibility(View.GONE);

        LinearLayout lntSiteDetailBack = (LinearLayout) findViewById(R.id.lntSiteDetailBack);
        LinearLayout lnrObsDetail = (LinearLayout) findViewById(R.id.lnrObsDetail);

        imgAddSiteImage.setOnClickListener(this);
        lntSiteDetailBack.setOnClickListener(this);

        mySiteDetailVo = (ObservationDetail) getIntent().getExtras().get(FeedParams.PROPERTY_DETAIL);
        isOffline = getIntent().getExtras().getBoolean(FeedParams.IS_OFFLINE_MODE);

//        if(mySiteDetailVo.getImage()!=null && mySiteDetailVo.getImage().size()>0) {
        chapterVideoAdapter = new SponsorsAdapter(context, mySiteDetailVo.getGallery(), isOffline);
        grdObserImg.setAdapter(chapterVideoAdapter);
//        }

        lnrObsDetail.setVisibility(View.GONE);
//        setData(mySiteDetailVo);

        grdObserImg.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("data", mySiteDetailVo.getGallery());
                intent.putExtra(FeedParams.IS_OFFLINE_MODE, isOffline);
                intent.putExtra("pos", position);
                startActivity(intent);
            }
        });

    }

    private void setData(ObservationDetail mySiteDetailVo) {

        TextView txtObsImgDisplay = (TextView) findViewById(R.id.txtObsImgDisplay);
        TextView txtFlexStatus = (TextView) findViewById(R.id.txtFlexStatus);
        TextView txtLighting = (TextView) findViewById(R.id.txtLighting);
        TextView txtDtlAddedDate = (TextView) findViewById(R.id.txtDtlAddedDate);
//        TextView txtPropertyName = (TextView) findViewById(R.id.txtPropertyName);

        txtObsImgDisplay.setText(mySiteDetailVo.getDisplay());

        txtFlexStatus.setText(mySiteDetailVo.getFlexStatus());
        txtLighting.setText(mySiteDetailVo.getLighting());
        txtDtlAddedDate.setText(mySiteDetailVo.getObservedDate());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.imgAddSiteImage:

//                Intent addImageIntent = new Intent(context, OfflineCaptureSiteImage.class);
//                addImageIntent.putExtra(FeedParams.PROPERTY_SITE_ID, mySiteDetailVo);
//                addImageIntent.putExtra(FeedParams.IS_IMAGE_COMPULASARY, "" + false);
//                startActivityForResult(addImageIntent, REQUEST_IMAGE_CATURE);

//                checkCameraPermission();

                break;

            case R.id.lntSiteDetailBack:

                onBackPressed();

                break;
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ObservationDetailActivity.this.finish();
        overridePendingTransition(R.anim.back_slide_in, R.anim.back_slide_out);
    }
}
