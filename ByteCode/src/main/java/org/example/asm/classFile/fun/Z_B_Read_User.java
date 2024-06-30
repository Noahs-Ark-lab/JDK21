package org.example.asm.classFile.fun;

import org.example.asm.classFile.goldstine.utils.ByteDashboard;
import org.example.asm.classFile.goldstine.utils.FileUtils;

public class Z_B_Read_User {
    public static void main(String[] args) {
        String relative_path = "fun/user_info.bin";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = FileUtils.readBytes(filepath);

        ByteDashboard bd = new ByteDashboard(bytes);
        User user = FunUtils.parseUser(bd);
        System.out.println(user);
    }
}
