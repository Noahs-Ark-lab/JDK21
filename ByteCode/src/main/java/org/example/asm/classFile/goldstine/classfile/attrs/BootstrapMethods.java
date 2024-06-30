package org.example.asm.classFile.goldstine.classfile.attrs;

import org.example.asm.classFile.goldstine.classfile.ConstantPool;
import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.vs.Visitor;

public class BootstrapMethods extends AttributeInfo {
    public final int num_bootstrap_methods;
    public final BootstrapMethod[] entries;

    public BootstrapMethods(ByteDashboard bd, ConstantPool cp) {
        super(bd, cp);

        this.num_bootstrap_methods = bd.readUnsignedShort();
        this.entries = new BootstrapMethod[num_bootstrap_methods];
        for (int i = 0; i < num_bootstrap_methods; i++) {
            this.entries[i] = new BootstrapMethod(bd);
        }
    }

    @Override
    public void accept(Visitor v) {
        v.visitBootstrapMethods(this);
    }
}
