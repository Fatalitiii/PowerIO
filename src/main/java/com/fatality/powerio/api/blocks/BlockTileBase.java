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

package com.fatality.powerio.api.blocks;

import com.fatality.powerio.api.tileentities.TileEntityBase;
import com.fatality.powerio.utils.ModInfo;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;

import javax.annotation.Nonnull;

public class BlockTileBase extends BlockBase implements ITileEntityProvider {
	
	protected static final PropertyEnum FACING = PropertyEnum.create("facing", EnumFacing.class);
	
	@Nonnull
	private Class<? extends TileEntity> tileEntityClass;
	
	public BlockTileBase(Material material, String unlocalName, String resource, final Class<? extends TileEntity> clazz) {
		super(material, unlocalName, resource);
		this.setTileEntity(clazz);
	}
	
	protected void setTileEntity(final Class<? extends TileEntity> clazz) {
		this.tileEntityClass = clazz;
		this.isBlockContainer = true;
		
		String tileName = "tileentity." + ModInfo.MOD_ID + "." + clazz.getSimpleName();
		GameRegistry.registerTileEntity(this.tileEntityClass, tileName);
	}
	
	public Class<? extends TileEntity> getTileEntityClass() {
		return this.tileEntityClass;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		try {
			return this.tileEntityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException ex) {
			throw new IllegalStateException("Failed to create a new instance " + this.tileEntityClass, ex);
		}
	}
	
	@Override
	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
		TileEntityBase tileEntity = ((TileEntityBase) world.getTileEntity(pos));
		
		if (tileEntity == null)
			return;
		
		if (stack.hasTagCompound() && stack.getTagCompound().hasKey("TeirData")) {
			tileEntity.setTier(stack.getTagCompound().getCompoundTag("TeirData"));
		}
		
		if (stack.hasDisplayName()) {
			tileEntity.setCustomeName(stack.getDisplayName());
		}
		
		if (tileEntity.canBeRotated()) {
			if (placer.isSneaking()) {
				tileEntity.setOrientation(placer.getHorizontalFacing());
			} else {
				tileEntity.setOrientation(placer.getHorizontalFacing().getOpposite());
			}
		}
	}
	
	
}
