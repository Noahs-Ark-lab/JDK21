package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.attrs.annotation.type.TypeAnnotation;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class RuntimeVisibleTypeAnnotations extends AttributeInfo {
    public final int num_annotations;
    public final TypeAnnotation[] annotations;

    public RuntimeVisibleTypeAnnotations(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.num_annotations = bd.readUnsignedShort();
        this.annotations = new TypeAnnotation[num_annotations];

        for (int i = 0; i < num_annotations; i++) {
            this.annotations[i] = new TypeAnnotation(bd, cp);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitRuntimeVisibleTypeAnnotations(this);
    }
}
