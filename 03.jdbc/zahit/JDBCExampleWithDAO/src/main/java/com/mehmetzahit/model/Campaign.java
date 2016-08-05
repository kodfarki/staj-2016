package com.mehmetzahit.model;

/**
 * Created by GUNEY on 29.07.2016.
 */
public class Campaign {
    private int campaignID;
    private String externalCampaignID;
    private String startDate;
    private String endDate;
    private int countControl;
    private int campaignOption;
    private int type;
    private String campaignName;
    private String description;
    private String creationDate;
    private String modificationDate;
    private int version;

    public int getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(int campaignID) {
        this.campaignID = campaignID;
    }

    public String getExternalCampaignID() {
        return externalCampaignID;
    }

    public void setExternalCampaignID(String externalCampaignID) {
        this.externalCampaignID = externalCampaignID;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
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

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
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
        return "\nCampaign{" +
                "campaignID=" + campaignID +
                ", externalCampaignID='" + externalCampaignID + '\'' +
                ", Startdate='" + startDate+ '\'' +
                ", endDate='" + endDate + '\'' +
                ", countControl=" + countControl +
                ", campaignOption=" + campaignOption +
                ", type=" + type +
                ", campaignName='" + campaignName + '\'' +
                ", description='" + description + '\'' +
                ", creationDate='" + creationDate + '\'' +
                ", modificationDate='" + modificationDate + '\'' +
                ", version=" + version +
                '}';
}
}



