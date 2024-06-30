package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class MethodParameters extends AttributeInfo {
    public final int parameters_count;
    public final MethodParameter[] parameters;

    public MethodParameters(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.parameters_count = bd.readUnsignedByte();
        this.parameters = new MethodParameter[parameters_count];
        for(int i=0; i<parameters_count; i++) {
            this.parameters[i] = new MethodParameter(bd);
        }
    }

    public void accept(Visitor v) {
        v.visitMethodParameters(this);
    }
}
