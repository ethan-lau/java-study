package com.ethan.javaagent;

import javassist.*;
import javassist.bytecode.AccessFlag;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import java.util.*;

public class DefineTransformer implements ClassFileTransformer {

    final static String enterPattern = "com.ethan.javaagent.PrintMethod.enterMethod(\"%s\");";
    final static String leavePattern = "com.ethan.javaagent.PrintMethod.leaveMethod(\"%s\");";
    // 被处理的方法列表
    final static List<String> wroteMethod = new ArrayList<>();

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        className = className.replace("/", ".");

        if (className.startsWith("org.springframework") && !className.startsWith("org.springframework.util")) {
            CtClass ctclass = null;
            try {
                ctclass = ClassPool.getDefault().get(className);// 使用全称,用于取得字节码类<使用javassist>

                for (CtMethod ctMethod : ctclass.getMethods()) {
                    if (Modifier.isAbstract(ctMethod.getModifiers())) {
                        continue;
                    }
                    if (Modifier.isNative(ctMethod.getModifiers())) {
                        continue;
                    }
                    if (!ctMethod.getLongName().startsWith(className)) {
                        continue;
                    }
                    if (wroteMethod.contains(ctMethod.getLongName())) {
                        continue;
                    }
                    wroteMethod.add(ctMethod.getLongName());
                    ctMethod.insertBefore(String.format(enterPattern, ctMethod.getLongName()));
                    ctMethod.insertAfter(String.format(leavePattern, ctMethod.getLongName()), true);
                }
                return ctclass.toBytecode();
            } catch (Throwable e) {
                System.out.println("e.getMessage()" +e.getMessage());
                e.printStackTrace();
            }
        }
        return classfileBuffer;
    }

}
