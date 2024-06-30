package org.example.asm.classFile.goldstine.classfile.cp;

import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.utils.ByteUtils;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class ConstantMethodHandle extends Constant {
    public final int reference_kind;
    public final int reference_index;

    ConstantMethodHandle(ByteDashboard bd) {
        super(CPConst.CONSTANT_MethodHandle);

        byte[] tag_bytes = bd.nextN(1);
        byte[] reference_kind_bytes = bd.nextN(1);
        byte[] reference_index_bytes = bd.nextN(2);

        this.reference_kind = ByteUtils.bytesToInt(reference_kind_bytes);
        this.reference_index = ByteUtils.bytesToInt(reference_index_bytes);

        super.value = "#" + reference_index;
        super.bytes = ByteUtils.concatenate(tag_bytes, reference_kind_bytes, reference_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantMethodHandle(this);
    }
}
