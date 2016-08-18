package com.spring.zahit.model;
import java.util.Date;

/**
 * Created by GUNEY on 8.08.2016.
 */
public class Campaign {
    private long campaignID;
    private String externalCampaignID;
    private Date startDate;
    private Date endDate;
    private int countControl;
    private int campaignOption;
    private int type;
    private String campaignName;
    private String description;
    private Date creationDate;
    private Date modificationDate;
    private int version;

    public long getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(long campaignID) {
        this.campaignID = campaignID;
    }

    public String getExternalCampaignID() {
        return externalCampaignID;
    }

    public void setExternalCampaignID(String externalCampaignID) {
        this.externalCampaignID = externalCampaignID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCountControl() {
        return countControl;
    }

    public void setCountControl(int countControl) {
        this.countControl = countControl;
    }

    public int getCampaignOption() {
        return campaignOption;
    }

    public void setCampaignOption(int campaignOption) {
        this.campaignOption = campaignOption;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Campaign{" +
                "campaignID=" + campaignID +
                ", externalCampaignID='" + externalCampaignID + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", countControl=" + countControl +
                ", campaignOption=" + campaignOption +
                ", type=" + type +
                ", campaignName='" + campaignName + '\'' +
                ", description='" + description + '\'' +
                ", creationDate=" + creationDate +
                ", modificationDate=" + modificationDate +
                ", version=" + version +
                '}';
    }
}


