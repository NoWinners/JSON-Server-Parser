package org.tak.util.loader;

import org.tak.util.commons.Definable;
import org.tak.util.commons.JSONAcceptor;
import org.tak.util.constants.RequestOutputKeys;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * User: Tommy
 * 6/10/13
 */

/**
 * Builds a <code>DefinitionRequest</code> by setting parameters to be passed on to the server.
 * @param <E> Definition class
 */
public class DefinitionRequestBuilder<E extends Definable & JSONAcceptor> {
    private final String url;
    private final Class<E> klass;
    private final HashMap<String, String> params = new HashMap<>();

    public DefinitionRequestBuilder(String url, Class<E> klass) {
        this.url = url;
        this.klass = klass;
    }

    public void setParameter(String name, String value) {
        params.put(name,value);
    }
    public void setIds(int... ids) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
            stringBuilder.append(ids[i]);
            if (i!=ids.length-1) {
                stringBuilder.append(",");
            }
        }
        params.put(RequestOutputKeys.IDS, stringBuilder.toString());
    }
    public void setNames(String... names) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < names.length; i++) {
            try {
                stringBuilder.append(URLEncoder.encode(names[i],"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (i!=names.length-1) {
                stringBuilder.append(",");
            }
        }
        params.put(RequestOutputKeys.NAMES, stringBuilder.toString());
    }
    private URL createURL() throws MalformedURLException {
        StringBuilder stringBuilder = new StringBuilder(url);
        if (params.containsKey("names")) {
            stringBuilder.append("name/");
        } else if (params.containsKey("ids")) {
            stringBuilder.append("id/");
        } else {
            throw new IllegalStateException("no ids or names set");
        }
        final Map.Entry<String,String>[] entries = params.entrySet().toArray(new Map.Entry[params.size()]);
        for (int i = 0; i < entries.length; i++) {
            stringBuilder.append(i == 0 ? '?' : '&');
            stringBuilder.append(entries[i].getKey()).append('=').append(entries[i].getValue());
        }
        return new URL(stringBuilder.toString());
    }

    /**
     * precondition: set the id's or name's
     * @return the DefinitionRequest that has been created
     */
    public DefinitionRequest<E> build() {
        try {
            return new DefinitionRequest<>(createURL(),klass);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
