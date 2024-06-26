package org.example.asm.classFile.goldstine.classfile.attrs.annotation;


import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public final class AnnotationElementValue extends ElementValue {
    // For annotation element values, this is the annotation
    public final AnnotationEntry annotation_entry;

    public AnnotationElementValue(ByteDashboard bd, ConstantPool cp) {
        super(bd);

        this.annotation_entry = new AnnotationEntry(bd, cp);
    }

    @Override
    public String stringifyValue() {
        return null;
    }
}
