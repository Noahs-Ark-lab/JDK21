package org.example.asm.classFile.goldstine.classfile.cp;

import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.utils.ByteUtils;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class ConstantMethodType extends Constant {
    public final int descriptor_index;

    ConstantMethodType(ByteDashboard bd) {
        super(CPConst.CONSTANT_MethodType);

        byte[] tag_bytes = bd.nextN(1);
        byte[] descriptor_index_bytes = bd.nextN(2);

        this.descriptor_index = ByteUtils.bytesToInt(descriptor_index_bytes);
        super.value = "#" + descriptor_index;
        super.bytes = ByteUtils.concatenate(tag_bytes, descriptor_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantMethodType(this);
    }
}
