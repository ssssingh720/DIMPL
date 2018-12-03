package dimpl.com.dimpl.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sudhir Singh on 19,September,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ObservationDetailVO extends BaseVO implements Serializable {

    @SerializedName("data")
    @Expose
    private  SiteDataVO  siteData ;

    public SiteDataVO getSiteData() {
        return siteData;
    }

    public void setSiteData(SiteDataVO siteData) {
        this.siteData = siteData;
    }
}
