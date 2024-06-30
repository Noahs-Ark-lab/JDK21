package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.attrs.annotation.ElementValue;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class AnnotationDefault extends AttributeInfo {
    public final ElementValue default_value;

    public AnnotationDefault(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
        this.default_value = ElementValue.readElementValue(bd, cp);
    }

    @Override
    public void accept(Visitor v) {
        v.visitAnnotationDefault(this);
    }
}
