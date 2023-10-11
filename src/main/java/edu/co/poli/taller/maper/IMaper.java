package edu.co.poli.taller.maper;

public interface IMaper<I, O> {
    public O mapper(I in);
}
