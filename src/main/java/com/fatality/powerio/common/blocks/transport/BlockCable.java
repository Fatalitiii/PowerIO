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

package com.fatality.powerio.common.blocks.transport;

import com.fatality.powerio.api.blocks.BlockTileBase;
import com.fatality.powerio.api.recipes.IRecipes;
import com.fatality.powerio.common.blocks.Blocks;
import com.fatality.powerio.common.tileentities.TileEntityCable;
import com.fatality.powerio.utils.EnumCableTiers;
import com.fatality.powerio.utils.PowerIOCreativeTabs;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;

import java.util.List;

import static com.fatality.powerio.common.blocks.ores.BlockOre.ORES;

public class BlockCable extends BlockTileBase implements IRecipes {
	
	public static PropertyEnum TIERS = PropertyEnum.create("tier", EnumCableTiers.class);

//	public static final IUnlistedProperty<Boolean> LINK_UP = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_up"));
//	public static final IUnlistedProperty<Boolean> LINK_DOWN = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_down"));
//	public static final IUnlistedProperty<Boolean> LINK_WEST = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_west"));
//	public static final IUnlistedProperty<Boolean> LINK_EAST = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_east"));
//	public static final IUnlistedProperty<Boolean> LINK_NORTH = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_north"));
//	public static final IUnlistedProperty<Boolean> LINK_SOUTH = new Properties.PropertyAdapter<Boolean>(PropertyBool.create("link_south"));
	
	public BlockCable() {
		super(Material.ROCK, "cable", "transport", TileEntityCable.class);
		this.setDefaultState(this.blockState.getBaseState().withProperty(TIERS, EnumCableTiers.byMeta(0)));
		this.setCreativeTab(PowerIOCreativeTabs.TRANSPORT);
	}
	
	@Override
	public void RegisterRecipes() {
		for (EnumCableTiers tier : EnumCableTiers.values()) {
			if (tier.getMeta() == 0) {
				GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.BLOCK_CABLE.getStack(1, tier.getMeta()),
						"RCR",
						"RCR",
						"RCR",
						'C', "ingotCopper",
						'R', "logWood"
				));
			}else{
				GameRegistry.addRecipe(new ShapedOreRecipe(Blocks.BLOCK_CABLE.getStack(1, tier.getMeta()),
						"RCR",
						"RCR",
						"RCR",
						'C', "chestWood",
						'R', "logWood"
				));
			}
		}
	}
	
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	public boolean isFullCube() {
		return false;
	}
	
	public int getRenderType() {
		return 3;
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) {
		return this.getDefaultState().withProperty(TIERS, EnumCableTiers.byMeta(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) {
		return ((EnumCableTiers) state.getValue(TIERS)).getMeta();
	}
	
	@Override
	protected BlockStateContainer createBlockState() {
		return new BlockStateContainer(this, TIERS);
	}
	
	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List<ItemStack> list) {
		for (EnumCableTiers i : EnumCableTiers.values()) {
			list.add(new ItemStack(item, 1, i.getMeta()));
		}
	}
}