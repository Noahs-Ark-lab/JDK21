package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.attrs.annotation.AnnotationEntry;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class RuntimeInvisibleAnnotations extends AttributeInfo {
    public final int num_annotations;
    public final AnnotationEntry[] annotations;

    public RuntimeInvisibleAnnotations(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);


        this.num_annotations = bd.readUnsignedShort();
        this.annotations = new AnnotationEntry[num_annotations];

        for (int i = 0; i < num_annotations; i++) {
            AnnotationEntry item = new AnnotationEntry(bd, cp);
            this.annotations[i] = item;
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitRuntimeInvisibleAnnotations(this);
    }
}
