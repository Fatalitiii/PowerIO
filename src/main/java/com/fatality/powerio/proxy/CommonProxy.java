/**
 * Created by Fatality
 */

/* You are free to:
 *
 * Share — copy and redistribute the material in any medium or format
 * Adapt — remix, transform, and build upon the material
 * for any purpose, even commercially.
 * The licensor cannot revoke these freedoms as long as you follow the license terms.
 * Under the following terms:
 * Attribution — You must give appropriate credit, provide a link to the license, and indicate if changes were made. You may do so in any reasonable manner, but not in any way that suggests the licensor endorses you or your use.
 * ShareAlike — If you remix, transform, or build upon the material, you must distribute your contributions under the same license as the original.
 * No additional restrictions — You may not apply legal terms or technological measures that legally restrict others from doing anything the license permits.
 * Notices:
 *
 * You do not have to comply with the license for elements of the material in the public domain or where your use is permitted by an applicable exception or limitation.
 * No warranties are given. The license may not give you all of the permissions necessary for your intended use. For example, other rights such as publicity, privacy, or moral rights may limit how you use the material.
 */

package com.fatality.powerio.proxy;

import com.fatality.powerio.api.recipes.IRecipes;
import com.fatality.powerio.common.blocks.Blocks;
import com.fatality.powerio.common.items.Items;
import com.fatality.powerio.utils.EnumOreTypes;
import com.fatality.powerio.utils.EnumOres;
import net.minecraftforge.oredict.OreDictionary;

public class CommonProxy implements IProxy {
	@Override
	public void registerBlocks() {
		Blocks.registerBlocks();
	}
	
	@Override
	public void registerItems() {
		Items.registerItems();
	}
	
	@Override
	public void registerRecipes() {
		for (Items item : Items.values()) {
			if (item.getItem() instanceof IRecipes)
				((IRecipes) item.getItem()).RegisterRecipes();
		}
		
		for (Blocks block : Blocks.values()) {
			if (block.getBlock() instanceof IRecipes)
				((IRecipes) block.getBlock()).RegisterRecipes();
			
		}
	}
	
	@Override
	public void registerOreDict() {
		for (EnumOres ores : EnumOres.values()) {
			int meta = ores.getMeta();
			String oreName = ores.getName();
			
			if (ores.isTypeSet(EnumOreTypes.ORE))
				OreDictionary.registerOre("ore" + oreName, Blocks.BLOCK_ORE.getStack(1, meta));
			
			if (ores.isTypeSet(EnumOreTypes.INGOT))
				OreDictionary.registerOre("ingot" + oreName, Items.ITEM_ORE_INGOT.getStack(1, meta));
			
			if (ores.isTypeSet(EnumOreTypes.NUGGET))
				OreDictionary.registerOre("nugget" + oreName, Items.ITEM_ORE_NUGGET.getStack(1, meta));
			
			if (ores.isTypeSet(EnumOreTypes.DUST))
				OreDictionary.registerOre("dust" + oreName, Items.ITEM_ORE_DUST.getStack(1, meta));
			
		}
	}
	
	@Override
	public void registerWorldGen() {
		
	}
	
	@Override
	public void registerGUIs() {
		
	}
	
	@Override
	public void registerRenderers() {
		
	}
}