package com.mustafasarac;

import com.mustafasarac.model.Campaign;
import com.mustafasarac.query.DatabaseQuery;

/**
 * Created by mustafasarac on 29.07.2016.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("\nJDBCProject has started ...");

        // Database Connection
        DatabaseQuery databaseQuery = new DatabaseQuery();
        databaseQuery.connect();

        // Campaign Object Creation
        // 1000 which represents the CampaignID and ExternalCampaignId is just for
        // filling the field in Construction. When it is inserting into the Database Table,
        // it gets a value from the Database Sequence.
        Campaign campaign = new Campaign(1000, 1000, databaseQuery.getDate("2016-08-01"), databaseQuery.getDate("2016-08-01"), 1, 2, 1, "Campaign_1", "First Campaign in Database Table", databaseQuery.getTimestamp("2016-08-01 09:30:15.032"), databaseQuery.getTimestamp("2016-08-02 09:15:21.221"), 1);

        // INSERT: inserting this Campaign Object into the table
        databaseQuery.insert(campaign);

        // UPDATE: inserting again the same object but for this one, its values will be updated
        databaseQuery.insert(campaign);

        campaign.setCampaignName("Campaign_2");
        campaign.setDescription("Second campaign in Database Table");
        databaseQuery.update(campaign);

        // READ: reading these objects from Database Table
        databaseQuery.select();

        // DELETE: deleting the object from Database Table
        databaseQuery.delete(campaign);

        // Closing Connection
        databaseQuery.close();
    }
}
