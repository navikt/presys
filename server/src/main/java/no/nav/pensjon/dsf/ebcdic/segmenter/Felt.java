package no.nav.pensjon.dsf.ebcdic.segmenter;

/**
 * Created by d132988 on 11.04.2017.
 */
public class Felt {
    private String feltNavn;
    private int byteLength;
    private boolean packed;
    private int unpackedLength;

    public Felt(String feltNavn, int byteLength, boolean packed, int unpackedLength) {
        this.feltNavn = feltNavn;
        this.byteLength = byteLength;
        this.packed = packed;
        this.unpackedLength = unpackedLength;
    }

    public String getFeltNavn() {
        return feltNavn;
    }

    public void setFeltNavn(String feltNavn) {
        this.feltNavn = feltNavn;
    }

    public int getByteLength() {
        return byteLength;
    }

    public void setByteLength(int byteLength) {
        this.byteLength = byteLength;
    }

    public boolean isPacked() {
        return packed;
    }

    public void setPacked(boolean packed) {
        this.packed = packed;
    }

    public int getUnpackedLength() {
        return unpackedLength;
    }

    public void setUnpackedLength(int unpackedLength) {
        this.unpackedLength = unpackedLength;
    }
}
