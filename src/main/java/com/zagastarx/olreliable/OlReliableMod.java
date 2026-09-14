package com.zagastarx.olreliable;

import com.zagastarx.olreliable.item.ModItems;
import com.zagastarx.olreliable.item.OlReliableArmorMaterials;
import net.fabricmc.api.ModInitializer;

public class OlReliableMod implements ModInitializer {
    public static final String MOD_ID = "ol_reliable";

    @Override
    public void onInitialize() {
        OlReliableArmorMaterials.initialize();
        ModItems.initialize();
    }
}
