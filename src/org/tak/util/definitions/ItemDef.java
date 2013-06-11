package org.tak.util.definitions;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.tak.util.commons.Definable;
import org.tak.util.commons.JSONAcceptor;

import java.util.Arrays;

/**
 * User: Tommy
 * 6/3/13
 */

/**
 * @author Tak
 * A implementation of <code>Definable</code> for Items.
 */
public class ItemDef implements Definable,JSONAcceptor {
    private String   name;
    private int      id;
    private int      price;
    private String[] inventoryActions;
    private String[] groundActions;
    private boolean  members;
    private boolean  noted;
    private boolean  stackable;
    private int      wieldLocation;


    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void accept(JSONObject jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.id = Integer.valueOf(String.valueOf(jsonObject.get("id")));
        this.price = Integer.valueOf(String.valueOf(jsonObject.get("storePrice")));
        this.inventoryActions = (String[]) parseArray((JSONArray) jsonObject.get("inventory"));
        this.groundActions = (String[]) parseArray((JSONArray) jsonObject.get("ground"));
        this.noted = (boolean) jsonObject.get("noted");
        this.members = (boolean) jsonObject.get("members");
        this.stackable = (boolean) jsonObject.get("stackable");
        this.wieldLocation = Integer.valueOf(String.valueOf(jsonObject.get("wieldLocation")));
    }

    public int getPrice() {
        return price;
    }
    public Object[] parseArray(JSONArray jsonArray) {
        return jsonArray.toArray(new String[jsonArray.size()]);
    }

    public String[] getInventoryActions() {
        return inventoryActions;
    }

    public String[] getGroundActions() {
        return groundActions;
    }

    public boolean isMembers() {
        return members;
    }

    public boolean isNoted() {
        return noted;
    }

    public boolean isStackable() {
        return stackable;
    }

    public int getWieldLocation() {
        return wieldLocation;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("ItemDef{");
        sb.append("name='").append(name).append('\'');
        sb.append(", id=").append(id);
        sb.append(", price=").append(price);
        sb.append(", inventoryActions=").append(Arrays.toString(inventoryActions));
        sb.append(", groundActions=").append(Arrays.toString(groundActions));
        sb.append(", members=").append(members);
        sb.append(", noted=").append(noted);
        sb.append(", stackable=").append(stackable);
        sb.append(", wieldLocation=").append(wieldLocation);
        sb.append('}');
        return sb.toString();
    }
}
