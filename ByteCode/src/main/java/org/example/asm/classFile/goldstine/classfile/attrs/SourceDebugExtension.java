package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class SourceDebugExtension extends AttributeInfo {
    public final byte[] debug_extension;

    public SourceDebugExtension(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);
        this.debug_extension = bd.nextN(attribute_length);
    }

    @Override
    public void accept(Visitor v) {
        v.visitSourceDebugExtension(this);
    }
}
