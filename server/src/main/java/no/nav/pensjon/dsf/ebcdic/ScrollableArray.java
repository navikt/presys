package no.nav.pensjon.dsf.ebcdic;

import java.util.Arrays;

public class ScrollableArray {
    private final byte[] data;
    private int pointer = 0;

    public ScrollableArray(byte[] data) {
        this.data = data;
    }

    public byte[] read(int length){
        byte[] readValue = peekAhead(0, length);
        scroll(length);
        return readValue;
    }

    public byte[] peekAhead(int offset, int length){
        return Arrays.copyOfRange(data, pointer + offset, length + pointer + offset);
    }

    public void scroll(int length){
        pointer += length;
    }

    public byte[] getData(){
        return data;
    }

    public ScrollableArray getCopy(){
        ScrollableArray copy = new ScrollableArray(data);
        copy.scroll(pointer);
        return copy;
    }
}

