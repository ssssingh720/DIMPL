package dimpl.com.dimpl.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sudhir Singh on 30,October,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class SiteDataVO {

    @SerializedName("observ")
    @Expose
    private List<ObservationDetail> observationDetails ;

    @SerializedName("sites")
    @Expose
    private SiteDetailVO siteDetail;

    public List<ObservationDetail> getObservationDetails() {
        return observationDetails;
    }

    public void setObservationDetails(List<ObservationDetail> observationDetails) {
        this.observationDetails = observationDetails;
    }

    public SiteDetailVO getSiteDetail() {
        return siteDetail;
    }

    public void setSiteDetail(SiteDetailVO siteDetail) {
        this.siteDetail = siteDetail;
    }
}
