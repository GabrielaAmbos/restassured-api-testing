package br.com.restassuredapitesting.utils;

import org.json.simple.JSONObject;

public class Utils {


    public static String getContractsBasePath(String pack, String contract) {
        return System.getProperty("user.dir")
                + "/src/test/java/br/com/restassuredapitesting/tests/"
                + pack
                + "/contracts/"
                + contract
                + ".json";
    }

    public static JSONObject validPayloadBooking() {
        JSONObject payload = new JSONObject();
        JSONObject bookingDates = new JSONObject();
        bookingDates.put("checkin", "2018-01-01");
        bookingDates.put("checkout", "2019-01-01");

        payload.put("firstname", "Jim");
        payload.put("lastname", "Brown");
        payload.put("totalprice", 111);
        payload.put("depositpaid", true);
        payload.put("bookingDates", bookingDates);
        payload.put("additionalneeds", "Breakfast");

        return payload;
    }
}
