package org.avlasov.example.other.java;

import java.io.IOException;
import java.security.Security;

/**
 * Created By artemvlasov on 2018-10-30
 **/
public class JavaAnnotations {

    public static void main(String[] args) {
        int compare = Key.COMPARATOR.compare(new Key(1), new Key(2));
        Singleton.provider = Security.getProvider("test");
        int aConst = Obj.CONST;
        int version = C.VERSION;
        int max = JavaAnnotationsKt.MAX;
        JmvStatic.foo();
//        JmvStatic.bar();
        JmvStatic.Companion.foo();
        JmvStatic.Companion.bar();
        try {
            JavaAnnotationsKt.testThrows();
        } catch (IOException e) {
            System.out.println("IOException");
        }
        JavaAnnotationsKt.testNotNull(null);
    }

}
