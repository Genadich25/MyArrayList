package ru.lookBag;

import ru.lookBag.exception.IndexOutException;
import ru.lookBag.exception.NegativeIndexException;
import ru.lookBag.exception.NotFoundException;
import ru.lookBag.exception.NullStringListException;

public class StringList implements StringListInt{
    private String[] strings;
    int sizeArray;
    int factSize = 0;

    public StringList() {
        this.strings = new String[5];
        this.sizeArray = 5;
    }

    @Override
    public String add(String item) {
        strings[factSize] = item;
        factSize++;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if(index < 0){
            throw new NegativeIndexException();
        }
        if(index > sizeArray - 1 || index >= factSize){
            throw new IndexOutException();
        }
        for (int i = factSize ; i >= index; i--) {
            strings[i + 1] = strings[i];
        }
        strings[index] = item;
        factSize++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        if(index < 0){
            throw new NegativeIndexException();
        }
        if(index > sizeArray - 1 || index >= factSize){
            throw new IndexOutException();
        }
        strings[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        for (int i = 0; i < factSize; i++) {
            if(strings[i].equals(item)){
                for (int j = i; j <= strings.length - 2; j++) {
                    strings[j] = strings[j + 1];
                }
                factSize--;
                return item;
            }
        }
        throw new NotFoundException();
    }

    @Override
    public String remove(int index) {
        if(index < 0){
            throw new NegativeIndexException();
        }
        if(index > sizeArray - 1 || index >= factSize){
            throw new IndexOutException();
        }
        String string = strings[index];
        for (int i = index; i < factSize; i++) {
            strings[i] = strings[i + 1];
        }
        factSize--;
        return string;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < factSize; i++) {
            if(strings[i].equals(item)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < factSize; i++) {
            if(strings[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = factSize - 1; i > 0; i--) {
            if(strings[i].equals(item)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if(index < 0){
            throw new NegativeIndexException();
        }
        if(index >= factSize){
            throw new IndexOutException();
        }
        return strings[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if(otherList == null){
            throw new NullStringListException();
        }
        if(factSize == otherList.size()){
            for (int i = 0; i < factSize; i++) {
                if(!strings[i].equals(otherList.get(i))){
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
        if( factSize == 0 ){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        for (int i = 0; i < strings.length; i++) {
            strings[i] = null;
        }
        factSize = 0;
    }

    @Override
    public String[] toArray() {
        String[] cloneArray = new String[factSize];
        int count = 0;
        for (int i = 0; i < sizeArray; i++) {
            if(strings[i] != null){
                cloneArray[count] = strings[i];
                count++;
            }
        }
        return cloneArray;
    }
}