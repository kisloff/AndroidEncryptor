package ru.k_kiselev.zilabandroid.utils;

import ru.k_kiselev.zilabandroid.encryption.EncryptionProtocol;

public class MathUtils {

    public static int[] sumArrays(int[] array1, int[] array2){
        int[] sum = new int[EncryptionProtocol.SIZE];

        for(int i = 0; i < EncryptionProtocol.SIZE; i++) {
            sum[i] = array1[i] ^ array2[i];
        }
        return sum;
    }

    public static int[] shift(int[] array, int shift){
        int rest = EncryptionProtocol.SIZE - shift;
        int[] shiftedArray = new int[EncryptionProtocol.SIZE];

        for (int i = 0; i < rest; i++) {
            shiftedArray[i] = array[i + shift];
        }

        for (int i = rest, n = 0; i < EncryptionProtocol.SIZE; i++, n++) {
            shiftedArray[i] = array[n];
        }
        return shiftedArray;
    }

}
