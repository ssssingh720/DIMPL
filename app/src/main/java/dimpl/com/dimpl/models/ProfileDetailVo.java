package dimpl.com.dimpl.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sudhir Singh on 29,September,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ProfileDetailVo extends BaseVO {


    @SerializedName("data")
    @Expose
    private ProfileDetail data;




    public ProfileDetail getData() {
        return data;
    }

    public void setData(ProfileDetail data) {
        this.data = data;
    }



}
