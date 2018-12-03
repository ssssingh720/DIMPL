package dimpl.com.dimpl.activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.stone.vega.library.VegaLayoutManager;

import java.util.HashMap;

import dimpl.com.dimpl.R;
import dimpl.com.dimpl.Util.APIMethods;
import dimpl.com.dimpl.Util.Util;
import dimpl.com.dimpl.adapter.ObservationAdapter;
import dimpl.com.dimpl.adapter.SponsorsAdapter;
import dimpl.com.dimpl.manager.SharedPrefManager;
import dimpl.com.dimpl.models.FeedParams;
import dimpl.com.dimpl.models.MySiteDetailVo;
import dimpl.com.dimpl.models.ObservationDetailVO;
import dimpl.com.dimpl.models.ResponseError;
import dimpl.com.dimpl.models.SiteDetailVO;

/**
 * Created by Sudhir Singh on 28,March,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ActivityPropertySiteDetail extends AppBaseActivity implements View.OnClickListener {

    private Context context;

    private Uri mUri;
    private String IMAGE_NAME = "";

    private RecyclerView rclMySiteObservation;
    private ImageView imgAddSiteImage;

    //detail
    private TextView txtUID;
    private TextView txtPropertyAddress;
    private TextView txtDtlLandmarks;
    private TextView txtDtlSiteFacing;
    private TextView txtDtlSiteType;
    private TextView txtDtlSiteAngle;
    private TextView txtDtlSiteSize;
    private TextView txtDtlSitePosition;
    private TextView txtDtlRoadDirection;
    private TextView txtDtlIlluminationStatus;
    private TextView txtDtlLightingType;

    private MySiteDetailVo mySiteDetailVo;
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

        setContentView(R.layout.site_detail);

        context = ActivityPropertySiteDetail.this;

//        fused = new Fused(context, 1);
//        fused.onStart();
//        getLocation();

        rclMySiteObservation = (RecyclerView) findViewById(R.id.rclMySiteObservation);
        rclMySiteObservation.setLayoutManager(new VegaLayoutManager());

        imgAddSiteImage = (ImageView) findViewById(R.id.imgAddSiteImage);
        imgAddSiteImage.setVisibility(View.GONE);

        txtUID = (TextView) findViewById(R.id.txtUID);
        txtPropertyAddress = (TextView) findViewById(R.id.txtPropertyAddress);
        txtDtlLandmarks = (TextView) findViewById(R.id.txtDtlLandmarks);
        txtDtlSiteFacing = (TextView) findViewById(R.id.txtDtlSiteFacing);
        txtDtlSiteType = (TextView) findViewById(R.id.txtDtlSiteType);
        txtDtlSiteAngle = (TextView) findViewById(R.id.txtDtlSiteAngle);
        txtDtlSiteSize = (TextView) findViewById(R.id.txtDtlSiteSize);
        txtDtlSitePosition = (TextView) findViewById(R.id.txtDtlSitePosition);
        txtDtlRoadDirection = (TextView) findViewById(R.id.txtDtlRoadDirection);
        txtDtlIlluminationStatus = (TextView) findViewById(R.id.txtDtlIlluminationStatus);
        txtDtlLightingType = (TextView) findViewById(R.id.txtDtlLightingType);

        LinearLayout lntSiteDetailBack = (LinearLayout) findViewById(R.id.lntSiteDetailBack);

        imgAddSiteImage.setOnClickListener(this);
        lntSiteDetailBack.setOnClickListener(this);

        mySiteDetailVo = (MySiteDetailVo) getIntent().getExtras().get(FeedParams.PROPERTY_DETAIL);
        isOffline = getIntent().getExtras().getBoolean(FeedParams.IS_OFFLINE_MODE);

//        if(mySiteDetailVo.getImage()!=null && mySiteDetailVo.getImage().size()>0) {
//            chapterVideoAdapter = new SponsorsAdapter(context, mySiteDetailVo.getImages(), isOffline);
//            grdSponsors.setAdapter(chapterVideoAdapter);
//        }

        if (Util.isNetworkOnline(context)) {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(getString(R.string.fetching_data));
            pDialog.setCancelable(false);
            pDialog.show();
            HashMap<String, String> params = new HashMap<>();
            params.put(FeedParams.USERID, SharedPrefManager.getInstance().getSharedDataString(FeedParams.USERID));
            params.put(FeedParams.USERTOKEN, SharedPrefManager.getInstance().getSharedDataString(FeedParams.USERTOKEN));
            params.put(FeedParams.SITE_ID, mySiteDetailVo.getSiteId());

            placeRequest(APIMethods.GET_PROPERTY_SITE_OBSERVATION_LISTING, ObservationDetailVO.class, params, true, null);
        } else {
            showToast(R.string.no_internet);
        }


//        grdSponsors.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Intent intent = new Intent(context, DetailActivity.class);
//                intent.putExtra("data", mySiteDetailVo.getImage());
//                intent.putExtra(FeedParams.IS_OFFLINE_MODE, isOffline);
//                intent.putExtra("pos", position);
//                startActivity(intent);
//            }
//        });

    }

    private void setData(SiteDetailVO mySiteDetailVo) {

        TableRow tblLocality = (TableRow) findViewById(R.id.tblLocality);
        TableRow tblLandmark = (TableRow) findViewById(R.id.tblLandmark);
        TableRow tblSiteType = (TableRow) findViewById(R.id.tblSiteType);
        TableRow tblSiteSize = (TableRow) findViewById(R.id.tblSiteSize);
        TableRow tblLightingType = (TableRow) findViewById(R.id.tblLightingType);

        TableRow tblMediaOwner = (TableRow) findViewById(R.id.tblMediaOwner);
        TableRow tblSiteFacing = (TableRow) findViewById(R.id.tblSiteFacing);
        TableRow tblSiteAngle = (TableRow) findViewById(R.id.tblSiteAngle);
        TableRow tblSitePosition = (TableRow) findViewById(R.id.tblSitePosition);
        TableRow tblRoadDirection = (TableRow) findViewById(R.id.tblRoadDirection);
        TableRow tblIlluminationStatus = (TableRow) findViewById(R.id.tblIlluminationStatus);

        tblMediaOwner.setVisibility(View.GONE);
        tblSiteFacing.setVisibility(View.GONE);
        tblSiteAngle.setVisibility(View.GONE);
        tblSitePosition.setVisibility(View.GONE);
        tblRoadDirection.setVisibility(View.GONE);
        tblIlluminationStatus.setVisibility(View.GONE);

        TextView txtPropertyLocation = (TextView) findViewById(R.id.txtPropertyLocation);
//        TextView txtPropertyName = (TextView) findViewById(R.id.txtPropertyName);

        txtPropertyLocation.setText(mySiteDetailVo.getLocality());
        txtPropertyAddress.setText(mySiteDetailVo.getAddress());


        txtUID.setText(mySiteDetailVo.getSiteCode());
        txtDtlSiteFacing.setText(mySiteDetailVo.getSiteFacing());
        txtDtlSiteType.setText(mySiteDetailVo.getSiteType());
        txtDtlSiteAngle.setText(mySiteDetailVo.getSiteAngle());
        txtDtlSiteSize.setText(mySiteDetailVo.getSiteSize());
        txtDtlSitePosition.setText(mySiteDetailVo.getSitePosition());
        txtDtlRoadDirection.setText(mySiteDetailVo.getRoadDirection());
        txtDtlIlluminationStatus.setText(mySiteDetailVo.getIlluminationStatus());
        txtDtlLightingType.setText(mySiteDetailVo.getLightingType());


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
    public void onAPIResponse(Object response, String apiMethod) {
        super.onAPIResponse(response, apiMethod);

        if (apiMethod.equalsIgnoreCase(APIMethods.GET_PROPERTY_SITE_OBSERVATION_LISTING)) {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }
            try {

                ObservationDetailVO resultData = (ObservationDetailVO) response;
                ObservationAdapter mySiteAdapter = new ObservationAdapter(context, resultData.getSiteData().getObservationDetails());
                rclMySiteObservation.setAdapter(mySiteAdapter);

                setData( resultData.getSiteData().getSiteDetail());

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onErrorResponse(VolleyError error, String apiMethod) {
        super.onErrorResponse(error, apiMethod);

        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }

        if (apiMethod.equalsIgnoreCase(APIMethods.GET_PROPERTY_SITE_OBSERVATION_LISTING)) {

            ResponseError responseError = (ResponseError) error;
            showToast(responseError.getErrorMessage());

        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();

        ActivityPropertySiteDetail.this.finish();
        overridePendingTransition(R.anim.back_slide_in, R.anim.back_slide_out);
    }

}
