package org.tak.util.impl;

/**
 * User: Tommy
 * 6/3/13
 */

import org.tak.util.definitions.DefinableDef;
import org.tak.util.loader.AbstractLoader;

/**
 * @author Tak
 * An implemntation of AbstractLoader for NPC's
 * @see org.tak.util.loader.AbstractLoader
 */
public class NPCDefLoader extends AbstractLoader<DefinableDef> {
    private static final String BASE_URL = "http://npcloader.appspot.com/load/";


    @Override
    protected String getBaseURL() {
        return BASE_URL;
    }

    @Override
    protected Class<DefinableDef> getDefClass() {
        return DefinableDef.class;
    }
}
