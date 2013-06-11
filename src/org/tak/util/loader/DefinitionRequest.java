package org.tak.util.loader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.tak.util.commons.Definable;
import org.tak.util.commons.JSONAcceptor;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * User: Tommy
 * 6/10/13
 */
public class DefinitionRequest<E extends Definable & JSONAcceptor> {
    private final URL url;
    private final Class<E> klass;
    public DefinitionRequest(URL url, Class<E> klass) {
        this.url = url;
        this.klass = klass;
    }
    public List<E> load() throws IOException, ParseException, IllegalAccessException, InstantiationException {
        URLConnection urlConnection = url.openConnection();
        urlConnection.setConnectTimeout(15000);
        JSONParser jsonParser = new JSONParser();
        List<E> list = new ArrayList<>();
        JSONArray object = (JSONArray) jsonParser.parse(new InputStreamReader(urlConnection.getInputStream()));
        Iterator<JSONObject> iterator = object.iterator();
        while (iterator.hasNext()) {
            JSONObject jsonObject = iterator.next();
            if (jsonObject!=null) {
                E e = klass.newInstance();
                e.accept(jsonObject);
                list.add(e);
            }
        }
        return list;
    }

}
