package org.tak.util;

import org.json.simple.parser.ParseException;
import org.tak.util.constants.RequestOutputKeys;
import org.tak.util.definitions.DefinableDef;
import org.tak.util.definitions.ItemDef;
import org.tak.util.impl.ItemDefLoader;
import org.tak.util.impl.LocalLoader;
import org.tak.util.impl.NPCDefLoader;
import org.tak.util.loader.DefinitionRequestBuilder;

import java.io.IOException;
import java.util.List;

/**
 * User: Tommy
 * 6/5/13
 */
@SuppressWarnings("unused")
public class Test {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            localTest();
        } catch (InstantiationException | ParseException | IllegalAccessException | IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-start);
    }

    /**
     * tests the local dev version of the ItemDefLoader
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ParseException
     * @throws IOException
     */
    public static void localTest() throws InstantiationException, IllegalAccessException, ParseException, IOException {
        LocalLoader localLoader = new LocalLoader();
        DefinitionRequestBuilder<ItemDef> requestBuilder = localLoader.newRequest();
        requestBuilder.setNames("Rune Scimitar", "Adamant scimitar", "rune mace");
        requestBuilder.setParameter(RequestOutputKeys.NOTED,"true");
        List<ItemDef> itemDefs = requestBuilder.build().load();
        System.out.println(itemDefs);
        requestBuilder = localLoader.newRequest();
        requestBuilder.setIds(1333,1444);
        itemDefs = requestBuilder.build().load();
        System.out.println(itemDefs);
    }

    /**
     * A test for the ItemDefLoader
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ParseException
     * @throws IOException
     */
    public static void testItems() throws InstantiationException, IllegalAccessException, ParseException, IOException {
        ItemDefLoader itemDefLoader = new ItemDefLoader();
        DefinitionRequestBuilder<ItemDef> requestBuilder = itemDefLoader.newRequest();
        requestBuilder.setNames("Rune Scimitar", "Adamant scimitar", "rune mace");
        List<ItemDef> itemDefs = requestBuilder.build().load();
        System.out.println(itemDefs);
    }

    /**
     * tests the NPCDefLoader
     * @throws InstantiationException
     * @throws IllegalAccessException
     * @throws ParseException
     * @throws IOException
     */
    public static void testNPCs() throws InstantiationException, IllegalAccessException, ParseException, IOException {
        NPCDefLoader npcDefLoader = new NPCDefLoader();
        DefinitionRequestBuilder<DefinableDef> requestBuilder = npcDefLoader.newRequest();
        requestBuilder.setNames("Wizard","man","woMan");
        List<DefinableDef> npcDefs = requestBuilder.build().load();
        System.out.println(npcDefs);
    }

}
