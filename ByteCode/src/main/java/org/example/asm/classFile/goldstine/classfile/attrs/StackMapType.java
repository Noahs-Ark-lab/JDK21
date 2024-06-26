package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.cst.StackMapConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public final class StackMapType {
    public final byte tag;
    public int index = -1; // Index to CONSTANT_Class or offset
    public ConstantPool cp;

    StackMapType(ByteDashboard bd, ConstantPool cp) {
        this.tag = bd.readByte();
        if (hasIndex()) {
            this.index = bd.readUnsignedShort();
        }
        this.cp = cp;
    }

    /**
     * @return true, if type is either ITEM_Object or ITEM_NewObject
     */
    public final boolean hasIndex() {
        return tag == StackMapConst.ITEM_Object || tag == StackMapConst.ITEM_NewObject;
    }

    private String printIndex() {
        if (tag == StackMapConst.ITEM_Object) {
            if (index < 0) {
                return ", class=<unknown>";
            }
            return ", class=" + cp.getConstantString(index, CPConst.CONSTANT_Class);
        } else if (tag == StackMapConst.ITEM_NewObject) {
            return ", offset=" + index;
        } else {
            return "";
        }
    }


    /**
     * @return String representation
     */
    @Override
    public final String toString() {
        return "(type=" + StackMapConst.getItemName(tag) + printIndex() + ")";
    }
}
