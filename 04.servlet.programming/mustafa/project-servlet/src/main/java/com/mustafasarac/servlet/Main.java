package com.mustafasarac.servlet;

/**
 * Created by mustafasarac on 3.08.2016.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("\nJDBCProject MAIN ...");
        /*
        try{
            String insertQuery1 = "VALUES (MUSTAFA.CAMPAIGN_ID_INCREMENT.NEXTVAL,MUSTAFA.EXTERNAL_CAMPAIGN_ID_INCREMENT.NEXTVAL,to_date('01.08.2016','dd.MM.yyyy'),to_date('30.08.2016','dd.MM.yyyy'),5,1,2,'First Campaign','The description for this campaign',to_date('01.08.2016','dd.MM.yyyy'),to_date('02.08.2016','dd.MM.yyyy'),2)";
            String insertQuery2 = "VALUES (MUSTAFA.CAMPAIGN_ID_INCREMENT.NEXTVAL,MUSTAFA.EXTERNAL_CAMPAIGN_ID_INCREMENT.NEXTVAL,to_date('02.08.2016','dd.MM.yyyy'),to_date('30.08.2016','dd.MM.yyyy'),3,4,5,'Second Campaign','Example Description',to_date('01.08.2016','dd.MM.yyyy'),to_date('05.08.2016','dd.MM.yyyy'),3)";

            DatabaseQuery.insert(insertQuery1);
            DatabaseQuery.select();
            System.out.println("\n UPDATING!!!\n");
            DatabaseQuery.update();
            DatabaseQuery.insert(insertQuery2);
            DatabaseQuery.select();
            DatabaseQuery.delete(2);
            System.out.println("\n The object with CampaignID equal to '1' is deleted !!! \n ");
            DatabaseQuery.select();

            DatabaseQuery.close();
        } catch (Exception e){
            e.printStackTrace();
        }*/
    }
}
