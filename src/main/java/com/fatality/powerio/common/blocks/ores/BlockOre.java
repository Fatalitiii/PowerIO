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

package com.fatality.powerio.common.blocks.ores;

import com.fatality.powerio.api.blocks.BlockBase;
import com.fatality.powerio.utils.EnumOreTypes;
import com.fatality.powerio.utils.EnumOres;
import com.fatality.powerio.utils.PowerIOCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;

import java.util.List;

public class BlockOre extends BlockBase {
	
	public static PropertyEnum ORES = PropertyEnum.create("oretype", EnumOres.class);
	
	public BlockOre() {
		super(Material.ROCK, "ore", "ores");
		this.setDefaultState(this.blockState.getBaseState().withProperty(ORES, EnumOres.byMeta(6)));
		this.setCreativeTab(PowerIOCreativeTabs.ORES);
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		if (meta < 6)
			meta = 6;
		return this.getDefaultState().withProperty(ORES, EnumOres.byMeta(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		if (((EnumOres) state.getValue(ORES)).getMeta() < 6)
			return 6;
		return ((EnumOres) state.getValue(ORES)).getMeta();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, ORES);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> subBlocks) {
		for (EnumOres ore : EnumOres.values()) {
			if (ore.isTypeSet(EnumOreTypes.ORE)) {
				subBlocks.add(new ItemStack(item, 1, ore.getMeta()));
			}
		}
	}
}