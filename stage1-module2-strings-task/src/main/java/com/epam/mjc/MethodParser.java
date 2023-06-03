package com.epam.mjc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MethodParser {

    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public static MethodSignature parseFunction(String signatureString) {
        MethodSignature methodSignature;
        String[] method = signatureString.split("[ (,)]");
        LinkedList<String> hs = new LinkedList<>(List.of(method));
        hs.removeIf(s -> s.equals(""));

        String accessModifier;
        int i = 0;
        if (hs.get(i).equals("public") || hs.get(i).equals("private") || hs.get(i).equals("protected")) {
            accessModifier = hs.get(i);
            i++;
        } else {
            accessModifier = null;
        }

        String returnType = hs.get(i);
        i++;
        String methodName = hs.get(i);
        if (i == hs.size() - 1) {
            methodSignature =  new MethodSignature(methodName);
            methodSignature.setAccessModifier(accessModifier);
            methodSignature.setReturnType(returnType);
            return methodSignature;
        } else {
            List<MethodSignature.Argument> argumentList = new ArrayList<>();
            i++;
            while (i < method.length - 1) {
                argumentList.add(new MethodSignature.Argument(method[i], method[i + 1]));
                i += 3;
            }
            methodSignature =  new MethodSignature(methodName, argumentList);
            methodSignature.setAccessModifier(accessModifier);
            methodSignature.setReturnType(returnType);
            return methodSignature;
        }
    }
}
