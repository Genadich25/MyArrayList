package ru.lookBag;

import ru.lookBag.exception.IndexOutException;
import ru.lookBag.exception.NegativeIndexException;
import ru.lookBag.exception.NotFoundException;
import ru.lookBag.exception.NullStringListException;

import java.util.Arrays;
import java.util.Random;

public class IntList implements IntListImpl {
    private int[] ints1;
    private int sizeArray;
    private int factSize = 0;

    public IntList() {
        this.ints1 = generateRandomArray();
        this.sizeArray = ints1.length;
        this.factSize = 100_000;
    }

    @Override
    public int add(int item) {
        ints1[factSize] = item;
        factSize++;
        return item;
    }

    @Override
    public int add(int index, int item) {
        if (index < 0) {
            throw new NegativeIndexException();
        }
        if (index > sizeArray - 1 || index >= factSize) {
            throw new IndexOutException();
        }
        for (int i = factSize; i >= index; i--) {
            ints1[i + 1] = ints1[i];
        }
        ints1[index] = item;
        factSize++;

        return item;
    }

    @Override
    public int set(int index, int item) {
        if (index < 0) {
            throw new NegativeIndexException();
        }
        if (index > sizeArray - 1 || index >= factSize) {
            throw new IndexOutException();
        }
        ints1[index] = item;
        return item;
    }

    @Override
    public int remove(int item) {
        for (int i = 0; i < factSize; i++) {
            if (ints1[i] == item) {
                for (int j = i; j <= ints1.length - 2; j++) {
                    ints1[j] = ints1[j + 1];
                }
                factSize--;
                return item;
            }
        }
        throw new NotFoundException();
    }

    @Override
    public int removeForIndex(int index) {
        if (index < 0) {
            throw new NegativeIndexException();
        }
        if (index > sizeArray - 1 || index >= factSize) {
            throw new IndexOutException();
        }
        int intArray = ints1[index];
        for (int i = index; i < factSize; i++) {
            ints1[i] = ints1[i + 1];
        }
        factSize--;
        return intArray;
    }

    @Override
    public boolean contains(int[] arr, int element) {
        IntList.sortInsertion(arr);
        int min = 0;
        int max = arr.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == arr[mid]) {
                return true;
            }

            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public int indexOf(int item) {
        for (int i = 0; i < factSize; i++) {
            if (ints1[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int item) {
        for (int i = factSize - 1; i > 0; i--) {
            if (ints1[i] == item) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        if (index < 0) {
            throw new NegativeIndexException();
        }
        if (index >= factSize) {
            throw new IndexOutException();
        }
        return ints1[index];
    }

    @Override
    public boolean equals(IntList otherList) {
        if (otherList == null) {
            throw new NullStringListException();
        }
        if (factSize == otherList.size()) {
            for (int i = 0; i < factSize; i++) {
                if (ints1[i] != otherList.get(i)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return factSize;
    }

    @Override
    public boolean isEmpty() {
        if (factSize == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < ints1.length; i++) {
            ints1[i] = 0;
        }
        factSize = 0;
    }

    @Override
    public int[] toArray() {
        int[] cloneArray = new int[factSize];
        int count = 0;
        for (int i = 0; i < sizeArray; i++) {
            if (ints1[i] != 0) {
                cloneArray[count] = ints1[i];
                count++;
            }
        }
        return cloneArray;
    }

    private static int[] generateRandomArray() {
        Random random = new Random();
        int[] arr = new int[100_000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(1_000_000);
        }
        return arr;
    }

    private static void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    private static void swapElements(int[] arr, int indexA, int indexB) {
        int tmp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = tmp;
    }
}
