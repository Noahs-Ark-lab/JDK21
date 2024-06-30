package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class Signature extends AttributeInfo {
    public final int signature_index;

    public Signature(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.signature_index = bd.readUnsignedShort();
        this.value = cp.getConstantString(signature_index, CPConst.CONSTANT_Utf8);
    }

    @Override
    public void accept(Visitor v) {
        v.visitSignature(this);
    }
}
