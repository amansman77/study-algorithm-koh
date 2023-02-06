package com.ho.study.algorithm.koh.compression;

public class RunKey {

    private byte symbol;
    private Integer runLength;

    public RunKey(byte symbol, Integer runLength) {
        this.symbol = symbol;
        this.runLength = runLength;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + symbol;
        result = prime * result + ((runLength == null) ? 0 : runLength.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RunKey other = (RunKey) obj;
        if (symbol != other.symbol)
            return false;
        if (runLength == null) {
            if (other.runLength != null)
                return false;
        } else if (!runLength.equals(other.runLength))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RunKey [symbol=" + symbol + ", runLength=" + runLength + "]";
    }

}
