package ru.k_kiselev.zilabandroid.encryption;

import java.util.Random;

public class EncryptionProtocol {

    public final static int SHIFT = 3;
    public final static int SIZE = 8;
    public final static int REST = SIZE - SHIFT;

    public static int[] gamma = new int[SIZE];
    private static Random random = new Random();

    public static void generateGamma() {
        for(int i = 0; i < SIZE; i++){
            gamma[i] = random.nextInt(2);
        }
    }
}
