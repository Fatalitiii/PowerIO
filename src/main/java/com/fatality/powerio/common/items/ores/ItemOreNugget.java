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

package com.fatality.powerio.common.items.ores;

import com.fatality.powerio.api.items.ItemBase;
import com.fatality.powerio.api.recipes.IRecipes;
import com.fatality.powerio.api.recipes.ISmeltable;
import com.fatality.powerio.utils.EnumOreTypes;
import com.fatality.powerio.utils.EnumOres;
import com.fatality.powerio.utils.PowerIOCreativeTabs;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemOreNugget extends ItemBase implements IRecipes, ISmeltable {
	public ItemOreNugget() {
		super("nugget", "ores");
		this.setHasSubtypes(true);
		this.setCreativeTab(PowerIOCreativeTabs.ORES);
	}
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List<ItemStack> subItem) {
		for (EnumOres ore : EnumOres.values()) {
			if (ore.isTypeSet(EnumOreTypes.NUGGET)) {
				subItem.add(new ItemStack(this, 1, ore.getMeta()));
			}
		}
	}
	
	@Override
	public int getMetadata(int damage) {
		return damage;
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) {
		String name = super.getUnlocalizedName();
		String oreName = EnumOres.byMeta(stack.getItemDamage()).getUnlocalizedName();
		return String.format("%s.%s", name, oreName);
	}
	
	@Override
	public void RegisterRecipes() {
		
	}
	
	@Override
	public void RegisterSmeltable() {
		
	}
}
