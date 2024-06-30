package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class EnclosingMethod extends AttributeInfo {
    public final int class_index;
    public final int method_index;

    public EnclosingMethod(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.class_index = bd.readUnsignedShort();
        this.method_index = bd.readUnsignedShort();
    }

    @Override
    public void accept(Visitor v) {
        v.visitEnclosingMethod(this);
    }
}
