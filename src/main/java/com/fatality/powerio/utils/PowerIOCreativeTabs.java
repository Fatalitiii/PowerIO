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

package com.fatality.powerio.utils;

import com.fatality.powerio.common.blocks.Blocks;
import com.fatality.powerio.common.items.Items;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class PowerIOCreativeTabs {
	public static final CreativeTabs MACHINES = new CreativeTabs(ModInfo.MOD_ID) {
		@Override
		public Item getTabIconItem() {
			return Blocks.BLOCK_CABLE.getStack().getItem();
		}
		
		@Override
		public String getTabLabel() {
			return ModInfo.MOD_ID + ".machines";
		}
	};
	
	public static final CreativeTabs TRANSPORT = new CreativeTabs(ModInfo.MOD_ID) {
		@Override
		public Item getTabIconItem() {
			return Blocks.BLOCK_CABLE.getStack().getItem();
		}
		
		@Override
		public String getTabLabel() {
			return ModInfo.MOD_ID + ".transport";
		}
	};
	
	public static final CreativeTabs ORES = new CreativeTabs(ModInfo.MOD_ID) {
		@Override
		public Item getTabIconItem() {
			return Items.ITEM_ORE_DUST.getItem();
		}
		
		@Override
		public String getTabLabel() {
			return ModInfo.MOD_ID + ".ores";
		}
	};
}