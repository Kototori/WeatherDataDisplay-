package com.mycompany.weatherdatadisplay.model;

import org.json.simple.JSONArray;

/**
 *
 * @author Robinson
 */
public abstract class banco {
    private static JSONArray jsonArray = new JSONArray();
    private static StringBuilder XMLArray = new StringBuilder();

    public static StringBuilder getXMLArray() {
        return XMLArray;
    }

     public static JSONArray getJsonArray() {
        return jsonArray;
    }

    public static void setXMLArray(StringBuilder XMLArray) {
        banco.XMLArray = XMLArray;
    }   

    public static void setJsonArray(JSONArray jsonArray) {
        banco.jsonArray = jsonArray;
    }
}
