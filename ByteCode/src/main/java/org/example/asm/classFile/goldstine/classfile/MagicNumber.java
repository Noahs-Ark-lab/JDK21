package org.example.asm.classFile.goldstine.classfile;

import org.example.asm.classFile.goldstine.cst.JVMConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.utils.ByteUtils;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class MagicNumber extends Node {
    public MagicNumber(ByteDashboard bd) {
        super.bytes = bd.nextN(4);

        int magic = ByteUtils.bytesToInt(bytes, 0);
        if (magic != JVMConst.JVM_CLASSFILE_MAGIC) {
            throw new RuntimeException("It is not a Java .class file");
        }
    }

    public void accept(Visitor v) {
        v.visitMagicNumber(this);
    }
}
