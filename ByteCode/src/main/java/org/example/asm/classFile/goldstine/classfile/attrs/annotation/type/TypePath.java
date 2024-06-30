package org.example.asm.classFile.goldstine.classfile.attrs.annotation.type;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;

public class TypePath {
    public final int path_length;
    public final Path[] pathes;

    public TypePath(ByteDashboard bd) {
        this.path_length = bd.readUnsignedByte();
        this.pathes = new Path[path_length];
        for (int i = 0; i < path_length; i++) {
            this.pathes[i] = new Path(bd);
        }
    }
}
