package com.rplbo.projectrekeninginheritance;

public class RekeningBisnis extends Rekening {

    // Konstruktor tanpa saldo awal
    public RekeningBisnis(Nasabah nasabah) {
        super(nasabah);
    }

    // Konstruktor dengan saldo awal
    public RekeningBisnis(Nasabah nasabah, int saldo) {
        super(nasabah, saldo);
    }

    // Penyetoran dengan bunga (misal 5%)
    @Override
    public void penyetoran(int jumlah) {
        if (jumlah > 0) {
            int total = jumlah + (int) bunga(jumlah);
            setSaldo(getSaldo() + total);
        }
    }

    // Bunga rekening bisnis (5%)
    private double bunga(int jumlah) {
        return jumlah * 0.05;
    }
}