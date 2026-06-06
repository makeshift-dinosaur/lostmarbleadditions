package net.jesterslover.lostmarble;

import net.fabricmc.api.ModInitializer;

import net.jesterslover.lostmarble.creativemodetab.ModCreativeModeTabs;
import net.jesterslover.lostmarble.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LostMarbleAdditions implements ModInitializer {
	public static final String MOD_ID = "lostmarbleadditions";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModCreativeModeTabs.registerModCreativeModeTabs();

		ModItems.registerModItems();
	}
}