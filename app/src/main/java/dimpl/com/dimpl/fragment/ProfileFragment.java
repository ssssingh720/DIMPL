package dimpl.com.dimpl.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;

import com.android.volley.VolleyError;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

import dimpl.com.dimpl.R;
import dimpl.com.dimpl.Util.APIMethods;
import dimpl.com.dimpl.Util.Util;
import dimpl.com.dimpl.manager.SharedPrefManager;
import dimpl.com.dimpl.models.FeedParams;
import dimpl.com.dimpl.models.MySiteVo;
import dimpl.com.dimpl.models.ProfileDetailVo;
import dimpl.com.dimpl.models.ResponseError;

/**
 * Created by Sudhir Singh on 21,September,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ProfileFragment extends BaseFragment implements View.OnClickListener {

    private Context context;
    private ProgressDialog pDialog;

    private ImageView imgProfile;
    private EditText edtInputName;
    private EditText edtInputEmail;
    private EditText edtInputMobileNumber;
    private Switch swtNotification;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mView = inflater.inflate(R.layout.profile_fragment, container, false);

        context = getActivity();

        imgProfile = (ImageView) mView.findViewById(R.id.imgProfile);
        edtInputName = (EditText) mView.findViewById(R.id.edtInputName);
        edtInputEmail = (EditText) mView.findViewById(R.id.edtInputEmail);
        edtInputMobileNumber = (EditText) mView.findViewById(R.id.edtInputMobileNumber);
        swtNotification = (Switch) mView.findViewById(R.id.swtNotification);

        if (Util.isNetworkOnline(context)) {

            getMySiteList();

        } else {
            showToast(getResources().getString(R.string.no_internet));
        }
        return mView;
    }

    @Override
    public void onClick(View view) {

    }

    private void getMySiteList() {

        if (Util.isNetworkOnline(context)) {
            pDialog = new ProgressDialog(context);
            pDialog.setMessage(getString(R.string.fetching_data));
            pDialog.setCancelable(false);
            pDialog.show();
//userid, usertoken , media_owner_id, landmarks, locality, site_facing_id, site_type_id, site_size,
// site_angel, road_direction, illumination_status, lighting_type, license, site_position_id, lattitude, longitude
            HashMap<String, String> params = new HashMap<>();
            params.put(FeedParams.USERID, SharedPrefManager.getInstance().getSharedDataString(FeedParams.USERID));
            params.put(FeedParams.USERTOKEN, SharedPrefManager.getInstance().getSharedDataString(FeedParams.USERTOKEN));

            placeRequest(APIMethods.PROFILE_DETAIL, ProfileDetailVo.class, params, true, null);

        } else {
            showToast(R.string.no_internet);
        }
    }

    @Override
    public void onAPIResponse(Object response, String apiMethod) {
        super.onAPIResponse(response, apiMethod);

        if (apiMethod.equalsIgnoreCase(APIMethods.PROFILE_DETAIL)) {
            if (pDialog != null && pDialog.isShowing()) {
                pDialog.dismiss();
            }
            try {

                ProfileDetailVo resultData = (ProfileDetailVo) response;

                edtInputName.setText(resultData.getData().getName());
                edtInputEmail.setText(resultData.getData().getEmail());
                edtInputMobileNumber.setText(resultData.getData().getMobile());

                if(resultData.getData().getImage()!=null && resultData.getData().getImage().length()>0) {
                    Picasso.get().load(resultData.getData().getImage()).placeholder(R.drawable.placeholder)
                            .error(R.drawable.placeholder)
                            .into(imgProfile);
                }

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

        if (apiMethod.equalsIgnoreCase(APIMethods.PROFILE_DETAIL)) {

            ResponseError responseError = (ResponseError) error;
            showToast(responseError.getErrorMessage());

        }
    }
}
