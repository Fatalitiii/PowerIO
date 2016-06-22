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

package com.fatality.powerio.api.tileentities;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityBase extends TileEntity {
	
	private String customName;
	private EnumFacing forward = EnumFacing.NORTH;
	
	public void setCustomeName(String name) {
		this.customName = name;
	}
	
	public boolean hasCustomName() {
		return (this.customName != null) && (this.customName.length() > 0);
	}
	
	public void setTier(NBTTagCompound nbtTagCompound) {
		
	}
	
	public boolean canBeRotated() {
		return false;
	}
	
	public EnumFacing getForward() {
		return forward;
	}
	
	public void setOrientation(EnumFacing forward) {
		this.forward = forward;
		markDirty();
	}
	
	public EnumFacing getDirection() {
		return forward;
	}
}
