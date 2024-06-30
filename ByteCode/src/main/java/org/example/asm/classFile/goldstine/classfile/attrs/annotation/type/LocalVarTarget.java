package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class LocalVarTarget {
    public final int table_length;
    public final Table[] tables;

    public LocalVarTarget(ByteDashboard bd) {
        this.table_length = bd.readUnsignedShort();
        this.tables = new Table[table_length];
        for (int i = 0; i < table_length; i++) {
            this.tables[i] = new Table(bd);
        }
    }
}
