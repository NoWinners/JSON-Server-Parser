package org.tak.util.impl;

/**
 * User: Tommy
 * 6/5/13
 */

public class LocalLoader extends ItemDefLoader {
    @Override
    protected String getBaseURL() {
        return "http://localhost:8080/load/";
    }
}
