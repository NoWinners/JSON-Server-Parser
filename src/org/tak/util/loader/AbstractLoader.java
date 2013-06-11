package org.tak.util.loader;

import org.tak.util.commons.Definable;
import org.tak.util.commons.JSONAcceptor;

/**
 * User: Tommy
 * 6/3/13
 */
public abstract class AbstractLoader<E extends Definable & JSONAcceptor> {

    protected abstract String getBaseURL();


    protected abstract Class<E> getDefClass();

    public DefinitionRequestBuilder<E> newRequest() {
        return new DefinitionRequestBuilder<>(getBaseURL(),getDefClass());
    }



}
