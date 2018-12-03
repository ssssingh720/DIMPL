package dimpl.com.dimpl.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sudhir Singh on 27,March,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class MySiteDetailVo implements Serializable {

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("site_code")
    @Expose
    private String siteCode;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("lattitude")
    @Expose
    private String lattitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;
    @SerializedName("site_facing")
    @Expose
    private String siteFacing;
    @SerializedName("site_type")
    @Expose
    private String siteType;
    @SerializedName("site_size")
    @Expose
    private String siteSize;
    @SerializedName("site_angle")
    @Expose
    private String siteAngle;
    @SerializedName("road_direction")
    @Expose
    private String roadDirection;
    @SerializedName("illumination_status")
    @Expose
    private String illuminationStatus;
    @SerializedName("lighting_type")
    @Expose
    private String lightingType;
    @SerializedName("site_position")
    @Expose
    private String sitePosition;
    @SerializedName("site_location")
    @Expose
    private String siteLocation;
    @SerializedName("height_from_ground")
    @Expose
    private String heightFromGround;
    @SerializedName("distance_from_middle")
    @Expose
    private String distanceFromMiddle;
    @SerializedName("side_of_road")
    @Expose
    private String sideOfRoad;
    @SerializedName("clutter")
    @Expose
    private String clutter;
    @SerializedName("image")
    @Expose
    private String image;
    @SerializedName("observed_id")
    @Expose
    private String observedId;
    @SerializedName("display")
    @Expose
    private String display;
    @SerializedName("flex_status")
    @Expose
    private Object flexStatus;
    @SerializedName("lighting")
    @Expose
    private Object lighting;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getLattitude() {
        return lattitude;
    }

    public void setLattitude(String lattitude) {
        this.lattitude = lattitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSiteFacing() {
        return siteFacing;
    }

    public void setSiteFacing(String siteFacing) {
        this.siteFacing = siteFacing;
    }

    public String getSiteType() {
        return siteType;
    }

    public void setSiteType(String siteType) {
        this.siteType = siteType;
    }

    public String getSiteSize() {
        return siteSize;
    }

    public void setSiteSize(String siteSize) {
        this.siteSize = siteSize;
    }

    public String getSiteAngle() {
        return siteAngle;
    }

    public void setSiteAngle(String siteAngle) {
        this.siteAngle = siteAngle;
    }

    public String getRoadDirection() {
        return roadDirection;
    }

    public void setRoadDirection(String roadDirection) {
        this.roadDirection = roadDirection;
    }

    public String getIlluminationStatus() {
        return illuminationStatus;
    }

    public void setIlluminationStatus(String illuminationStatus) {
        this.illuminationStatus = illuminationStatus;
    }

    public String getLightingType() {
        return lightingType;
    }

    public void setLightingType(String lightingType) {
        this.lightingType = lightingType;
    }

    public String getSitePosition() {
        return sitePosition;
    }

    public void setSitePosition(String sitePosition) {
        this.sitePosition = sitePosition;
    }

    public String getSiteLocation() {
        return siteLocation;
    }

    public void setSiteLocation(String siteLocation) {
        this.siteLocation = siteLocation;
    }

    public String getHeightFromGround() {
        return heightFromGround;
    }

    public void setHeightFromGround(String heightFromGround) {
        this.heightFromGround = heightFromGround;
    }

    public String getDistanceFromMiddle() {
        return distanceFromMiddle;
    }

    public void setDistanceFromMiddle(String distanceFromMiddle) {
        this.distanceFromMiddle = distanceFromMiddle;
    }

    public String getSideOfRoad() {
        return sideOfRoad;
    }

    public void setSideOfRoad(String sideOfRoad) {
        this.sideOfRoad = sideOfRoad;
    }

    public String getClutter() {
        return clutter;
    }

    public void setClutter(String clutter) {
        this.clutter = clutter;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getObservedId() {
        return observedId;
    }

    public void setObservedId(String observedId) {
        this.observedId = observedId;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public Object getFlexStatus() {
        return flexStatus;
    }

    public void setFlexStatus(Object flexStatus) {
        this.flexStatus = flexStatus;
    }

    public Object getLighting() {
        return lighting;
    }

    public void setLighting(Object lighting) {
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
}
