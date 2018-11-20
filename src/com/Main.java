package com;

import javax.annotation.Resource;
import java.lang.annotation.*;
import java.lang.ref.Reference;

public class Main {
    public static void main(String[] args) {


    }
}
@BugReport(reportBy = "one", ref = @Reference)
@Deprecated
class MyClass {
    @Deprecated
    @MyAnn
    int i;

    @Deprecated
    public MyClass(int i) {
        this.i = i;
        @Deprecated @MyAnn int j;
    }

    public @Deprecated
    void method() {
    }
}

class Myclass2 extends MyClass {
    public Myclass2(int i) {
        super(i);
    }
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
@interface MyAnn {
    boolean run() default true;
    int i() default 1;
    //  String value(); @MyAnn (value="some",i=5)
}

@interface BugReport {
    enum Status {UNCONFIRMED, CONFIRMED, FIXED, NOTABUG};
    boolean showStopper() default false;
    String assignedTo() default "[none]";
    String assigned2To() default "";
    //    String assigned3To()default "[none]"+ new String ("");
//    String assigned2To()default null;
    int i() default 1 + 1;
    Class<?> testCase() default Void.class;
    BugReport.Status status() default BugReport.Status.UNCONFIRMED;
    Reference ref() default @Reference();//an annotation type
    String[] reportBy();
}


































