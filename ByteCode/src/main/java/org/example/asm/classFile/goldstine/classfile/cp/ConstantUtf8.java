package org.example.asm.classFile.goldstine.classfile.cp;


import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.utils.ByteUtils;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class ConstantUtf8 extends Constant {
    public final int length;
    public final String utf8Value;

    ConstantUtf8(ByteDashboard bd) {
        super(CPConst.CONSTANT_Utf8);

        byte[] tag_bytes = bd.nextN(1);
        byte[] length_bytes = bd.nextN(2);
        int length = ByteUtils.bytesToInt(length_bytes);
        byte[] utf8_bytes = bd.nextN(length);

        this.length = length;
        this.utf8Value = ByteUtils.toModifiedUtf8(utf8_bytes);
        super.value = utf8Value;
        super.bytes = ByteUtils.concatenate(tag_bytes, length_bytes, utf8_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantUtf8(this);
    }

}
