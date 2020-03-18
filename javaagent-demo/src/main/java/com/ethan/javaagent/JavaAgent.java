package com.ethan.javaagent;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.Instrumentation;

public class JavaAgent {

    public static void premain(String agentArgs, Instrumentation inst) {
        inst.addTransformer(new DefineTransformer(), true);
    }

}
