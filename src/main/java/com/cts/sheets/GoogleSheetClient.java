package com.cts.sheets;

//import com.google.api.client.auth.oauth2.Credential;
//import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
//import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
//import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
//import com.google.api.client.http.HttpTransport;
//import com.google.api.client.json.JsonFactory;
//import com.google.api.client.json.jackson2.JacksonFactory;
//import com.google.api.services.sheets.v4.Sheets;
//import com.google.api.services.sheets.v4.model.ValueRange;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.List;

public class GoogleSheetClient
{

//    public static void main(String[] args) throws Exception{
//        String applicationName = "AppName";
//        String key = args[0];
//        String query = args[1];
//
//        SpreadsheetService service = new SpreadsheetService(applicationName);
//
//        URL url = FeedURLFactory.getDefault().getWorksheetFeedUrl(key, "public", "basic");
//
//        WorksheetFeed feed = service.getFeed(url, WorksheetFeed.class);
//        List<WorksheetEntry> worksheetList = feed.getEntries();
//        WorksheetEntry worksheetEntry = worksheetList.get(0);
//
//        ListQuery listQuery = new ListQuery(worksheetEntry.getListFeedUrl());
//        listQuery.setSpreadsheetQuery( query );
//
//        ListFeed listFeed = service.query( listQuery, ListFeed.class );
//        List<ListEntry> list = listFeed.getEntries();
//        for( ListEntry listEntry : list )
//        {
//            System.out.println( "content=[" + listEntry.getPlainTextContent() + "]");
//            CustomElementCollection elements = listEntry.getCustomElements();
//            System.out.println(
//                    " name=" + elements.getValue("name") +
//                            " age="  + elements.getValue("age") );
//        }
//    }

//    public static Sheets getSheetsService() throws Exception
//    {
//        Credential credential = null;//authorize();
//        JsonFactory JSON_FACTORY =
//                JacksonFactory.getDefaultInstance();
//        HttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
//        String APPLICATION_NAME = "My Project 52912";
//
//        return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
//                .setApplicationName(APPLICATION_NAME)
//                .build();
//    }

//    public static Credential authorize() throws IOException {
//        // Load client secrets.
//        InputStream in =
//                Quickstart.class.getResourceAsStream("/client_secret.json");
//        GoogleClientSecrets clientSecrets =
//                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));
//
//        // Build flow and trigger user authorization request.
//        GoogleAuthorizationCodeFlow flow =
//                new GoogleAuthorizationCodeFlow.Builder(
//                        HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
//                        .setDataStoreFactory(DATA_STORE_FACTORY)
//                        .setAccessType("offline")
//                        .build();
//        Credential credential = new AuthorizationCodeInstalledApp(
//                flow, new LocalServerReceiver()).authorize("user");
//        System.out.println(
//                "Credentials saved to " + DATA_STORE_DIR.getAbsolutePath());
//        return credential;
//    }

//    public static void main(String[] args) throws Exception {
////        Sheets.Spreadsheets.Get get;
////        get.setKey()
//        // TODO: Get an API key
//
////AIzaSyBQm9thgYoxdnf4jyuQqgyoEKRMgMpVXuo
//        // http://spreadsheets.google.com/tq?tq=select A,B,C,D&key=15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg
//
//        // Build a new authorized API client service.
//        Sheets service = getSheetsService();
//
//        // Prints the names and majors of students in a sample spreadsheet:
//        // https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
////        String spreadsheetId = "1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms";
//        String spreadsheetId = "15esEPiQ0jmjy5i0nduPXyfKYo1KsMzrhLy-O8mGynDg";
//        String range = "Class Data!A2:E";
//        ValueRange response = service.spreadsheets().values()
//                .get(spreadsheetId, range).setKey("AIzaSyBQm9thgYoxdnf4jyuQqgyoEKRMgMpVXuo")
//                .execute();
//        List<List<Object>> values = response.getValues();
//        if (values == null || values.size() == 0) {
//            System.out.println("No data found.");
//        } else {
//            System.out.println("Name, Major");
//            for (List row : values) {
//                // Print columns A and E, which correspond to indices 0 and 4.
//                System.out.printf("%s, %s\n", row.get(0), row.get(4));
//            }
//        }
//    }

}
