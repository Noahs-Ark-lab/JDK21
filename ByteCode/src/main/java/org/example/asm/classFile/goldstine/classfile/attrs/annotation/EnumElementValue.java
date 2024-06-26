package org.example.asm.classFile.goldstine.classfile.attrs.annotation;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public final class EnumElementValue extends ElementValue {
    public final int type_name_index;
    public final int const_name_index;

    public EnumElementValue(ByteDashboard bd, ConstantPool cp) {
        super(bd);

        this.type_name_index = bd.readUnsignedShort();
        this.const_name_index = bd.readUnsignedShort();

        String type_name = cp.getConstantString(type_name_index, CPConst.CONSTANT_Utf8);
        String const_name = cp.getConstantString(const_name_index, CPConst.CONSTANT_Utf8);
        this.value = const_name + ":" + type_name;
    }

    @Override
    public String stringifyValue() {
        return this.value;
    }
}
