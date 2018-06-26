package com.prac.string;

public class PracticeProtectedConsumer extends PracticeProtected {



    public static void main(String[] args) {
        PracticeProtectedConsumer practiceProtected = new PracticeProtectedConsumer();
        practiceProtected.anotherProtectedConsumer();
    }

    private void anotherProtectedConsumer() {
        PracticeProtected practiceProtected = new PracticeProtected();
        practiceProtected.protectedMethod();
    }
}
