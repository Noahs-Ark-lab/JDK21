package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class SourceFile extends AttributeInfo {
    public final int sourcefile_index;

    public SourceFile(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
        this.sourcefile_index = bd.readUnsignedShort();

        String value = cp.getConstantString(sourcefile_index, CPConst.CONSTANT_Utf8);
        super.value = value;
    }

    @Override
    public void accept(Visitor v) {
        v.visitSourceFile(this);
    }

}
