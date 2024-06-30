package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class Deprecated extends AttributeInfo {
    public Deprecated(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
    }

    @Override
    public void accept(Visitor v) {
        v.visitDeprecated(this);
    }
}
