package dimpl.com.dimpl.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sudhir Singh on 19,September,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class ObservationDetail implements Serializable{

    @SerializedName("allocation_id")
    @Expose
    private String allocationId;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("flex_status")
    @Expose
    private String flexStatus;
    @SerializedName("lighting")
    @Expose
    private String lighting;
    @SerializedName("observed_date")
    @Expose
    private String observedDate;
    @SerializedName("display_icon")
    @Expose
    private String displayIcon;
    @SerializedName("flex_icon")
    @Expose
    private String flexIcon;
    @SerializedName("lighting_icon")
    @Expose
    private String lightingIcon;
    @SerializedName("gallery")
    @Expose
    private ArrayList<ObservationGallery> gallery = null;

    public String getAllocationId() {
        return allocationId;
    }

    public void setAllocationId(String allocationId) {
        this.allocationId = allocationId;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getFlexStatus() {
        return flexStatus;
    }

    public void setFlexStatus(String flexStatus) {
        this.flexStatus = flexStatus;
    }

    public String getLighting() {
        return lighting;
    }

    public void setLighting(String lighting) {
        this.lighting = lighting;
    }

    public String getObservedDate() {
        return observedDate;
    }

    public void setObservedDate(String observedDate) {
        this.observedDate = observedDate;
    }

    public String getDisplayIcon() {
        return displayIcon;
    }

    public void setDisplayIcon(String displayIcon) {
        this.displayIcon = displayIcon;
    }

    public String getFlexIcon() {
        return flexIcon;
    }

    public void setFlexIcon(String flexIcon) {
        this.flexIcon = flexIcon;
    }

    public String getLightingIcon() {
        return lightingIcon;
    }

    public void setLightingIcon(String lightingIcon) {
        this.lightingIcon = lightingIcon;
    }

    public ArrayList<ObservationGallery> getGallery() {
        return gallery;
    }

    public void setGallery(ArrayList<ObservationGallery> gallery) {
        this.gallery = gallery;
    }

}
