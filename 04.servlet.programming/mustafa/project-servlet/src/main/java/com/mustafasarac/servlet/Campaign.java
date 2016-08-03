package com.mustafasarac.servlet;

import java.sql.Date;
import java.sql.Timestamp;

/**
 * Created by mustafasarac on 3.08.2016.
 */

public class Campaign {
    private static int campaignID;
    private static int externalCampaignID;
    private static Date startDate;
    private static Date endDate;
    private static int countControl;
    private static int campaignOption;
    private static int type;
    private static String campaignName;
    private static String description;
    private static Timestamp creationDate;
    private static Timestamp modificationDate;
    private static int version;

    @Override
    public String toString() {
        return "Campaign: CampaignID: " + getCampaignID() + " External CampaignID: " + getExternalCampaignID() +
                " Start Date: " + getStartDate() + " End Date: " + getEndDate() + "Count Control: " + getCountControl() +
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



    public static int getCampaignID() {
        return campaignID;
    }

    public static void setCampaignID(int campaignID) {
        Campaign.campaignID = campaignID;
    }

    public static int getExternalCampaignID() {
        return externalCampaignID;
    }

    public static void setExternalCampaignID(int externalCampaignID) {
        Campaign.externalCampaignID = externalCampaignID;
    }

    public static Date getStartDate() {
        return startDate;
    }

    public static void setStartDate(Date startDate) {
        Campaign.startDate = startDate;
    }

    public static Date getEndDate() {
        return endDate;
    }

    public static void setEndDate(Date endDate) {
        Campaign.endDate = endDate;
    }

    public static int getCountControl() {
        return countControl;
    }

    public static void setCountControl(int countControl) {
        Campaign.countControl = countControl;
    }

    public static int getCampaignOption() {
        return campaignOption;
    }

    public static void setCampaignOption(int campaignOption) {
        Campaign.campaignOption = campaignOption;
    }

    public static int getType() {
        return type;
    }

    public static void setType(int type) {
        Campaign.type = type;
    }

    public static String getCampaignName() {
        return campaignName;
    }

    public static void setCampaignName(String campaignName) {
        Campaign.campaignName = campaignName;
    }

    public static String getDescription() {
        return description;
    }

    public static void setDescription(String description) {
        Campaign.description = description;
    }

    public static Timestamp getCreationDate() {
        return creationDate;
    }

    public static void setCreationDate(Timestamp creationDate) {
        Campaign.creationDate = creationDate;
    }

    public static Timestamp getModificationDate() {
        return modificationDate;
    }

    public static void setModificationDate(Timestamp modificationDate) {
        Campaign.modificationDate = modificationDate;
    }

    public static int getVersion() {
        return version;
    }

    public static void setVersion(int version) {
        Campaign.version = version;
    }
}