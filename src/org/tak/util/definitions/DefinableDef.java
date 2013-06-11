package org.tak.util.definitions;

/**
 * User: Tommy
 * 6/3/13
 */

import org.json.simple.JSONObject;
import org.tak.util.commons.Definable;
import org.tak.util.commons.JSONAcceptor;

/**
 * @author Tak
 * A Definition implementation of <code>Definable</code> that stores a name and id.
 * This class can represent a GameObjectDefinition or a NPCDefinition since the information provided by the server
 * is the exact same so there's no reason to have seperate classes for them.
 */
public class DefinableDef implements Definable,JSONAcceptor {
    private int id;
    private String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }
    public String toString() {
        return getId()+"["+getName()+"]";
    }

    @Override
    public void accept(JSONObject jsonObject) {
        name = (String) jsonObject.get("name");
        id =  Integer.parseInt(String.valueOf(jsonObject.get("id")));
    }
}
