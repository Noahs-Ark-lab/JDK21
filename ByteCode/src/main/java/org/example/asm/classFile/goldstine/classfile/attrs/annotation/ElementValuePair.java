package org.example.asm.classFile.goldstine.classfile.attrs.annotation;


import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class ElementValuePair {
    public final int element_name_index;
    public final ElementValue value;

    public ElementValuePair(ByteDashboard bd, ConstantPool cp) {
        this.element_name_index = bd.readUnsignedShort();
        this.value = ElementValue.readElementValue(bd, cp);
    }
}
