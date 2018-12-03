package dimpl.com.dimpl.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Sudhir Singh on 24,April,2018
 * ESS,
 * B-65,Sector 63,Noida.
 */
public class MonitorSiteVo extends BaseVO implements Serializable {

    @SerializedName("data")
    @Expose
    private ArrayList<MonitorSiteDetailVo> data = null;

    public ArrayList<MonitorSiteDetailVo> getData() {
        return data;
    }

    public void setData(ArrayList<MonitorSiteDetailVo> data) {
        this.data = data;
    }
}
