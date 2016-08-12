package com.servlet.model;


import java.util.Date;

public class Campaign {
    private int campaignID;
    private int externalCampaignID;
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

    public Campaign() {
    }

    public Campaign(java.sql.Date startDate, java.sql.Date endDate, int countControl,
                    int campaignOption, int type, String campaignName,
                    String description, Date creationDate, Date modificationDate, int version) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.countControl = countControl;
        this.campaignOption = campaignOption;
        this.type = type;
        this.campaignName = campaignName;
        this.description = description;
        this.creationDate = creationDate;
        this.modificationDate = modificationDate;
        this.version = version;
    }

    public int getCampaignID() {
        return campaignID;
    }

    public void setCampaignID(int campaignID) {
        this.campaignID = campaignID;
    }

    public int getExternalCampaignID() {
        return externalCampaignID;
    }

    public void setExternalCampaignID(int externalCampaignID) {
        this.externalCampaignID = externalCampaignID;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) { this.startDate = startDate; }

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
        return "Campaign: CampaignID: " + getCampaignID() + " External_CampaignID: " + getExternalCampaignID() +
                " Start Date: " + getStartDate() + " End Date: " + getEndDate() + " Count Control: " + getCountControl() +
                " Campaign Option: " + getCampaignOption() + " Type: " + getType() + "\n          Campaign Name: " + getCampaignName() +
                " Description: " + getDescription() + " Creation Date: " + getCreationDate() + " Modification Date: " + modificationDate +
                " Version: " + getVersion() + ".\n";
    }
}