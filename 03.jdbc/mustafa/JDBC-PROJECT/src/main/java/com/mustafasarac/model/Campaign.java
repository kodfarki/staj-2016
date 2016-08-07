package com.mustafasarac.model;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by mustafasarac on 31.07.2016.
 */
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
    private Timestamp creationDate;
    private Timestamp modificationDate;
    private int version;

    @Override
    public String toString() {
        return "Campaign: CampaignID: " + getCampaignID() + " External CampaignID: " + getExternalCampaignID() +
                " Start Date: " + getStartDate() + " End Date: " + getEndDate() + " Count Control: " + getCountControl() +
                " Campaign Option: " + getCampaignOption() + " Type: " + getType() + "\n          Campaign Name: " + getCampaignName() +
                " Description: " + getDescription() + " Creation Date: " + getCreationDate() + " Modification Date: " + modificationDate +
                " Version: " + getVersion() + ".\n";
    }

    public Campaign(int campaignID, int externalCampaignID,
                    Date startDate, Date endDate, int countControl,
                    int campaignOption, int type, String campaignName,
                    String description, Timestamp creationDate, Timestamp modificationDate, int version) {
        this.campaignID = campaignID;
        this.externalCampaignID = externalCampaignID;
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

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Timestamp modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}