package org.example.asm.classFile.goldstine.classfile.cp;

import org.example.asm.classFile.goldstine.cst.CPConst;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.utils.ByteUtils;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class ConstantClass extends Constant {
    public final int name_index;

    public ConstantClass(ByteDashboard bd) {
        super(CPConst.CONSTANT_Class);

        byte[] tag_bytes = bd.nextN(1);
        byte[] name_index_bytes = bd.nextN(2);

        this.name_index = ByteUtils.bytesToInt(name_index_bytes);
        super.value = "#" + this.name_index;
        super.bytes = ByteUtils.concatenate(tag_bytes, name_index_bytes);
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitConstantClass(this);
    }
}
