package com.prac;

public class CustomRandom {

    int last;
    int range;

    public CustomRandom(int range) {
        this.range = range;
        this.last = (int) (System.currentTimeMillis() % range);
    }

    public static void main(String[] args) {

        CustomRandom random = new CustomRandom(100);

        for (int i = 0; i < 10; i++) {
            System.out.println(random.nextInt());
        }
    }

    private int nextInt() {
        last =  (last * 17) % 37219;
        return last % range;
    }
}
