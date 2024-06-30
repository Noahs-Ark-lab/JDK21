package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public final class StackMapTable extends AttributeInfo {
    public final int number_of_entries;
    public final StackMapFrame[] entries;

    public StackMapTable(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.number_of_entries = bd.readUnsignedShort();
        this.entries = new StackMapFrame[number_of_entries];
        for (int i = 0; i < number_of_entries; i++) {
            this.entries[i] = new StackMapFrame(bd, cp);
        }
    }

    @Override
    public void accept(Visitor obj) {
        obj.visitStackMapTable(this);
    }
}
