package org.example.asm.classFile.goldstine.classfile;

import org.example.asm.classFile.goldstine.utils.HexUtils;

public abstract class Node {
    public byte[] bytes;
    public String value;

    public String hex() {
        return HexUtils.toHex(this.bytes);
    }
}
