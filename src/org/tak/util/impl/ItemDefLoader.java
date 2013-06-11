package org.tak.util.impl;

import org.tak.util.definitions.ItemDef;
import org.tak.util.loader.AbstractLoader;

/**
 * User: Tommy
 * 6/5/13
 */

/**
 * @author Tak
 * An extension of <code>AbstractLoader</code> for Items
 * @see org.tak.util.loader.AbstractLoader
 */
public class ItemDefLoader extends AbstractLoader<ItemDef> {
    private static final String BASE_URL = "http://rsitemdef.appspot.com/load/";
    @Override
    protected String getBaseURL() {
        return BASE_URL;
    }

    @Override
    protected Class<ItemDef> getDefClass() {
        return ItemDef.class;
    }
}
