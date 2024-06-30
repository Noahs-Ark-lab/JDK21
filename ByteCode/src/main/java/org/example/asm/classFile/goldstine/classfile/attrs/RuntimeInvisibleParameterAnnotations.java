package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.classfile.attrs.annotation.ParameterAnnotation;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class RuntimeInvisibleParameterAnnotations extends AttributeInfo {
    public final int num_parameters;
    public final ParameterAnnotation[] parameter_annotations;

    public RuntimeInvisibleParameterAnnotations(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.num_parameters = bd.readUnsignedByte();
        this.parameter_annotations = new ParameterAnnotation[num_parameters];
        for (int i = 0; i < num_parameters; i++) {
            parameter_annotations[i] = new ParameterAnnotation(bd, cp);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitRuntimeInvisibleParameterAnnotations(this);
    }
}
